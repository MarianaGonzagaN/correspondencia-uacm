package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.Anexo;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.AnexoRepository;


@Service
@Transactional
public class AnexoServiceImpl extends AbstractBaseRepositoryImpl<Anexo,Integer> implements AnexoService {

	private AnexoRepository anexoRepository;

	public AnexoServiceImpl(AnexoRepository anexoRepository) {
		super(anexoRepository);
	}

	@Override
	public Page<Anexo> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
