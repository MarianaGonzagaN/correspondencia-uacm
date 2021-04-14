package uacm.edu.mx.service;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.CorrespondenciaRecibida;
import uacm.edu.mx.model.Expediente;
import uacm.edu.mx.repository.CorrespondeciaRecibidaRepository;

@Service
public class CorrespondenciaRecibidaServiceImpl implements CorrespondenciaRecibidaService{
	
	@Autowired
	private CorrespondeciaRecibidaRepository corrRecRepository;

	@Override
	public void insertar(CorrespondenciaRecibida correspondenciaRecibida) {
		LocalDate localDate = LocalDate.now();
		
		String turno =correspondenciaRecibida.getTurno()+"-"+localDate.getYear();
		
		correspondenciaRecibida.setTurno(turno);

		corrRecRepository.save(correspondenciaRecibida);
		
		System.out.println("el turno con fecha es:"+correspondenciaRecibida.getTurno());
	}

	@Override
	public List<CorrespondenciaRecibida> buscarTodos() {
		return corrRecRepository.findAll();
	}

	@Override
	public CorrespondenciaRecibida buscarPorId(String referencia) {
		Optional<CorrespondenciaRecibida> optional = corrRecRepository.findById(referencia);
		if (optional.isPresent())
			return optional.get();
		return null;
	
	}

	@Override
	public List<CorrespondenciaRecibida> buscarPorFechaRecepcion(Date fechaRecepcionStart, Date fechaRecepcionEnd) {
		// TODO Auto-generated method stub
		return corrRecRepository.findAllByFechaRecepcionBetween(fechaRecepcionStart, fechaRecepcionEnd);
	}

	@Override
	public String max() {
		return corrRecRepository.max();
	}

	@Override
	public List<CorrespondenciaRecibida> buscarPendientesDeSolucion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CorrespondenciaRecibida> buscarPorFechaRecepcionAndAreaEnvia(Date fechaRecepcionStart,
			Date fechaRecepcionEnd, Integer areaId) {

		return corrRecRepository.findByFechaRecepcionAndAreaEnvia(fechaRecepcionStart, fechaRecepcionEnd,areaId);
	}

	@Override
	public List<CorrespondenciaRecibida> buscarPorEstatus(Integer estatusId) {
		// TODO Auto-generated method stub
		return corrRecRepository.findByEstatus(estatusId);
	}

	@Override
	public List<CorrespondenciaRecibida> buscarPorPrioridad(Integer prioridadId) {
		// TODO Auto-generated method stub
		return corrRecRepository.findByPrioridad(prioridadId);
	}

	@Override
	public CorrespondenciaRecibida buscarArchivoPorReferenciaDeDocumento(String referencia) {
		// TODO Auto-generated method stub
		return corrRecRepository.findByDocumento(referencia);
	}



}
