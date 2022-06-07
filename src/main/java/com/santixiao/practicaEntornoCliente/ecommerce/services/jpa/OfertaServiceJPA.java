package com.santixiao.practicaEntornoCliente.ecommerce.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Oferta;
import com.santixiao.practicaEntornoCliente.ecommerce.repositorys.OfertaRepository;
import com.santixiao.practicaEntornoCliente.ecommerce.services.OfertaServiceInterface;

@Service
public class OfertaServiceJPA implements OfertaServiceInterface {

	@Autowired
	private OfertaRepository ofertaRepo;
	
	@Override
	public List<Oferta> buscarTodos() {
		return ofertaRepo.findAll();
	}

	@Override
	public Oferta buscarPorId(Integer id) {
		Optional<Oferta> oferta = ofertaRepo.findById(id);
		if(oferta.isPresent()) {
			return oferta.get();
		}
		return null;
	}

	@Override
	public Oferta guardar(Oferta oferta) {
		return ofertaRepo.save(oferta);
	}

	@Override
	public Oferta actualizar(Oferta oferta) {
		return ofertaRepo.save(oferta);
	}

	@Override
	public String borrar(Integer id) {
		ofertaRepo.deleteById(id);
		return "Borrado correctamente";
	}

}
