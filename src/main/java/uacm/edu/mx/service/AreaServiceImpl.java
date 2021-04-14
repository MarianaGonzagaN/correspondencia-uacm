package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.Anexo;
import uacm.edu.mx.model.Area;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.AnexoRepository;
import uacm.edu.mx.repository.AreaRepository;


@Service
@Transactional
public class AreaServiceImpl extends AbstractBaseRepositoryImpl<Area,Integer> implements AreaService {

	private AreaRepository areaRepository;

	public AreaServiceImpl(AreaRepository areaRepository) {
		super(areaRepository);
	}

	@Override
	public Page<Area> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return areaRepository.findAll(page);
	}


	
}
