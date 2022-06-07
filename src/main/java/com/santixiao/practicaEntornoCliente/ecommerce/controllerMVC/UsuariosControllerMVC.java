package com.santixiao.practicaEntornoCliente.ecommerce.controllerMVC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.TipoUsuario;
import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Usuario;
import com.santixiao.practicaEntornoCliente.ecommerce.services.TipoUsuarioServiceInterface;
import com.santixiao.practicaEntornoCliente.ecommerce.services.UsuarioServiceInterface;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuariosControllerMVC {

	@Autowired
	private UsuarioServiceInterface usuarioService;
	
	@Autowired
	private TipoUsuarioServiceInterface tipoService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/new_user")
	public String nuevoUsuario(Model model) {
		List<TipoUsuario> listaTipos = tipoService.buscarTodos();
		model.addAttribute("listaTipos", listaTipos);
		return "admin/usuarios/nuevo_usuario";
	}
	
	@PostMapping("/guardar")
	public String guardarRegistro(Usuario usuario, RedirectAttributes redirect) {
		String passPlano = usuario.getContraseña();
		String passEncriptado = passwordEncoder.encode(passPlano);
		usuario.setContraseña(passEncriptado);
		
		usuarioService.guardar(usuario);
		
		return "redirect:/admin/productos/todos";
	}
}
