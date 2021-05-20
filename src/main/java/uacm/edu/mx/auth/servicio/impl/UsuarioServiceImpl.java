package uacm.edu.mx.auth.servicio.impl;

import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import uacm.edu.mx.auth.controller.AuthController;
import uacm.edu.mx.auth.domain.User;
import uacm.edu.mx.auth.domain.Usuario;
import uacm.edu.mx.auth.dto.UsuarioRequest;
import uacm.edu.mx.auth.mapper.UsuarioMapper;
import uacm.edu.mx.auth.repository.UserRepository;
import uacm.edu.mx.auth.repository.UsuarioRepository;
import uacm.edu.mx.auth.servicio.AuthService;
import uacm.edu.mx.auth.servicio.UsuarioService;

@Primary
@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UsuarioMapper usuarioMapper;

	@Autowired
	private AuthService authService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<String> addUsuario(UsuarioRequest usuarioRequest) {
		
		if (!authService.validaCorreo(usuarioRequest.getEmail())) {
			return ResponseEntity.badRequest().body("Error: Solo Email de la universidad!");
		} else if (userRepository.existsByEmail(usuarioRequest.getEmail())) {
			return ResponseEntity.badRequest().body("Error: Email ya esta en uso!");
		}

		String[] emailArreglo = usuarioRequest.getEmail().split("(@)");
		String userName = emailArreglo[0];

		if (userRepository.existsByUsername(userName)) {
			return ResponseEntity.badRequest().body("Error: Username ya existe!");
		}

		User user = usuarioMapper.emailToUser(usuarioRequest.getEmail());
		Usuario usuario = usuarioMapper.DtoToUsuario(usuarioRequest);
		user.setEnabled(true);
		user.setUsuario(usuario);
		String newPass = getPassword();
		user.setPassword(passwordEncoder.encode(newPass));
		userRepository.save(user);
//		mailService.sendMail(new NotificationEmail("Porfavor activa tu usuario", user.getEmail(),
//		"y gracias por registrarte a incidencia uacm, "
//				+ "click en la siguiente url para activar el uuario: "
//				+ "http://localhost:8080/api/auth/accountVerification/" + token));
// 		falta enviar correo con contraseñae al correo		
		return new ResponseEntity<>("Registro de usuario exitoso! password: " + newPass, OK);
	}

	
	
	@Override
	public ResponseEntity<String> deleteUsuario(String username) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();//recupera el token el nombre del usuario se encripta
		User user = userRepository.findByUsername(auth.getName())
				.orElseThrow(() -> new UsernameNotFoundException("Username no encontrado - " + auth.getName()));
		userRepository.delete(user);
		
		return new ResponseEntity<>("Borrado de usuario exitoso!", OK);
	}

	@Override
	public ResponseEntity<String> updateUsuario(UsuarioRequest usuarioRequest) {
		// TODO Auto-generated method stub
		return null;
		
	}

	
	@Override
	public Optional<User> getUsuario(String username) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			return Optional.of(userRepository.findByUsername(auth.getName()))
					.orElseThrow(() -> new UsernameNotFoundException("Username no encontrado - " + auth.getName()));

	}

	public static String getPassword() {

		String NUMEROS = "0123456789";
		String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
		String CARACTERESESPECIALES = "(?=.*[@#$%^&+=])";
		String key = NUMEROS + MAYUSCULAS + MINUSCULAS + CARACTERESESPECIALES;
		int tamanio = key.length();
		int tamPassword = (int) (Math.random() * 5 + 6);
		String pswd = "";

		do {
			for (int i = 0; i < tamPassword; i++) {
				pswd += (key.charAt((int) (Math.random() * tamanio)));
			}

		} while (!AuthController.checkPasswordLength(pswd));

		return pswd;

	}


}
