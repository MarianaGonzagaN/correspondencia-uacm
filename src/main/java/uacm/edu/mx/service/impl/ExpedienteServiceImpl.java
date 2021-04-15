package uacm.edu.mx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uacm.edu.mx.model.Expediente;
import uacm.edu.mx.repository.ExpedienteRepository;
import uacm.edu.mx.service.ExpedienteService;

@Service
public class ExpedienteServiceImpl implements ExpedienteService {
	
	@Autowired
	private ExpedienteRepository expedienteRepository;

	@Override
	public void insertar(Expediente expediente) {
		expedienteRepository.save(expediente);
		
	}

	@Override
	public Expediente buscarPorId(Integer idExpediente) {
		Optional<Expediente> optional = expedienteRepository.findById(idExpediente);
		if (optional.isPresent())
			return optional.get();
		return null;
	
	}

	@Override
	public List<Expediente> buscarTodos() {
		return expedienteRepository.findAll();
	}

	@Override
	public void eliminar(int idExpediente) {
		expedienteRepository.deleteById(idExpediente);
		
	}

	@Override
	public Expediente buscarPorNombre(String nombreExpediente) {
		return expedienteRepository.findByNombreExpediente(nombreExpediente);
	}

	@Override
	public List<Expediente> buscarPorFecha(Date fechaAperturaStart, Date fechaAperturaEnd) {
		
		return expedienteRepository.findAllByFechaAperturaBetween(fechaAperturaStart, fechaAperturaEnd);
	}

	
}
