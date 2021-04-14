package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.SubSeccion;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.SubSeccionRepository;

@Service
@Transactional
public class SubSeccionServiceImpl extends AbstractBaseRepositoryImpl<SubSeccion,Integer> implements SubSeccionService {

	private SubSeccionRepository subSeccionRepository;

	public SubSeccionServiceImpl(SubSeccionRepository subSeccionRepository) {
		super(subSeccionRepository);
	}

	@Override
	public Page<SubSeccion> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return subSeccionRepository.findAll(page);
	}

	
}
