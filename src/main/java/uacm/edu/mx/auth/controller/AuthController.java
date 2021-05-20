package uacm.edu.mx.auth.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import uacm.edu.mx.auth.domain.User;
import uacm.edu.mx.auth.dto.KeyAndNewPass;
import uacm.edu.mx.auth.dto.LoginRequest;
import uacm.edu.mx.auth.dto.PasswordResetRequest;
import uacm.edu.mx.auth.dto.RegisterRequest;
import uacm.edu.mx.auth.dto.UsuarioRequest;
import uacm.edu.mx.auth.repository.UserRepository;
import uacm.edu.mx.auth.servicio.AuthService;
import uacm.edu.mx.auth.servicio.UsuarioService;

@RestController
@RequestMapping("/api/auth")
@Api(value = "Users microservice", description = "API CRUD para users")
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
	public ResponseEntity handle() {
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("register")
	public ResponseEntity<String> Register(@Valid @RequestBody RegisterRequest registerRequest) {
		return authService.signup(registerRequest.getEmail());
	}

	@PostMapping("registerComplete")
	public ResponseEntity<String> RegisterComplete(@Valid @RequestBody UsuarioRequest usuarioRequest) {
		return usuarioService.addUsuario(usuarioRequest);

	}

	@GetMapping("accountVerification/{token}")
	public ResponseEntity<String> verifyAccount(@PathVariable String token) {
		return authService.verificarCuenta(token);
	}

	/**
	 * Petición para iniciar sesión {@code POST   /login} : Se validaran los datos y
	 * se retornaran un token mas el username.
	 * 
	 * @param LoginRequest :el username del usuario y su password.
	 */
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}

	/**
	 * Petición para la recuperación de contraseña incial
	 * {@code POST   /reset-password/init} : Se envía un correo electrónico para
	 * restablecer el contraseña del usuario junto con un token para validar. El
	 * token tiene tiempo de expiración de 5 min. Si el correo no exieste o la
	 * cuenta no a sido activada se notificara el error.
	 * 
	 * @param passwordResetRequest.mail :el correo del usuario.
	 */
	@PostMapping(path = "/reset-password/init")
	public ResponseEntity<String> initPasswordReset(@RequestBody PasswordResetRequest passwordResetRequest) {
		Optional<User> user = authService.requestPasswordReset(passwordResetRequest.getMail());
		if (user.isPresent()) {
			return new ResponseEntity<>("Se te envio un correo para restablecimiento de contraseña!", OK);
		} else {
			return ResponseEntity.badRequest().body(
					"Solicitud de restablecimiento de contraseña para correo no existente o no ha sido activada!");
		}
	}

	/**
	 * Petición para la recuperación de contraseña final
	 * {@code POST   /account/reset-password/finish} : Final de restablecimiento de
	 * la contraseña del usuario. El token sera validado para poder actualizar el
	 * password y el password tiene que cumplir que temga entre 6 y 18 caracteres.
	 * 
	 * @param keyAndPassword : La clave generada(Token) y la nueva contraseña..
	 */
	@PostMapping(path = "/reset-password/finish")
	public ResponseEntity<String> finishPasswordReset(@RequestBody KeyAndNewPass keyAndPassword) {
		if (!checkPasswordLength(keyAndPassword.getNewPassword())) {
			return ResponseEntity.badRequest().body("Formato no valido de password!");
		}
		Optional<User> user = authService.completePasswordReset(keyAndPassword.getNewPassword(),
				keyAndPassword.getKey());
		if (!user.isPresent()) {
			return ResponseEntity.badRequest()
					.body("No se encontró ningún usuario para esta clave de restablecimiento o expiro el intento!");
		}
		return new ResponseEntity<>("Restablecimiento de contraseña con éxito", OK);
	}

	/**
	 * (?=.*[0-9]) un dígito debe aparecer al menos una vez -------------
	 * (?=.*[a-z]) una letra minúscula debe aparecer al menos una vez ---
	 * (?=.*[A-Z]) una letra mayúscula debe aparecer al menos una vez ---
	 * (?=.*[@#$%^&+=]) un carácter especial debe aparecer al menos una vez
	 * (?=\\S+$) no se permiten espacios en blanco en toda la cadena --------
	 * .{6,16} Al menos 6 carácteres y max 25 -------------------------------
	 * 
	 * @param password : La nueva contraseña..
	 */
	public static boolean checkPasswordLength(String password) {
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,25}";
		return password.matches(pattern);
		// return (!StringUtils.isEmpty(password) && password.length() >= 6 &&
		// password.length() <= 18);
	}

}
