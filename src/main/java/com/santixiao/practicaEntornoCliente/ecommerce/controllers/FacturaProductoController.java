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

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.FacturaProducto;
import com.santixiao.practicaEntornoCliente.ecommerce.services.FacturaProductoServiceInterface;

@RestController
@RequestMapping("/api/productos-factura")
public class FacturaProductoController {

	@Autowired
	private FacturaProductoServiceInterface facturaProductosService;
	
	@GetMapping("/todos")
	public List<FacturaProducto> buscarTodos(){
		return facturaProductosService.buscarTodos();
	}
	
	@GetMapping("/producto/{id}")
	public FacturaProducto buscarPorId(@PathVariable("id") int id) {
		return facturaProductosService.buscarPorId(id);
	}
	
	@PostMapping("/new")
	public FacturaProducto guardar(@RequestBody FacturaProducto facturaProducto) {
		return facturaProductosService.guardar(facturaProducto);
	}
	
	@PutMapping("/update")
	public FacturaProducto actualizar(@RequestBody FacturaProducto facturaProducto) {
		return facturaProductosService.actualizar(facturaProducto);
	}
	
	@DeleteMapping("/delete/{id}")
	public String borrar(@PathVariable("id") int id) {
		return facturaProductosService.borrar(id);
	}
}
