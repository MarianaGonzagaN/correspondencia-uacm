package uacm.edu.mx.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
//import java.io.File;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uacm.edu.mx.model.CorrespondenciaRecibida;

@Repository
public interface CorrespondeciaRecibidaRepository extends JpaRepository<CorrespondenciaRecibida, Long> {
	
	@Query("SELECT c FROM CorrespondenciaRecibida c  where  c.fechaRecepcion BETWEEN :fechaRecepcionStart AND :fechaRecepcionEnd")
	List<CorrespondenciaRecibida> findAllByFechaRecepcionBetween(@Param("fechaRecepcionStart") Date fechaRecepcionStart,@Param("fechaRecepcionEnd") Date fechaRecepcionEnd);


	@Query(value = "SELECT max(rtrim(c.turno,'-20')) FROM correspondencia_recibida c", nativeQuery = true)
	public String max();
	
	@Query( "SELECT c  FROM CorrespondenciaRecibida c where c.referenciaDocumento=:referencia")
	CorrespondenciaRecibida findByReferencia(@Param("referencia") String referencia);
	
	@Query("SELECT c FROM CorrespondenciaRecibida c where c.idAreaRemitente.id=:areaRemitente and  c.fechaRecepcion BETWEEN :fechRecIni AND :fechRecFin")
	List<CorrespondenciaRecibida> findByFechaRecepcionAndAreaRemitente(@Param("fechRecIni") Date fechaRecepcionIni,@Param("fechRecFin") Date fechaRecepcionfin, @Param("areaRemitente") Long areaRemitente);

	@Query("SELECT c FROM CorrespondenciaRecibida c where c.idEstatus.id=:idEstatus")
	List<CorrespondenciaRecibida> findByEstatus(@Param("idEstatus") Long idEstatus);

	@Query("SELECT c FROM CorrespondenciaRecibida c where c.idPrioridad.id=:idPrioridad")
	List<CorrespondenciaRecibida> findByPrioridad(@Param("idPrioridad") Long idPrioridad);

	@Query("SELECT c FROM CorrespondenciaRecibida c where c.fechaRequeridaRespuesta BETWEEN :fechaReqIni AND :fechaReqFin")
	Collection<CorrespondenciaRecibida> findByfechaRequeridaRespuesta(@Param("fechaReqIni") Date fechaReqIni,
			@Param("fechaReqFin") Date fechaReqFin);

	@Query("SELECT c FROM CorrespondenciaRecibida c where c.referenciaDocumento=:referenciaDocumento")
	CorrespondenciaRecibida findByDocumento(@Param("referenciaDocumento") String referenciaDocumento);

	// @Query("SELECT cr.turno, cr.referenciaDocumento, cr.asunto, cr.vigencia FROM
	// CorrespondenciaRecibida cr WHERE cr.fechaSolucion is null ORDER BY
	// cr.vigencia ASC")
	// List<CorrespondenciaRecibida> findByFechaSolucionIsNull();
	// List<CorrespondenciaRecibida> findByFechaSolucionIsNullOrderByVigencia();

}
