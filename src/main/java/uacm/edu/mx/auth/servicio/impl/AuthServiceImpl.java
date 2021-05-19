/**
 * 
 */
package uacm.edu.mx.auth.servicio.impl;

import static org.springframework.http.HttpStatus.OK;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uacm.edu.mx.auth.domain.User;
import uacm.edu.mx.auth.domain.VerificationToken;
import uacm.edu.mx.auth.dto.AuthenticationResponse;
import uacm.edu.mx.auth.dto.LoginRequest;
import uacm.edu.mx.auth.mapper.UsuarioMapper;
import uacm.edu.mx.auth.repository.UserRepository;
import uacm.edu.mx.auth.repository.VerificationTokenRepository;
import uacm.edu.mx.auth.servicio.AuthService;
import uacm.edu.mx.auth.servicio.UserDetailsImpl;
import uacm.edu.mx.exception.SpringUserException;
import uacm.edu.mx.security.jwt.JwtUtils;

/**
 * @author yonathan
 *
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtils jwtProvider;

	@Autowired
	UserRepository userRepository;

	@Autowired
	VerificationTokenRepository verificationTokenRepository;

	@Autowired
	UsuarioMapper usuarioMapper;

	@Override
	public ResponseEntity<String> signup(String email) {

		if (!validaCorreo(email)) {
			return ResponseEntity.badRequest().body("Error: Solo Email de la universidad!");
		} else if (userRepository.existsByEmail(email)) {
			return ResponseEntity.badRequest().body("Error: Email ya esta en uso!");
		}

		String[] emailArreglo = email.split("(@)");
		String userName = emailArreglo[0];

		if (userRepository.existsByUsername(userName)) {
			return ResponseEntity.badRequest().body("Error: Username ya existe!");
		}

		User user = usuarioMapper.emailToUser(email);
		user = userRepository.save(user);

		String token = generaVerificaciónToken(user);
		log.debug("http://localhost:8080/api/auth/accountVerification/" + token);
//		mailService.sendMail(new NotificationEmail("Porfavor activa tu usuario", user.getEmail(),
//				"y gracias por registrarte a incidencia uacm, "
//						+ "click en la siguiente url para activar el uuario: "
//						+ "http://localhost:8080/api/auth/accountVerification/" + token));
		// return new ResponseEntity<>("Registro de usuario exitosa!", OK);
		return new ResponseEntity<>(
				"Registro de usuario exitosa, https://incidencias-servicio-backend.herokuapp.com/api/auth/accountVerification/"
						+ token + " http://localhost:8080/api/auth/accountVerification/" + token,
				OK);
	}

	@Override
	public ResponseEntity<String> activarUsuarioBuscado(VerificationToken verificationToken) {
		String username = verificationToken.getUser().getUsername();
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new SpringUserException("Username no encontrado - " + username));
		user.setEnabled(true);
		userRepository.save(user);
		return new ResponseEntity<>("Cuenta activada correctamente", OK);
//		Calendar cal = Calendar.getInstance();
//		Long dateExpiry = cal.getTime().getTime() - verificationToken.getExpiryDate().getTime();
//
//		if (dateExpiry <= 2.628e+9) {
//			user.setEnabled(true);
//			userRepository.save(user);
//			return new ResponseEntity<>("Cuenta activada correctamente", OK);
//		} else {
//			return new ResponseEntity<>("el token no es válido o ya ha caducado, intenta de nuevo", OK);
//		}

	}

	@Override
	public String generaVerificaciónToken(User user) {

		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUser(user);

		verificationTokenRepository.save(verificationToken);
		return token;
	}

	@Override
	public ResponseEntity<String> verificarCuenta(String token) {
		Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
		return activarUsuarioBuscado(verificationToken.orElseThrow(() -> new SpringUserException("Token Invalido")));

	}

	@Override
	public ResponseEntity<?> login(LoginRequest loginRequest) {

		try {
			Authentication authenticate = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			
			log.debug("paso");
			
			if (userRepository.findByUsername(authenticate.getName()).get().isEnabled()) {

				SecurityContextHolder.getContext().setAuthentication(authenticate);

				String token = jwtProvider.generateToken(authenticate);

				UserDetailsImpl userDetails = (UserDetailsImpl) authenticate.getPrincipal();

				List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
						.collect(Collectors.toList());

				return ResponseEntity.ok(AuthenticationResponse.builder().authenticationToken(token)
						.username(loginRequest.getUsername()).roles(roles).build());
			} else {
				return ResponseEntity.badRequest().body("Usuario no activado, revisa tu correo electronico");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(" revisa tus datos");
		}

	}

	@Override
	public boolean isLoggedIn() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
	}

	/**
	 * Los usuarios no activo se borraran despues de 3 dias seran borrados a la 1:00
	 * (am).
	 */

	@Scheduled(cron = "0 0 1 * * ?")
	public void removeNotActivatedUsers() {
		userRepository.findAllByEnabledIsFalseAndCreatedDateBefore(Instant.now().minus(3, ChronoUnit.DAYS))
				.forEach(user -> {
					log.debug("Deleting not activated user {}", user.toString());
					userRepository.delete(user);
				});
	}

	/**
	 * Aqui se van a validar los correos de profesores y estudiantes. Falta
	 * implementar el de profesores.
	 */
	public boolean validaCorreo(String correo) {
		// String to be scanned to find the pattern.
		String pattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" + "(estudiante.|alumno.)*uacm.edu.mx";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(correo);

		return m.find();
	}

	public Optional<User> requestPasswordReset(String mail) {
		return userRepository.findOneByEmailIgnoreCase(mail).filter(User::isEnabled).map(user -> {
			generaVerificaciónToken(user);
			user.setResetKey(UUID.randomUUID().toString());
			user.setResetDate(new Date());
			//mailService.sendPasswordResetMail(user);
			return userRepository.save(user);
		});
	}

	public Optional<User> completePasswordReset(String newPassword, String key) {
		return userRepository.findOneByResetKey(key)
				.filter(user -> user.getResetDate().toInstant().isAfter(Instant.now().minusSeconds(300000))).map(user -> {
					log.info(user.toString());
					user.setPassword(passwordEncoder.encode(newPassword));
					user.setResetKey(null);
					user.setResetDate(null);
					return userRepository.save(user);
				});
	}

}
