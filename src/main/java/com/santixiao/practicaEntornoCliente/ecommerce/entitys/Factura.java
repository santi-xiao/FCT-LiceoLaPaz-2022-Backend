package com.santixiao.practicaEntornoCliente.ecommerce.entitys;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="facturas")
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="id_usuario")
	@JsonBackReference
	private Usuario usuario;
	@OneToMany(mappedBy="facturaid")
	@JsonManagedReference
	private List<FacturaProducto> productos;
	private Double precio_final;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<FacturaProducto> getProductos() {
		return productos;
	}
	public void setProductos(List<FacturaProducto> productos) {
		this.productos = productos;
	}
	public Double getPrecio_final() {
		return precio_final;
	}
	public void setPrecio_final(Double precio_final) {
		this.precio_final = precio_final;
	}
	@Override
	public String toString() {
		return "Factura [id=" + id + ", usuario=" + usuario + ", productos=" + productos + ", precio_final="
				+ precio_final + "]";
	}
	
}
