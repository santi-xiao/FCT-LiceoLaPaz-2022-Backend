package com.santixiao.practicaEntornoCliente.ecommerce.services;

import java.util.List;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Producto;

public interface ProductoServiceInterface {

	List<Producto> buscarTodos();
	
	Producto buscarPorId(Integer id);
	
	Producto guardar(Producto producto);
	
	Producto actualizar(Producto producto);
	
	String borrar(Integer id);
	
	List<Producto> buscarProductosporCategoria(String nombre);
	}
