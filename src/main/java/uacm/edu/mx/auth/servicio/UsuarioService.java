package uacm.edu.mx.auth.servicio;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import uacm.edu.mx.auth.domain.User;
import uacm.edu.mx.auth.dto.UsuarioRequest;

public interface UsuarioService {
	
	public ResponseEntity<String> addUsuario(UsuarioRequest usuario);
	public ResponseEntity<String> deleteUsuario(String username);
	public ResponseEntity<String> updateUsuario(UsuarioRequest usuario);
	public Optional<User> getUsuario(String username);
	

}
