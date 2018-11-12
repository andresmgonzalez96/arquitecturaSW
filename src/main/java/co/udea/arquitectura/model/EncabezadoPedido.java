package co.udea.arquitectura.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "encabezadoPedido")
public class EncabezadoPedido {

	@Id
	private int id;
	private String cliente;
	private Date fecha;
	private String formaPago;
	private double descuento;
	private double totalDescuentos;
	private double totalPedido;
	private String state;

	public EncabezadoPedido() {
		super();
	}

	public EncabezadoPedido(int id, String cliente, Date fecha, String formaPago, double descuento,
			double totalDescuentos, double totalPedido, String state) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.fecha = fecha;
		this.formaPago = formaPago;
		this.descuento = descuento;
		this.totalDescuentos = totalDescuentos;
		this.totalPedido = totalPedido;
		this.state = state;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the formaPago
	 */
	public String getFormaPago() {
		return formaPago;
	}

	/**
	 * @param formaPago the formaPago to set
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
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
	 * @return the totalDescuentos
	 */
	public double getTotalDescuentos() {
		return totalDescuentos;
	}

	/**
	 * @param totalDescuentos the totalDescuentos to set
	 */
	public void setTotalDescuentos(double totalDescuentos) {
		this.totalDescuentos = totalDescuentos;
	}

	/**
	 * @return the totalPedido
	 */
	public double getTotalPedido() {
		return totalPedido;
	}

	/**
	 * @param totalPedido the totalPedido to set
	 */
	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}
