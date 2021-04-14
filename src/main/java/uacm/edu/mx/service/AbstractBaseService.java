package uacm.edu.mx.service;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uacm.edu.mx.model.AbstractBaseEntity;


public interface AbstractBaseService <T extends AbstractBaseEntity, ID> {

	public abstract T guardar(T entity);	
	public abstract List<T> buscarTodos();
	public abstract Optional<T> buscarPorId(ID entityId);	
	public abstract void eliminar(ID entityId);
	public abstract Page<T> buscarTodas(Pageable page);
	
}
