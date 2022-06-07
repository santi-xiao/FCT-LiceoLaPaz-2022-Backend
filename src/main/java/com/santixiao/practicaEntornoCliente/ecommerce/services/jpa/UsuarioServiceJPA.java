package com.santixiao.practicaEntornoCliente.ecommerce.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Usuario;
import com.santixiao.practicaEntornoCliente.ecommerce.repositorys.UsuarioRepository;
import com.santixiao.practicaEntornoCliente.ecommerce.services.UsuarioServiceInterface;

@Service
public class UsuarioServiceJPA implements UsuarioServiceInterface {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Override
	public List<Usuario> buscarTodos() {
		return usuarioRepo.findAll();
	}
	
	@Override
	public Usuario buscarPorId(Integer id) {
		Optional<Usuario> usuario = usuarioRepo.findById(id);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		return null;
	}

	@Override
	public Usuario guardar(Usuario usuario) {		
		return usuarioRepo.save(usuario);
	}

	@Override
	public Usuario actualizar(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}

	@Override
	public String borrar(Integer id) {
		usuarioRepo.deleteById(id);
		return "Borrado correctamente";
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return usuarioRepo.findByEmail(email);
		
	}

}
