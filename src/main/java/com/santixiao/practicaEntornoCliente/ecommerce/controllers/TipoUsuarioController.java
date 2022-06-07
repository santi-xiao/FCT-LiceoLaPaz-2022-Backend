package com.santixiao.practicaEntornoCliente.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.TipoUsuario;
import com.santixiao.practicaEntornoCliente.ecommerce.services.TipoUsuarioServiceInterface;

@RestController
@RequestMapping("/api/tipo-usuario")
public class TipoUsuarioController {

	@Autowired
	private TipoUsuarioServiceInterface tipoUsuarioInterface;
	
	@GetMapping("/todos")
	public List<TipoUsuario> buscarTodos(){
		return tipoUsuarioInterface.buscarTodos();
	}
	
	@GetMapping("/tipo/{id}")
	public TipoUsuario buscarPorId(@PathVariable("id") int id) {
		return tipoUsuarioInterface.buscarPorId(id);
	}
	
	@PostMapping("/new")
	public TipoUsuario guardar(@RequestBody TipoUsuario tipo) {
		return tipoUsuarioInterface.guardar(tipo);
	}
	
	@PutMapping("/update")
	public TipoUsuario actualizar(@RequestBody TipoUsuario tipo) {
		return tipoUsuarioInterface.actualizar(tipo);
	}
	
	@DeleteMapping("/delete/{id}")
	public String borrar(@PathVariable("id") int id) {
		return tipoUsuarioInterface.borrar(id);
	}
}
