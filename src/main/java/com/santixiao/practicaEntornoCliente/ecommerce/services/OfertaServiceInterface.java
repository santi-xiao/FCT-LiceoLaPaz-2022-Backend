package com.santixiao.practicaEntornoCliente.ecommerce.services;

import java.util.List;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Oferta;

public interface OfertaServiceInterface {

	List<Oferta> buscarTodos();
	
	Oferta buscarPorId(Integer id);
	
	Oferta guardar(Oferta oferta);
	
	Oferta actualizar(Oferta oferta);
	
	String borrar(Integer id);
}
