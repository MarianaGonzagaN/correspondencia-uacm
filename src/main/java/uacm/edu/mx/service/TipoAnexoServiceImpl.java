package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uacm.edu.mx.model.TipoAnexo;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.TipoAnexoRepository;



@Service
@Transactional
public class TipoAnexoServiceImpl extends AbstractBaseRepositoryImpl<TipoAnexo,Integer> implements TipoAnexoService {

	private TipoAnexoRepository tipoAnexoRepository;

	public TipoAnexoServiceImpl(TipoAnexoRepository tipoAnexoRepository) {
		super(tipoAnexoRepository);
	}

	@Override
	public Page<TipoAnexo> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
