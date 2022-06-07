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

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Factura;
import com.santixiao.practicaEntornoCliente.ecommerce.services.FacturaServiceInterface;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
	
	@Autowired
	private FacturaServiceInterface facturaService;

	@GetMapping("/todos")
	public List<Factura> buscarTodos(){
		return facturaService.buscarTodos();
	}
	
	@GetMapping("/factura/{id}")
	public Factura buscarPorId(@PathVariable("id") int id) {
		return facturaService.buscarPorId(id);
	}
	
	@PostMapping("/new")
	public Factura guardar(@RequestBody Factura factura) {
		return facturaService.guardar(factura);
	}
	
	@PutMapping("/update")
	public Factura actualizar(@RequestBody Factura factura) {
		return facturaService.actualizar(factura);
	}
	
	@DeleteMapping("/delete/{id}")
	public String borrar(@PathVariable("id") int id) {
		return facturaService.borrar(id);
	}
}
