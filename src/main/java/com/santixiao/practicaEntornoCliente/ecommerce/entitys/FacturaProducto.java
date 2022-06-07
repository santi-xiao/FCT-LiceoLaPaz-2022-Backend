package com.santixiao.practicaEntornoCliente.ecommerce.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="factura_producto")
public class FacturaProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private Double precio;
	private Integer cantidad;
	private Integer impuestos;
	private Integer descuento;
	@ManyToOne
	@JoinColumn(name="facturaid")
	@JsonBackReference
	private Factura facturaid;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(Integer impuestos) {
		this.impuestos = impuestos;
	}
	public Integer getDescuento() {
		return descuento;
	}
	public void setDescuento(Integer descuesto) {
		this.descuento = descuesto;
	}
	public Factura getFacturaid() {
		return facturaid;
	}
	public void setFacturaid(Factura facturaid) {
		this.facturaid = facturaid;
	}
	@Override
	public String toString() {
		return "FacturaProducto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad
				+ ", impuestos=" + impuestos + ", descuesto=" + descuento + ", facturaid=" + facturaid + "]";
	}
}
