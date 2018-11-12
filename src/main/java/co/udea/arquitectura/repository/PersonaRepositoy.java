package co.udea.arquitectura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.udea.arquitectura.model.Persona;
import co.udea.arquitectura.model.Producto;

public interface PersonaRepositoy extends JpaRepository<Persona, String>{

	public Optional<Persona> findById(String id); 
	
	
}
