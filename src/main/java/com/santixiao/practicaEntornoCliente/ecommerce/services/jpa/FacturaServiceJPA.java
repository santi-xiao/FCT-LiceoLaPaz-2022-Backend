package com.santixiao.practicaEntornoCliente.ecommerce.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Factura;
import com.santixiao.practicaEntornoCliente.ecommerce.repositorys.FacturaRepository;
import com.santixiao.practicaEntornoCliente.ecommerce.services.FacturaServiceInterface;

@Service
public class FacturaServiceJPA implements FacturaServiceInterface {

	@Autowired
	private FacturaRepository facturaRepo;
	
	@Override
	public List<Factura> buscarTodos() {
		return facturaRepo.findAll();
	}
	
	@Override
	public Factura buscarPorId(Integer id) {
		Optional<Factura> factura = facturaRepo.findById(id);
		if(factura.isPresent()) {
			return factura.get();
		}
		return null;
	}

	@Override
	public Factura guardar(Factura factura) {
		return facturaRepo.save(factura);
	}

	@Override
	public Factura actualizar(Factura factura) {
		return facturaRepo.save(factura);
	}

	@Override
	public String borrar(Integer id) {
		facturaRepo.deleteById(id);
		return "Borrado correctamente";
	}
}
