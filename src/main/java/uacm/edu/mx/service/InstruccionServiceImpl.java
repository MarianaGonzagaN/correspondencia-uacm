package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.Instruccion;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.InstruccionRepository;

@Service
@Transactional
public class InstruccionServiceImpl extends AbstractBaseRepositoryImpl<Instruccion,Integer> implements InstruccionService {

	private InstruccionRepository instruccionRepository;

	public InstruccionServiceImpl(InstruccionRepository instruccionRepository) {
		super(instruccionRepository);
	}

	@Override
	public Page<Instruccion> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}


}
