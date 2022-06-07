package com.santixiao.practicaEntornoCliente.ecommerce.services;

import java.util.List;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Usuario;

public interface UsuarioServiceInterface {

	List<Usuario> buscarTodos();
	
	Usuario buscarPorId(Integer id);
	
	Usuario guardar(Usuario usuario);
	
	Usuario actualizar(Usuario usuario);
	
	String borrar(Integer id);
	
	Usuario buscarPorEmail(String email);
}
