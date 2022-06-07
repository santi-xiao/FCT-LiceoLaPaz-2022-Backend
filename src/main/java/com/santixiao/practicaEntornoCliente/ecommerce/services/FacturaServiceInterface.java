package com.santixiao.practicaEntornoCliente.ecommerce.services;

import java.util.List;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Factura;

public interface FacturaServiceInterface {

	List<Factura> buscarTodos();
	
	Factura buscarPorId(Integer id);
	
	Factura guardar(Factura factura);
	
	Factura actualizar(Factura factura);
	
	String borrar(Integer id);
}
