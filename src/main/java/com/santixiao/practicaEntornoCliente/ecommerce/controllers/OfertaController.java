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

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Oferta;
import com.santixiao.practicaEntornoCliente.ecommerce.services.OfertaServiceInterface;

@RestController
@RequestMapping("/api/ofertas")
public class OfertaController {

	@Autowired
	private OfertaServiceInterface ofertaService;
	
	@GetMapping("/todos")
	public List<Oferta> buscarTodos(){
		return ofertaService.buscarTodos();
	}
	
	@GetMapping("/oferta/{id}")
	public Oferta buscarPorId(@PathVariable("id") int id) {
		return ofertaService.buscarPorId(id);
	}
	
	@PostMapping("/new")
	public Oferta guardar(@RequestBody Oferta oferta) {
		return ofertaService.guardar(oferta);
	}
	
	@PutMapping("/update")
	public Oferta actualizar(@RequestBody Oferta oferta) {
		return ofertaService.actualizar(oferta);
	}
	
	@DeleteMapping("/delete/{id}")
	public String borrar(@PathVariable("id") int id) {
		return ofertaService.borrar(id);
	}
}
