package co.udea.arquitectura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.udea.arquitectura.model.Persona;
import co.udea.arquitectura.model.EncabezadoPedido;
import co.udea.arquitectura.model.Producto;

public interface EncabezadoPedidoRepositoy extends JpaRepository<EncabezadoPedido, String>{

	public Optional<EncabezadoPedido> findById(int id); 
	
	
}
