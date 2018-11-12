package co.udea.arquitectura.service;

import java.util.List;

import co.udea.arquitectura.model.DetallePedido;

public interface DetallePedidoService {
	
	public List<DetallePedido> getDetallesPedido();
	
	public DetallePedido getDetallePedido(int id) ;
	public DetallePedido addDetallePedido(DetallePedido detalle) ;
	public DetallePedido updateDetallePedido(DetallePedido detalle) ;
	public void deleteDetallePedidoId(int id) ;
	

}
