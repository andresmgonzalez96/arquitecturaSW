package co.udea.arquitectura.service;

import java.util.List;

import co.udea.arquitectura.model.Persona;

public interface PersonaService {
	
	public List<Persona> getPersonas();
	
	public Persona getPersona(String id) ;
	public Persona addPersona(Persona cliente) ;
	public Persona updatePersona(Persona cliente) ;
	public void deletePersonaId(String id) ;
	

}
