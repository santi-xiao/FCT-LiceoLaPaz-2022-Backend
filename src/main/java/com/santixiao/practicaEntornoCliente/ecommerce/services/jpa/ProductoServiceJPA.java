package com.santixiao.practicaEntornoCliente.ecommerce.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Producto;
import com.santixiao.practicaEntornoCliente.ecommerce.repositorys.ProductoRepository;
import com.santixiao.practicaEntornoCliente.ecommerce.services.ProductoServiceInterface;

@Service
public class ProductoServiceJPA implements ProductoServiceInterface {

	@Autowired
	private ProductoRepository productoRepo;
	
	@Override
	public List<Producto> buscarTodos() {
		return productoRepo.findAll();
	}

	@Override
	public Producto buscarPorId(Integer id) {
		Optional<Producto> producto = productoRepo.findById(id);
		if(producto.isPresent()) {
			return producto.get();
		}
		return null;
	}

	@Override
	public Producto guardar(Producto producto) {
		return productoRepo.save(producto);
	}

	@Override
	public Producto actualizar(Producto producto) {
		return productoRepo.save(producto);
	}

	@Override
	public String borrar(Integer id) {
		productoRepo.deleteById(id);
		return "Borrado correctamente";
	}

	@Override
	public List<Producto> buscarProductosporCategoria(String nombre) {
		return productoRepo.findByCategoriaNombre(nombre);
	}
}
