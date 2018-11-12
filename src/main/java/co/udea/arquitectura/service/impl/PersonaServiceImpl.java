package co.udea.arquitectura.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.udea.arquitectura.exception.DataNotFoundException;
import co.udea.arquitectura.model.Persona;
import co.udea.arquitectura.model.Producto;
import co.udea.arquitectura.repository.PersonaRepositoy;
import co.udea.arquitectura.service.PersonaService;
import co.udea.arquitectura.service.ProductoService;
import co.udea.arquitectura.util.Messages;


@Service
public class PersonaServiceImpl implements PersonaService {
	
	private final Logger log = LoggerFactory.getLogger(PersonaServiceImpl.class);
	
	private Messages messages;	
	private PersonaRepositoy personaRepository;

	public PersonaServiceImpl(PersonaRepositoy personaRepository, Messages messages) {
		this.personaRepository = personaRepository;
		this.messages = messages;
	}

	@Override
	public List<Persona> getPersonas() {
		log.debug("Inicio getPersona");
		List<Persona> personas = personaRepository.findAll();
		log.debug("Fin getPersona");
		return personas;
	}
	
	@Override
	public Persona getPersona(String id) {
		log.debug("Inicio getPersona: id = {}", id);
		Optional<Persona> persona = personaRepository.findById(id);
		if(!persona.isPresent()){
			throw new DataNotFoundException(messages.get("exception.data_not_found.demo"));
		}
		log.debug("Fin getPersona: persona = {}", persona.get());
		return persona.get();
	}
	
	
	@Override
	public Persona updatePersona(Persona persona) {
		return personaRepository.save(persona);
	}
	
	@Override
	public Persona addPersona(Persona persona) {
		return personaRepository.save(persona);
	}
	
	@Override
	public void deletePersonaId(String id) {
		log.debug("Inicio deletePersonaId: id = {}", id);
		Optional<Persona> persona = personaRepository.findById(id);
		if(!persona.isPresent()){
			throw new DataNotFoundException(messages.get("exception.data_not_found.demo"));
		}
		log.debug("Fin deletePersonaId: persona = {}", persona.get());
		personaRepository.delete(persona.get());		
	}


}
