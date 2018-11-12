package co.udea.arquitectura.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.udea.arquitectura.exception.DataNotFoundException;
import co.udea.arquitectura.model.Producto;
import co.udea.arquitectura.repository.ProductoRepository;
import co.udea.arquitectura.service.ProductoService;
import co.udea.arquitectura.util.Messages;


@Service
public class ProductoServiceImpl implements ProductoService {
	
	private final Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);
	
	private Messages messages;	
	private ProductoRepository productoRepository;

	public ProductoServiceImpl(ProductoRepository proyectoRepository, Messages messages) {
		this.productoRepository = proyectoRepository;
		this.messages = messages;
	}

	@Override
	public List<Producto> getProductos() {
		log.debug("Inicio getProductos");
		List<Producto> productos = productoRepository.findAll();
		log.debug("Fin getProductos");
		return productos;
	}
	
	@Override
	public Producto getProducto(String id) {
		log.debug("Inicio getProducto: id = {}", id);
		Optional<Producto> producto = productoRepository.findById(id);
		if(!producto.isPresent()){
			throw new DataNotFoundException(messages.get("exception.data_not_found.demo"));
		}
		log.debug("Fin getProyecto: proyecto = {}", producto.get());
		return producto.get();
	}
	
	
	@Override
	public Producto updateProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	
	@Override
	public Producto addProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	
	@Override
	public void deleteProductoId(String id) {
		log.debug("Inicio getProducto: id = {}", id);
		Optional<Producto> producto = productoRepository.findById(id);
		if(!producto.isPresent()){
			throw new DataNotFoundException(messages.get("exception.data_not_found.demo"));
		}
		log.debug("Fin getProyecto: proyecto = {}", producto.get());
		productoRepository.delete(producto.get());		
	}


}
