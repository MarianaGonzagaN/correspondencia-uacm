package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.EmisorReceptor;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.EmisorReceptorRepository;


@Service
@Transactional
public class EmisorReceptorServiceImpl extends AbstractBaseRepositoryImpl<EmisorReceptor,Integer> implements EmisorReceptorService {

	private EmisorReceptorRepository emisorReceptorRepository;

	public EmisorReceptorServiceImpl(EmisorReceptorRepository emisorReceptorRepository) {
		super(emisorReceptorRepository);
	}

	@Override
	public Page<EmisorReceptor> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
