package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.Estatus;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.EstatusRepository;

@Service
@Transactional
public class EstatusServiceImpl extends AbstractBaseRepositoryImpl<Estatus,Integer> implements EstatusService {

	private EstatusRepository estatusRepository;

	public EstatusServiceImpl(EstatusRepository estatusRepository) {
		super(estatusRepository);
	}

	@Override
	public Page<Estatus> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
