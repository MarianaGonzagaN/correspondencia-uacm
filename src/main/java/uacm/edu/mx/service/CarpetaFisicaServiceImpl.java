package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uacm.edu.mx.model.CarpetaFisica;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.CarpetaFisicaRepository;



@Service
@Transactional
public class CarpetaFisicaServiceImpl extends AbstractBaseRepositoryImpl<CarpetaFisica,Integer> implements CarpetaFisicaService {

	private CarpetaFisicaRepository carpetaFisicaRepository;

	public CarpetaFisicaServiceImpl(CarpetaFisicaRepository carpetaFisicaRepository) {
		super(carpetaFisicaRepository);
	}

	@Override
	public Page<CarpetaFisica> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return carpetaFisicaRepository.findAll(page);
	}


	
}
