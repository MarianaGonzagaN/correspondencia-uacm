package uacm.edu.mx.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import uacm.edu.mx.model.AbstractBaseEntity;

@NoRepositoryBean
public interface AbstractBaseRepository<T extends AbstractBaseEntity, ID>
		extends JpaRepository<T, ID> {

	public List<T> findAllByOrderByNombre();

}
