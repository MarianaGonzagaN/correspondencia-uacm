package uacm.edu.mx.mapper;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import uacm.edu.mx.data.FondoRequest;
import uacm.edu.mx.data.FondoResponse;
import uacm.edu.mx.model.Fondo;

@Slf4j
@Component
public class FondoMapper {

	public Fondo dataToEntity(FondoRequest fondoRequest) {

		Fondo fondo = new Fondo();

		System.out.println("Fecha creación" + fondoRequest.getFechaCreacion());
		fondo.setNombre(fondoRequest.getNombre());
		fondo.setTelefono(fondoRequest.getTelefono());
		fondo.setFechaCreacion(fondoRequest.getFechaCreacion());
		fondo.setDireccion(fondoRequest.getDireccion());
		return fondo;
	}

	public FondoResponse EntityToData(Fondo fondo) {

		FondoResponse fondoResponse = new FondoResponse();

		fondoResponse.setId(fondo.getId());
		fondoResponse.setNombre(fondo.getNombre());
		fondoResponse.setTelefono(fondo.getTelefono());
		fondoResponse.setFechaCreacion(fondo.getFechaCreacion());
		fondoResponse.setDireccion(fondo.getDireccion());
		return fondoResponse;
	}

	public Fondo dataToEntityUpdate(FondoRequest fondoRequest, Fondo fondo) {

		fondo.setNombre(fondoRequest.getNombre());
		fondo.setTelefono(fondoRequest.getTelefono());
		fondo.setFechaCreacion(fondoRequest.getFechaCreacion());
		fondo.setDireccion(fondoRequest.getDireccion());
		return fondo;
	}

	public FondoResponse fondoResponse(Fondo fondo) {

		FondoResponse fondoResponse = new FondoResponse();
		return fondoResponse;
	}

}
