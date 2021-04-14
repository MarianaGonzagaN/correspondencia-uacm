package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.Persona;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.PersonaRepository;

@Service
@Transactional
public class PersonaServiceImpl extends AbstractBaseRepositoryImpl<Persona,Integer> implements PersonaService {

	private PersonaRepository personaRepository;

	public PersonaServiceImpl(PersonaRepository personaRepository) {
		super(personaRepository);
	}

	@Override
	public Page<Persona> buscarTodas(Pageable page) {
		return personaRepository.findAll(page);
	}


	
}
