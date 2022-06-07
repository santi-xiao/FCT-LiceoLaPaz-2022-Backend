package com.santixiao.practicaEntornoCliente.ecommerce.entitys;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="oferta")
public class Oferta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer cantidad;
	private Boolean activo;
	@OneToMany(mappedBy = "oferta")
	@JsonManagedReference
	private List<Producto> productos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	@Override
	public String toString() {
		return "Oferta [id=" + id + ", cantidad=" + cantidad + ", activo=" + activo + "]";
	}
	
}
