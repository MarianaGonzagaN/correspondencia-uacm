package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uacm.edu.mx.model.Prioridad;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.PrioridadRepository;



@Service
@Transactional
public class PrioridadServiceImpl extends AbstractBaseRepositoryImpl<Prioridad,Integer> implements PrioridadService {

	private PrioridadRepository prioridadRepository;

	public PrioridadServiceImpl(PrioridadRepository prioridadRepository) {
		super(prioridadRepository);
	}

	@Override
	public Page<Prioridad> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return prioridadRepository.findAll(page);
	}


	
}
