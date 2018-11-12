package co.udea.arquitectura.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.udea.arquitectura.exception.DataNotFoundException;
import co.udea.arquitectura.model.DetallePedido;
import co.udea.arquitectura.model.EncabezadoPedido;
import co.udea.arquitectura.repository.DetallePedidoRepositoy;
import co.udea.arquitectura.service.DetallePedidoService;
import co.udea.arquitectura.util.Messages;


@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {
	
	private final Logger log = LoggerFactory.getLogger(DetallePedidoServiceImpl.class);
	
	private Messages messages;	
	private DetallePedidoRepositoy detalleRepository;

	public DetallePedidoServiceImpl(DetallePedidoRepositoy detalleRepository, Messages messages) {
		this.detalleRepository = detalleRepository;
		this.messages = messages;
	}

	@Override
	public List<DetallePedido> getDetallesPedido() {
		log.debug("Inicio getDetallesPedido");
		List<DetallePedido> detalles = detalleRepository.findAll();
		log.debug("Fin getDetallesPedido");
		return detalles;
	}
	
	@Override
	public DetallePedido getDetallePedido(int id) {
		log.debug("Inicio getDetallePedido: id = {}", id);
		Optional<DetallePedido> detallePedido = detalleRepository.findByIdDetalle(id);
		if(!detallePedido.isPresent()){
			throw new DataNotFoundException(messages.get("exception.data_not_found.demo"));
		}
		log.debug("Fin getDetallePedido: detalles = {}", detallePedido.get());
		return detallePedido.get();
	}
	
	
	@Override
	public DetallePedido updateDetallePedido(DetallePedido detallePedido) {
		return detalleRepository.save(detallePedido);
	}
	
	@Override
	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		return detalleRepository.save(detallePedido);
	}
	
	@Override
	public void deleteDetallePedidoId(int id) {
		log.debug("Inicio deleteDetallePedidoId: id = {}", id);
		Optional<DetallePedido> detallePedido = detalleRepository.findByIdDetalle(id);
		if(!detallePedido.isPresent()){
			throw new DataNotFoundException(messages.get("exception.data_not_found.demo"));
		}
		log.debug("Fin deleteDetallePedidoId: deleteDetallePedido = {}", detallePedido.get());
		detalleRepository.delete(detallePedido.get());		
	}


}
