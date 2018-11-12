package co.udea.arquitectura.service;

import java.util.List;

import co.udea.arquitectura.model.Producto;

public interface ProductoService {
	
	public List<Producto> getProductos();
	
	public Producto getProducto(String id) ;
	public Producto addProducto(Producto producto) ;
	public Producto updateProducto(Producto producto) ;
	public void deleteProductoId(String id) ;
	

}
