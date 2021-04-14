package uacm.edu.mx.service;
import java.io.ByteArrayInputStream;
import java.util.List;
import uacm.edu.mx.model.CorrespondenciaRecibida;

public interface GenerateExcelFileCorrRecPorFechaRecepService {
	
	ByteArrayInputStream export(List<CorrespondenciaRecibida> corrEnvPorFechaRecep);

}
