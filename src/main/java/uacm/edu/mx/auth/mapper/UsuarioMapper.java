package uacm.edu.mx.auth.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import uacm.edu.mx.auth.domain.ERole;
import uacm.edu.mx.auth.domain.Role;
import uacm.edu.mx.auth.domain.User;
import uacm.edu.mx.auth.domain.Usuario;
import uacm.edu.mx.auth.dto.UsuarioRequest;
import uacm.edu.mx.auth.repository.RoleRepository;
import uacm.edu.mx.auth.repository.UserRepository;
import uacm.edu.mx.auth.servicio.AuthService;

@Data
@Component
@Slf4j
public class UsuarioMapper {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private AuthService authService;
	
	
	
	@Autowired
	RoleRepository roleRepository;
	
	public User emailToUser(String email) {

		String[] emailArreglo = email.split("(@)");
		String username = emailArreglo[0];
		
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(null);
		user.setUsuario(null);

		Set<Role> roles = new HashSet<>();
		if("uacm.edu.mx".equals(emailArreglo[1]))
		{
			Role userRoleAdmin = roleRepository.findByName(ERole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role no encontrado."));
			roles.add(userRoleAdmin);
			
		}
		
		Role userRole = roleRepository.findByName(ERole.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Error: Role no encontrado."));
		
		roles.add(userRole);
		
		user.setRoles(roles);
		
		
		
		return user;
	}
	
	public Usuario DtoToUsuario(UsuarioRequest dto) {
		
		Usuario usuario=new Usuario();
		
		
		 usuario.setNombreCompleto(dto.getNombreCompleto());
		 usuario.setPlantel(dto.getPlantel());
		 usuario.setCarrera(dto.getCarrera());
		 usuario.setGenero(dto.getGenero());
		 usuario.setMatricula(dto.getMatricula());
		 usuario.setTurno(dto.getTurno());
		 usuario.setFechaNacimiento(dto.getFechaNacimiento());
		 usuario.setUrlfoto(dto.getUrlFoto());
		 
		return usuario;
		
	}
	
	
	
}
