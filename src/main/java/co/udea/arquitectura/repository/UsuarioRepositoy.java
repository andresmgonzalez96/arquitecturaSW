package co.udea.arquitectura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.udea.arquitectura.model.Persona;
import co.udea.arquitectura.model.Usuario;

public interface UsuarioRepositoy extends JpaRepository<Usuario, String>{

	public Optional<Usuario> findById(String id); 
	
	
}
