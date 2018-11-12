package co.udea.arquitectura.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.udea.arquitectura.exception.DataNotFoundException;
import co.udea.arquitectura.model.Persona;
import co.udea.arquitectura.model.EncabezadoPedido;
import co.udea.arquitectura.model.Producto;
import co.udea.arquitectura.repository.PersonaRepositoy;
import co.udea.arquitectura.repository.EncabezadoPedidoRepositoy;
import co.udea.arquitectura.service.PersonaService;
import co.udea.arquitectura.service.EncabezadoPedidoService;
import co.udea.arquitectura.service.ProductoService;
import co.udea.arquitectura.util.Messages;


@Service
public class EncabezadoPedidoServiceImpl implements EncabezadoPedidoService {
	
	private final Logger log = LoggerFactory.getLogger(EncabezadoPedidoServiceImpl.class);
	
	private Messages messages;	
	private EncabezadoPedidoRepositoy encabezadoRepository;

	public EncabezadoPedidoServiceImpl(EncabezadoPedidoRepositoy encabezadoRepository, Messages messages) {
		this.encabezadoRepository = encabezadoRepository;
		this.messages = messages;
	}

	@Override
	public List<EncabezadoPedido> getEncabezadosPedidos() {
		log.debug("Inicio getEncabezadoPedido");
		List<EncabezadoPedido> encabezado = encabezadoRepository.findAll();
		log.debug("Fin getEncabezadoPedido");
		return encabezado;
	}
	
	@Override
	public EncabezadoPedido getEncabezadoPedido(int id) {
		log.debug("Inicio getCliente: id = {}", id);
		Optional<EncabezadoPedido> encabezadoPedido = encabezadoRepository.findById(id);
		if(!encabezadoPedido.isPresent()){
			throw new DataNotFoundException(messages.get("exception.data_not_found.demo"));
		}
		log.debug("Fin getCliente: cliente = {}", encabezadoPedido.get());
		return encabezadoPedido.get();
	}
	
	
	@Override
	public EncabezadoPedido updateEncabezadoPedido(EncabezadoPedido encabezadoPedido) {
		return encabezadoRepository.save(encabezadoPedido);
	}
	
	@Override
	public EncabezadoPedido addEncabezadoPedido(EncabezadoPedido encabezadoPedido) {
		List<EncabezadoPedido> pedidos= encabezadoRepository.findAll();
		encabezadoPedido.setId(pedidos.size());
		return encabezadoRepository.save(encabezadoPedido);
	}
	
	@Override
	public void deleteEncabezadoPedidoId(int id) {
		log.debug("Inicio deleteClienteId: id = {}", id);
		Optional<EncabezadoPedido> encabezadoPedido = encabezadoRepository.findById(id);
		if(!encabezadoPedido.isPresent()){
			throw new DataNotFoundException(messages.get("exception.data_not_found.demo"));
		}
		log.debug("Fin deleteEncabezadoPedidoId: EncabezadoPedido = {}", encabezadoPedido.get());
		encabezadoRepository.delete(encabezadoPedido.get());		
	}


}
