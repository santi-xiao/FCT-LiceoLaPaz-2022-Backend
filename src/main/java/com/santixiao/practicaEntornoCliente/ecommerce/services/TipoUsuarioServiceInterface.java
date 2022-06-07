package com.santixiao.practicaEntornoCliente.ecommerce.services;

import java.util.List;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.TipoUsuario;

public interface TipoUsuarioServiceInterface {

	List<TipoUsuario> buscarTodos();
	
	TipoUsuario buscarPorId(Integer id);
	
	TipoUsuario guardar(TipoUsuario tipoUsuario);
	
	TipoUsuario actualizar(TipoUsuario tipoUsuario);
	
	String borrar(Integer id);
}
