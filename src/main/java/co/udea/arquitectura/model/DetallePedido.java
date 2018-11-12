package co.udea.arquitectura.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detallePedido")
public class DetallePedido {

	@Id
	private int idDetalle;
	private int idEncabezadoPedido;
	private String producto;
	private int cantidad;
	private double descuento;
	private double precioTotalProducto;

	public DetallePedido() {
		super();
	}

	public DetallePedido(int idDetalle, int idEncabezadoPedido, String producto, int cantidad, double descuento,
			double precioTotalProducto) {
		super();
		this.idDetalle = idDetalle;
		this.idEncabezadoPedido = idEncabezadoPedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.descuento = descuento;
		this.precioTotalProducto = precioTotalProducto;
	}

	/**
	 * @return the idDetalle
	 */
	public int getIdDetalle() {
		return idDetalle;
	}

	/**
	 * @param idDetalle the idDetalle to set
	 */
	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	/**
	 * @return the idEncabezadoPedido
	 */
	public int getIdEncabezadoPedido() {
		return idEncabezadoPedido;
	}

	/**
	 * @param idEncabezadoPedido the idEncabezadoPedido to set
	 */
	public void setIdEncabezadoPedido(int idEncabezadoPedido) {
		this.idEncabezadoPedido = idEncabezadoPedido;
	}

	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the descuento
	 */
	public double getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	/**
	 * @return the precioTotalProducto
	 */
	public double getPrecioTotalProducto() {
		return precioTotalProducto;
	}

	/**
	 * @param precioTotalProducto the precioTotalProducto to set
	 */
	public void setPrecioTotalProducto(double precioTotalProducto) {
		this.precioTotalProducto = precioTotalProducto;
	}

}
