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

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Categoria;
import com.santixiao.practicaEntornoCliente.ecommerce.services.CategoriaServiceInterface;


@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaServiceInterface categoriaService;
	
	@GetMapping("/todos")
	public List<Categoria> buscarTodos(){
		return categoriaService.buscarTodos();
	}
	
	@GetMapping("/categoria/{id}")
	public Categoria buscarPorId(@PathVariable("id") int id) {
		return categoriaService.buscarPorId(id);
	}
	
	@PostMapping("/new")
	public Categoria guardar(@RequestBody Categoria categoria) {
		return categoriaService.guardar(categoria);
	}
	
	@PutMapping("/update")
	public Categoria actualizar(@RequestBody Categoria categoria) {
		return categoriaService.actualizar(categoria);
	}
	
	@DeleteMapping("/delete/{id}")
	public String borrar(@PathVariable("id") int id) {
		return categoriaService.borrar(id);
	}
}
