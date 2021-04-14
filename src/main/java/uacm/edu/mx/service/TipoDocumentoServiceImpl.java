package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uacm.edu.mx.model.TipoDocumento;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.TipoDocumentoRepository;



@Service
@Transactional
public class TipoDocumentoServiceImpl extends AbstractBaseRepositoryImpl<TipoDocumento,Integer> implements TipoDocumentoService {

	private TipoDocumentoRepository tipoDocumentoRepository;

	public TipoDocumentoServiceImpl(TipoDocumentoRepository tipoDocumentoRepository) {
		super(tipoDocumentoRepository);
	}

	@Override
	public Page<TipoDocumento> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
