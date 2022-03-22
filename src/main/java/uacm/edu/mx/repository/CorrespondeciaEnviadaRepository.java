package uacm.edu.mx.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uacm.edu.mx.model.CorrespondenciaEnviada;
import uacm.edu.mx.model.CorrespondenciaRecibida;

@Repository
public interface CorrespondeciaEnviadaRepository extends JpaRepository<CorrespondenciaEnviada, Long> {

	@Query("SELECT c FROM CorrespondenciaEnviada c  where  c.fechaEnvio BETWEEN :fechaEnvioIni AND :fechaEnvioFin")
	List<CorrespondenciaEnviada> findAllByFechaEnvioBetween(@Param("fechaEnvioIni") Date fechaRecepcionStart, @Param("fechaEnvioFin") Date fechaRecepcionEnd);

	@Query("SELECT c  from CorrespondenciaEnviada c where c.referenciaDocumento=:referencia")
	CorrespondenciaEnviada findByReferencia(@Param("referencia") String referencia);
	
	@Query("SELECT c FROM CorrespondenciaEnviada c where c.idAreaDestinataria.id=:areaDestinataria and  c.fechaEnvio BETWEEN :fechaEnvioIni AND :fechaEnvioFin")
	List<CorrespondenciaEnviada> findByFechaEnvioAndAreaDestinataria(
			@Param("fechaEnvioIni") Date fechaEnvioIni, @Param("fechaEnvioFin") Date fechaEnvioFin,
			@Param("areaDestinataria") Long areaDestinataria);
	
	@Query("SELECT c FROM CorrespondenciaEnviada c where c.idEstatus.id=:idEstatus")
	List<CorrespondenciaEnviada> findByEstatus(@Param("idEstatus") Long idEstatus);

	@Query("SELECT c FROM CorrespondenciaEnviada c where c.idPrioridad.id=:idPrioridad")
	List<CorrespondenciaEnviada> findByPrioridad(@Param("idPrioridad") Long idPrioridad);
	
	@Query("SELECT c FROM CorrespondenciaRecibida c where c.fechaRequeridaRespuesta BETWEEN :fechaReqIni AND :fechaReqFin")
	Collection<CorrespondenciaEnviada> findByfechaRequeridaRespuesta(@Param("fechaReqIni") Date fechaReqIni,
			@Param("fechaReqFin") Date fechaReqFin);

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia LIKE '%OFI%'", nativeQuery = true)
	Integer maxOficio();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia LIKE '%CIRC%'", nativeQuery = true)
	Integer maxCirular();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia LIKE '%COMU%'", nativeQuery = true)
	Integer maxComunicado();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia LIKE '%NINF%'", nativeQuery = true)
	Integer maxNotaInformativa();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia LIKE '%INVI%'", nativeQuery = true)
	Integer maxInvitacion();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia_documento, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia LIKE '%MEMO%'", nativeQuery = true)
	Integer maxMemorandum();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia LIKE '%CART%'", nativeQuery = true)
	Integer maxCarta();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia LIKE '%BOLE%'", nativeQuery = true)
	Integer maxBoletin();

}
