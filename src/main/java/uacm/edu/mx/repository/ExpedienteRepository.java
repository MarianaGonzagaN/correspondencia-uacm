package uacm.edu.mx.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uacm.edu.mx.model.Expediente;

@Repository
public interface ExpedienteRepository extends JpaRepository<Expediente, Integer> {
	
	Expediente findByNombreExpediente(String nombreExpediente);
	List<Expediente> findAllByFechaAperturaBetween(
		      Date fechaAperturaStart,
		      Date fechaAperturaEnd);
	
	
	

}
