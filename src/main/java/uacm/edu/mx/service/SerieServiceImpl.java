package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.Serie;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.SerieRepository;

@Service
@Transactional
public class SerieServiceImpl extends AbstractBaseRepositoryImpl<Serie,Integer> implements SerieService {

	private SerieRepository serieRepository;

	public SerieServiceImpl(SerieRepository serieRepository) {
		super(serieRepository);
	}

	@Override
	public Page<Serie> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return serieRepository.findAll(page);
	}
	
}
