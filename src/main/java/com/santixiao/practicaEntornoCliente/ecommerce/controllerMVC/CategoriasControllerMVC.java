package com.santixiao.practicaEntornoCliente.ecommerce.controllerMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Categoria;
import com.santixiao.practicaEntornoCliente.ecommerce.services.CategoriaServiceInterface;

@Controller
@RequestMapping("/admin/categorias")
public class CategoriasControllerMVC {

	@Autowired
	private CategoriaServiceInterface categoriaService;
	
	@GetMapping("/nueva_categoria")
	public String nuevaCategoria() {
		return "admin/productos/formCategoria";
	}
	
	@PostMapping("/guardar_categoria")
	public String guardarCategoria(RedirectAttributes redirect, Categoria categoria) {
		categoriaService.guardar(categoria);
		redirect.addFlashAttribute("msg", "Categoría añadida con éxito.");
		return "redirect:/admin/productos/todos";
	}
	
	@GetMapping("/{nombre}/delete")
	public String eliminarCategoria(@PathVariable String nombre) {
		Categoria categoria = categoriaService.buscarPorNombre(nombre);
		if(categoria != null) {
			categoriaService.borrar(categoria.getId());
			return "redirect:/admin/productos/todos";
		}
		return null;
	}
	
}
