package uacm.edu.mx.mapper;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import uacm.edu.mx.data.ExpedienteRequest;
import uacm.edu.mx.data.ExpedienteResponse;
import uacm.edu.mx.model.Expediente;

@Slf4j
@Component
public class ExpedienteMapper {

	public Expediente dataToEntity(ExpedienteRequest expedienteRequest) {

		Expediente expediente = new Expediente();
		expediente.setFechaApertura(expedienteRequest.getFechaApertura());
		expediente.setNombreExpediente(expedienteRequest.getNombreExpediente());
		//expediente.setIdFondo(expedienteRequest.getIdFondo());
		expediente.setIdSeccion(expedienteRequest.getIdSeccion());
		expediente.setIdSubSeccion(expedienteRequest.getIdSubSeccion());
		expediente.setIdSerie(expedienteRequest.getIdSerie());
		expediente.setIdSubSerie(expedienteRequest.getIdSubSerie());
		expediente.setCarpetaFisica(expedienteRequest.getCarpetaFisica());
		return expediente;
	}

	public ExpedienteResponse EntityToData(Expediente expediente) {

		ExpedienteResponse expedienteResponse = new ExpedienteResponse();
		expedienteResponse.setId(expediente.getIdExpediente());
		expedienteResponse.setFechaApertura(expediente.getFechaApertura());
		expedienteResponse.setNombreExpediente(expediente.getNombreExpediente());
		//expedienteResponse.setIdFondo(expediente.getIdFondo());
		expedienteResponse.setIdSeccion(expediente.getIdSeccion());
		expedienteResponse.setIdSubSeccion(expediente.getIdSubSeccion());
		expedienteResponse.setIdSerie(expediente.getIdSerie());
		expedienteResponse.setIdSubSerie(expediente.getIdSubSerie());
		expedienteResponse.setCarpetaFisica(expediente.getCarpetaFisica());
		return expedienteResponse;
	}

}
