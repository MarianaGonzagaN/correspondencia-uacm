package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uacm.edu.mx.model.SubSerie;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.SubSerieRepository;

@Service
@Transactional
public class SubSerieServiceImpl extends AbstractBaseRepositoryImpl<SubSerie,Integer> implements SubSerieService {

	private SubSerieRepository subSerieRepository;

	public SubSerieServiceImpl(SubSerieRepository subSerieRepository) {
		super(subSerieRepository);
	}

	@Override
	public Page<SubSerie> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return subSerieRepository.findAll(page);
	}
	
}
