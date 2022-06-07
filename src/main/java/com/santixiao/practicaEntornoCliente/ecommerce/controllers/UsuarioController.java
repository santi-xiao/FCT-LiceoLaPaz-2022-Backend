package com.santixiao.practicaEntornoCliente.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.TipoUsuario;
import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Usuario;
import com.santixiao.practicaEntornoCliente.ecommerce.services.UsuarioServiceInterface;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioServiceInterface usuarioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/todos")
	public List<Usuario> buscarTodos(){
		return usuarioService.buscarTodos();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario buscarPorId(@PathVariable("id") int id) {
		return usuarioService.buscarPorId(id);
	}

	@PostMapping("/new")
	public Usuario guardar(@RequestBody Usuario usuario) {
		TipoUsuario tp = new TipoUsuario(2);
		usuario.setTipo(tp);
		String pass = usuario.getContraseña();
		String encodedpass = passwordEncoder.encode(pass);
		usuario.setContraseña(encodedpass);
		usuario.setActivo(true);
		return usuarioService.guardar(usuario);
	}
	
	@PutMapping("/update")
	public Usuario actualizar(@RequestBody Usuario usuario) {
		return usuarioService.actualizar(usuario);
	}
	
	@DeleteMapping("/delete/{id}")
	public String borrar(@PathVariable("id") int id) {
		return usuarioService.borrar(id);
	}
	
}