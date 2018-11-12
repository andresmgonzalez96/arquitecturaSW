package co.udea.arquitectura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.udea.arquitectura.model.Persona;
import co.udea.arquitectura.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String>{

	public Optional<Producto> findByCodigo(String id); 
	
	
}
