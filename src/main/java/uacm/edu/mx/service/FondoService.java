package uacm.edu.mx.service;

import java.util.List;
import uacm.edu.mx.model.Fondo;

public interface FondoService {
	
	
	void insertar(Fondo fondo);	
	List<Fondo> buscarTodos();
	Fondo buscarPorId(int idFondo);	
	void eliminar(int idFondo);
	

}
