package uacm.edu.mx.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uacm.edu.mx.auth.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {
	
	
}
