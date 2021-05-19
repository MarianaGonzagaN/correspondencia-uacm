package uacm.edu.mx.auth.servicio;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import uacm.edu.mx.auth.domain.User;
import uacm.edu.mx.auth.domain.VerificationToken;
import uacm.edu.mx.auth.dto.LoginRequest;

@Service
public interface AuthService {

    public ResponseEntity<String> signup(String email);
    public ResponseEntity<String> activarUsuarioBuscado(VerificationToken verificationToken);
    public String generaVerificaciónToken(User user);
    public ResponseEntity<String> verificarCuenta(String token);
    public ResponseEntity<?> login(LoginRequest loginRequest);
    public boolean isLoggedIn();
    public boolean validaCorreo(String mail);
    public Optional<User> requestPasswordReset(String mail);
    public Optional<User> completePasswordReset(String newPassword, String key);
    
}