package com.santixiao.practicaEntornoCliente.ecommerce.services;

import java.util.List;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Categoria;

public interface CategoriaServiceInterface {

	List<Categoria> buscarTodos();
	
	Categoria buscarPorId(Integer id);
	
	Categoria buscarPorNombre(String nombre);
	
	Categoria guardar(Categoria categoria);
	
	Categoria actualizar(Categoria categoria);
	
	String borrar(Integer id);
	
}
