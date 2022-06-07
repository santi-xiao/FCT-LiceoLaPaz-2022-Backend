package com.santixiao.practicaEntornoCliente.ecommerce.controllerMVC;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Categoria;
import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Oferta;
import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Producto;
import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Usuario;
import com.santixiao.practicaEntornoCliente.ecommerce.services.CategoriaServiceInterface;
import com.santixiao.practicaEntornoCliente.ecommerce.services.OfertaServiceInterface;
import com.santixiao.practicaEntornoCliente.ecommerce.services.ProductoServiceInterface;
import com.santixiao.practicaEntornoCliente.ecommerce.services.UsuarioServiceInterface;

@Controller
@RequestMapping("/admin/productos")
public class ProductoControllerMVC {
	
	@Autowired
	private ProductoServiceInterface productoService;
	
	@Autowired
	private CategoriaServiceInterface categoriaService;
	
	@Autowired
	private OfertaServiceInterface ofertaService;
	
	@Autowired
	private UsuarioServiceInterface usuarioService;
	
	
	@GetMapping("/todos")
	public String buscarTodos(Model model, Authentication auth, HttpSession session) {
		// Cosas de security
		String username = auth.getName();
		System.out.println("Nombre de usuario:" + username);
		
		for(GrantedAuthority rol : auth.getAuthorities()) {
			System.out.println("ROL:" + rol.getAuthority() );
		}
		if(session.getAttribute("usuario") == null) {
			Usuario usuario = usuarioService.buscarPorEmail(username);
			usuario.setContraseña(null);
			System.out.println("obejto usuario:" + usuario);
			session.setAttribute("usuario", usuario);			
		}
		//
		List<Producto> productos = productoService.buscarTodos();
		List<Categoria> listaCategorias = categoriaService.buscarTodos();
		model.addAttribute("productos" ,productos);
		model.addAttribute("listaCategorias", listaCategorias);
		return "admin/productos/productos";
	}

	@GetMapping("/delete/{id}")
	public String eliminarPorId(@PathVariable int id, RedirectAttributes redirect) {
		String msg = productoService.borrar(id);
		redirect.addFlashAttribute("msg", msg);
		return "redirect:/admin/productos/todos";
	}
	
	@GetMapping("/producto/{id}")
	public String buscarPorId(@PathVariable int id, Model model) {
		Producto producto =  productoService.buscarPorId(id);
		model.addAttribute("producto", producto);
		return "admin/productos/detalles";
	}
	
	@GetMapping("/nuevo_producto")
	public String nuevoProducto(Model model) {
		List<Categoria> listaCategorias = categoriaService.buscarTodos();
		List<Oferta> listaOfertas = ofertaService.buscarTodos();
		
		model.addAttribute("listaCategorias", listaCategorias);
		model.addAttribute("listaOfertas", listaOfertas);
		
		return "admin/productos/formProd";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Producto producto = productoService.buscarPorId(id);
		List<Categoria> listaCategorias = categoriaService.buscarTodos();
		List<Oferta> listaOfertas = ofertaService.buscarTodos();
		
		model.addAttribute("producto", producto);
		model.addAttribute("listaCategorias", listaCategorias);
		model.addAttribute("listaOfertas", listaOfertas);
		
		return "admin/productos/formProdEdit";
	}
	
	@PostMapping("/guardar")
	public String guardarProducto(Producto producto, RedirectAttributes redirect) {
		productoService.guardar(producto);
		redirect.addFlashAttribute("msg", "Producto añadido con éxito.");
		return "redirect:/admin/productos/todos";
	}
	
	@GetMapping("/{nombre}/todos")
	public String filtarProductos(@PathVariable String nombre, Model model) {
		List<Producto> productos = productoService.buscarProductosporCategoria(nombre);
		List<Categoria> listaCategorias = categoriaService.buscarTodos();
		model.addAttribute("productos" ,productos);
		model.addAttribute("listaCategorias", listaCategorias);
		model.addAttribute("cat", nombre);
		return "admin/productos/productos";	
	}
}
