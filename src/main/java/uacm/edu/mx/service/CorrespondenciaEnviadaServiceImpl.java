package uacm.edu.mx.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.CorrespondenciaEnviada;
import uacm.edu.mx.repository.CorrespondeciaEnviadaRepository;


@Service
public class CorrespondenciaEnviadaServiceImpl implements CorrespondenciaEnviadaService{
	
	@Autowired
	private CorrespondeciaEnviadaRepository corrEnvRepository;

	@Override
	public void insertar(CorrespondenciaEnviada correspondenciaRecibida) {
	
		corrEnvRepository.save(correspondenciaRecibida);
	}

	@Override
	public List<CorrespondenciaEnviada> buscarTodos() {
		return corrEnvRepository.findAll();
	}

	@Override
	public CorrespondenciaEnviada buscarPorId(String consecutivo) {
		Optional<CorrespondenciaEnviada> optional = corrEnvRepository.findById(consecutivo);
		if (optional.isPresent())
			return optional.get();
		return null;
	
	}

	@Override
	public List<CorrespondenciaEnviada> buscarPorFechaEnvio(Date fechaEnvioStart, Date fechaEnvioEnd) {
		// TODO Auto-generated method stub
		return corrEnvRepository.findAllByFechaEnvioBetween(fechaEnvioStart, fechaEnvioEnd);
	}

	@Override
	public List<CorrespondenciaEnviada> buscarPorFechaEnvioAndAreaRecibe(Date fechaEnvioStart, Date fechaEnvioEnd,
			Integer areaId) {
		// TODO Auto-generated method stub
		return corrEnvRepository.findByFechaEnvioAndAreaRecibe(fechaEnvioStart, fechaEnvioEnd, areaId);
	}

	@Override
	public List<CorrespondenciaEnviada> buscarPorEstatus(Integer estatusId) {
		// TODO Auto-generated method stub
		return corrEnvRepository.findByEstatus(estatusId);
	}

	@Override
	public List<CorrespondenciaEnviada> buscarPorPrioridad(Integer prioridadId) {
		// TODO Auto-generated method stub
		return corrEnvRepository.findByPrioridad(prioridadId);
	}

	@Override
	public String buscarUltimoConsecutivo(String TipoDeDocumento) {
		// TODO Auto-generated method stub
		
		System.out.print("----------------------------------------------------");
		System.out.print("la referencia del documento es:"+TipoDeDocumento);
		System.out.print("----------------------------------------------------");
		
		
		String  result = null;
	    switch (TipoDeDocumento) {
	        case "1":
	        	Integer maxOficio = null;
	    		maxOficio = corrEnvRepository.maxOficio();
	    		String ultimoOficio = "UACM/SLT/COORD/OFI-"+maxOficio+"/2020";
	            result = ultimoOficio;
	            break;
	        case "2":
	        	Integer maxCircular= null;
	        	maxCircular = corrEnvRepository.maxCirular();
	    		String ultimoCircular= "UACM/SLT/COORD/CIRC-"+maxCircular+"/2020";
	            result = ultimoCircular;
	            break;
	        case "3":
	        	Integer maxComunicado= null;
	        	maxComunicado = corrEnvRepository.maxComunicado();
	    		String ultimoComunicado= "UACM/SLT/COORD/COMU-"+maxComunicado+"/2020";
	            result = ultimoComunicado;
	            break;
	        case "4":
	        	Integer maxNotaInformativa= null;
	        	maxNotaInformativa = corrEnvRepository.maxNotaInformativa();
	    		String ultimoNotaInformativa = "UACM/SLT/COORD/NINF-"+maxNotaInformativa+"/2020";
	            result = ultimoNotaInformativa;
	            break;
	        case "5":
	        	Integer maxInvitacion= null;
	        	maxInvitacion = corrEnvRepository.maxInvitacion();
	    		String ultimoInvitacion= "UACM/SLT/COORD/INVI-"+maxInvitacion+"/2020";
	            result = ultimoInvitacion;
	            break;
	        case "6":
	        	Integer maxMemorandum= null;
	        	maxMemorandum = corrEnvRepository.maxMemorandum();
	    		String ultimoMemorandum= "UACM/SLT/COORD/MEMO-"+maxMemorandum+"/2020";
	            result = ultimoMemorandum;
	            break;
	        case "7":
	        	Integer maxCarta= null;
	        	maxCarta = corrEnvRepository.maxCarta();
	    		String ultimoCarta = "UACM/SLT/COORD/CART-"+maxCarta+"/2020";
	            result = ultimoCarta;
	            break;
	        case "8":
	        	Integer maxBoletin= null;
	        	maxBoletin = corrEnvRepository.maxBoletin();
	    		String ultimoBoletin = "UACM/SLT/COORD/BOLE-"+maxBoletin+"/2020";
	            result = ultimoBoletin;
	            break;
	        default:
	            break;
	    }
		return result;
		
	}




}
