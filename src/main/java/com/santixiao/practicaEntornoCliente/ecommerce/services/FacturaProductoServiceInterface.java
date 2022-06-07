package com.santixiao.practicaEntornoCliente.ecommerce.services;

import java.util.List;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.FacturaProducto;

public interface FacturaProductoServiceInterface {

	List<FacturaProducto> buscarTodos();
	
	FacturaProducto buscarPorId(Integer id);
	
	FacturaProducto guardar(FacturaProducto facturaProducto);
	
	FacturaProducto actualizar( FacturaProducto facturaProducto);
	
	String borrar(Integer id);
}
