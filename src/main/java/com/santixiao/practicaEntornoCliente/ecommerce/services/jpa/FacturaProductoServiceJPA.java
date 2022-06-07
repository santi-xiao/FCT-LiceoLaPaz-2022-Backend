package com.santixiao.practicaEntornoCliente.ecommerce.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.FacturaProducto;
import com.santixiao.practicaEntornoCliente.ecommerce.repositorys.FacturaProductoRepository;
import com.santixiao.practicaEntornoCliente.ecommerce.services.FacturaProductoServiceInterface;

@Service
public class FacturaProductoServiceJPA implements FacturaProductoServiceInterface {

	@Autowired
	private FacturaProductoRepository facturaProductoRepo;
		
	@Override
	public List<FacturaProducto> buscarTodos() {
		return facturaProductoRepo.findAll();
	}
	
	@Override
	public FacturaProducto buscarPorId(Integer id) {
		Optional<FacturaProducto> producto = facturaProductoRepo.findById(id);
		if(producto.isPresent()) {
			return producto.get();
		}
		return null;
	}

	@Override
	public FacturaProducto guardar(FacturaProducto facturaProducto) {
		return facturaProductoRepo.save(facturaProducto);
	}

	@Override
	public FacturaProducto actualizar(FacturaProducto facturaProducto) {
		return facturaProductoRepo.save(facturaProducto);
	}

	@Override
	public String borrar(Integer id) {
				facturaProductoRepo.deleteById(id);
				return "Borrado correctamente"; 
	}

}
