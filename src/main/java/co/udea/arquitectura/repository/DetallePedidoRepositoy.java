package co.udea.arquitectura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.udea.arquitectura.model.DetallePedido;

public interface DetallePedidoRepositoy extends JpaRepository<DetallePedido, String>{

	public Optional<DetallePedido> findByIdDetalle(int id); 
	
	
}
