package uacm.edu.mx.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.Fondo;
import uacm.edu.mx.repository.FondoRepository;
import uacm.edu.mx.service.FondoService;

@Service
public class FondoServiceImpl implements FondoService {
	
	@Autowired
	private FondoRepository fondoRepository;

	@Override
	public void insertar(Fondo fondo) {
		fondoRepository.save(fondo);
		
	}

	@Override
	public List<Fondo> buscarTodos() {
		return fondoRepository.findAll();
	}

	@Override
	public Fondo buscarPorId(int idFondo) {
		Optional<Fondo> optional = fondoRepository.findById(idFondo);
		if(optional.isPresent())
			return optional.get();
		return null;
	}

	@Override
	public void eliminar(int idFondo) {
		fondoRepository.deleteById(idFondo);
	}

}
