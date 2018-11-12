package co.udea.arquitectura.service;

import java.util.List;

import co.udea.arquitectura.model.Persona;
import co.udea.arquitectura.model.EncabezadoPedido;

public interface EncabezadoPedidoService {
	
	public List<EncabezadoPedido> getEncabezadosPedidos();
	
	public EncabezadoPedido getEncabezadoPedido(int id) ;
	public EncabezadoPedido addEncabezadoPedido(EncabezadoPedido encabezado) ;
	public EncabezadoPedido updateEncabezadoPedido(EncabezadoPedido encabezado) ;
	public void deleteEncabezadoPedidoId(int id) ;
	

}
