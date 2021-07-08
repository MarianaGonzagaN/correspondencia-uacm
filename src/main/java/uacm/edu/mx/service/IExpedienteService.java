package uacm.edu.mx.service;

import java.util.Date;
import java.util.List;

import uacm.edu.mx.data.ExpedienteRequest;
import uacm.edu.mx.data.ExpedienteResponse;

public interface IExpedienteService {
	
	public ExpedienteResponse createExpediente(ExpedienteRequest expedienteRequest);
	public List<ExpedienteResponse> getAllExpedientes();
	public ExpedienteResponse getExpedienteById(Long idExpediente);
	public ExpedienteResponse getExpedienteByNombre(String nombreExpediente);
	public List<ExpedienteResponse> getExpedienteByFecha(Date fechaAperturaStart, Date fechaAperturaEnd);
	public ExpedienteResponse updateExpediente(ExpedienteRequest expedienteRequest, Long  idExpediente);
	
}
