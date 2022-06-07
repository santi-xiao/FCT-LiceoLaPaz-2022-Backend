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
@Table(name="productos")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	private String imagenDni;
	private String imagenCuerpo;
	private Double precio;
	@ManyToOne
	@JoinColumn(name ="oferta")
	@JsonBackReference
	private Oferta oferta;
	private Boolean activo;
	@ManyToOne
	@JoinColumn(name="categoria")
	private Categoria categoria;
	private Boolean publico;
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Oferta getOferta() {
		return oferta;
	}
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Boolean getPublico() {
		return publico;
	}
	public void setPublico(Boolean publico) {
		this.publico = publico;
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", oferta=" + oferta + ", activo=" + activo + ", categoria=" + categoria
				+ ", publico=" + publico + "]";
	}
	public String getImagenDni() {
		return imagenDni;
	}
	public void setImagenDni(String imagenDni) {
		this.imagenDni = imagenDni;
	}
	public String getImagenCuerpo() {
		return imagenCuerpo;
	}
	public void setImagenCuerpo(String imagenCuerpo) {
		this.imagenCuerpo = imagenCuerpo;
	}
}
