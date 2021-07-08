package uacm.edu.mx.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uacm.edu.mx.model.CorrespondenciaEnviada;

@Repository
public interface CorrespondeciaEnviadaRepository extends JpaRepository<CorrespondenciaEnviada, Long> {

	List<CorrespondenciaEnviada> findAllByFechaEnvioBetween(Date fechaRecepcionStart, Date fechaRecepcionEnd);

	@Query(value = "SELECT c  from CorrespondenciaEnviada c where c.referenciaDocumento=: referenciaDocumento", nativeQuery = true)
	CorrespondenciaEnviada findByReferencia(@Param("referenciaDocumento") String referenciaDocumento);

	@Query("SELECT c FROM CorrespondenciaEnviada c where c.idAreaDestinataria.id=:areaDestinataria and  c.fechaEnvio BETWEEN :fechaEnvioIni AND :fechaEnvioFin")
	List<CorrespondenciaEnviada> findByFechaRecepcionAndAreaDestinataria(
			@Param("fechaEnvioIni") Date fechaEnvioIni, @Param("fechaEnvioFin") Date fechaEnvioFin,
			@Param("areaDestinataria") Integer areaDestinataria);

	@Query("SELECT c FROM CorrespondenciaEnviada c where c.idEstatus.id=:idEstatus")
	List<CorrespondenciaEnviada> findByEstatus(@Param("idEstatus") Integer idEstatus);

	@Query("SELECT c FROM CorrespondenciaEnviada c where c.idPrioridad.id=:idPrioridad")
	List<CorrespondenciaEnviada> findByPrioridad(@Param("idPrioridad") Integer idPrioridad);

	@Query("SELECT c FROM CorrespondenciaRecibida c where c.fechaRequeridaRespuesta BETWEEN :fechaReqIni AND :fechaReqFin")
	Collection<CorrespondenciaEnviada> findByfechaRequeridaRespuesta(@Param("fechaReqIni") Date fechaReqIni,
			@Param("fechaReqFin") Date fechaReqFin);

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia_documento, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia_documento LIKE '%OFI%'", nativeQuery = true)
	Integer maxOficio();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia_documento, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia_documento LIKE '%CIRC%'", nativeQuery = true)
	Integer maxCirular();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia_documento, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia_documento LIKE '%COMU%'", nativeQuery = true)
	Integer maxComunicado();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia_documento, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia_documento LIKE '%NINF%'", nativeQuery = true)
	Integer maxNotaInformativa();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia_documento, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia_documento LIKE '%INVI%'", nativeQuery = true)
	Integer maxInvitacion();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia_documento, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia_documento LIKE '%MEMO%'", nativeQuery = true)
	Integer maxMemorandum();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia_documento, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia_documento LIKE '%CART%'", nativeQuery = true)
	Integer maxCarta();

	@Query(value = "SELECT MAX((rtrim(SUBSTRING(referencia_documento, 20, 23),'/20'))) FROM correspondencia_enviada WHERE referencia_documento LIKE '%BOLE%'", nativeQuery = true)
	Integer maxBoletin();

}
