package com.santixiao.practicaEntornoCliente.ecommerce.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.TipoUsuario;
import com.santixiao.practicaEntornoCliente.ecommerce.repositorys.TipoUsuarioRepository;
import com.santixiao.practicaEntornoCliente.ecommerce.services.TipoUsuarioServiceInterface;

@Service
public class TipoUsuarioServiceJPA implements TipoUsuarioServiceInterface {

	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepo;
	
	@Override
	public List<TipoUsuario> buscarTodos() {
		return tipoUsuarioRepo.findAll();
	}
	
	@Override
	public TipoUsuario buscarPorId(Integer id) {
		Optional<TipoUsuario> tipo = tipoUsuarioRepo.findById(id);
		if(tipo.isPresent()) {
			return tipo.get();
		}
		return null;
	}

	@Override
	public TipoUsuario guardar(TipoUsuario tipoUsuario) {
		return tipoUsuarioRepo.save(tipoUsuario);
	}

	@Override
	public TipoUsuario actualizar(TipoUsuario tipoUsuario) {
		return tipoUsuarioRepo.save(tipoUsuario);
	}

	@Override
	public String borrar(Integer id) {
		tipoUsuarioRepo.deleteById(id);
		return "Borrado correctamente";
	}

}
