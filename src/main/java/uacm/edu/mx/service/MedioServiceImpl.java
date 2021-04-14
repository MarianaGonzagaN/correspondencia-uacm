package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.Medio;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.MedioRepository;

@Service
@Transactional
public class MedioServiceImpl extends AbstractBaseRepositoryImpl<Medio,Integer> implements MedioService {

	private MedioRepository medioRepository;

	public MedioServiceImpl(MedioRepository medioRepository) {
		super(medioRepository);
	}

	@Override
	public Page<Medio> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
