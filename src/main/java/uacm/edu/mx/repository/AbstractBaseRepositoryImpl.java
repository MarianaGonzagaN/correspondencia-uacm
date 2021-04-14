package uacm.edu.mx.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.AbstractBaseEntity;
import uacm.edu.mx.service.AbstractBaseService;

@Service
@Transactional
public abstract class AbstractBaseRepositoryImpl<T extends AbstractBaseEntity, ID>
		implements AbstractBaseService<T, ID> {

	private AbstractBaseRepository<T, ID> abstractBaseRepository;
	
	@Autowired
	public AbstractBaseRepositoryImpl(AbstractBaseRepository<T, ID> abstractBaseRepository) {
		this.abstractBaseRepository = abstractBaseRepository;
	}

	@Override
	public T guardar(T entity) {
		return (T) abstractBaseRepository.save(entity);
	}

	@Override
	public List<T> buscarTodos() {
	
		return abstractBaseRepository.findAllByOrderByNombre();
	}

	@Override
	public Optional<T> buscarPorId(ID entityId) {
		return abstractBaseRepository.findById(entityId);
	}

	@Override
	public void eliminar(ID entityId) {
		abstractBaseRepository.deleteById(entityId);
	}
	

	
	
	
}
