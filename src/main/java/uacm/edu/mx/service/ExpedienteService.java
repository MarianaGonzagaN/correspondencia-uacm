package uacm.edu.mx.service;

import java.util.Date;
import java.util.List;

import uacm.edu.mx.data.ExpedienteRequest;
import uacm.edu.mx.data.ExpedienteResponse;
import uacm.edu.mx.model.Expediente;

public interface ExpedienteService {
	
	public ExpedienteResponse insertar(ExpedienteRequest expedienteRequest);
	Expediente buscarPorId(Integer idExpediente);
	List<Expediente> buscarTodos();
	void eliminar(int idExpediente);
	Expediente buscarPorNombre(String nombreExpediente);
	List<Expediente> buscarPorFecha(Date fechaAperturaStart, Date fechaAperturaEnd);
	
	

}
