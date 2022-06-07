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

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Producto;
import com.santixiao.practicaEntornoCliente.ecommerce.services.ProductoServiceInterface;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private ProductoServiceInterface productoService;
	
	@GetMapping("/todos")
	public List<Producto> buscarTodos(){
		return productoService.buscarTodos();
	}
	
	@GetMapping("/producto/{id}")
	public Producto buscarPorId(@PathVariable("id") int id) {
		return productoService.buscarPorId(id);
	}
	
	@PostMapping("/new")
	public Producto guardar(@RequestBody Producto producto) {
		return productoService.guardar(producto);
	}
	
	@PutMapping("/update")
	public Producto actualizar(@RequestBody Producto producto) {
		return productoService.actualizar(producto);
	}
	
	@DeleteMapping("/delete/{id}")
	public String borrar(@PathVariable("id") int id) {
		return productoService.borrar(id);
	}
	
	@GetMapping("/{nombre}/todos")
	public List<Producto> buscarPorCategoria(@PathVariable("nombre") String nombre){
		return productoService.buscarProductosporCategoria(nombre);
	}
}
