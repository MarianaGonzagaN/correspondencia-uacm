package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.Seccion;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.SeccionRepository;

@Service
@Transactional
public class SeccionServiceImpl extends AbstractBaseRepositoryImpl<Seccion,Integer> implements SeccionService {

	private SeccionRepository seccionRepository;

	public SeccionServiceImpl(SeccionRepository seccionRepository) {
		super(seccionRepository);
	}

	@Override
	public Page<Seccion> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
