package com.santixiao.practicaEntornoCliente.ecommerce.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Categoria;
import com.santixiao.practicaEntornoCliente.ecommerce.repositorys.CategoriaRepository;
import com.santixiao.practicaEntornoCliente.ecommerce.services.CategoriaServiceInterface;

@Service
public class CategoriaServiceJPA implements CategoriaServiceInterface {

	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Override
	public List<Categoria> buscarTodos() {
		return categoriaRepo.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> categoria =  categoriaRepo.findById(id);
		if(categoria.isPresent()) {
			return categoria.get();
		}
		return null;
	}

	@Override
	public Categoria guardar(Categoria categoria) {
		return categoriaRepo.save(categoria);
	}

	@Override
	public Categoria actualizar(Categoria categoria) {
		return categoriaRepo.save(categoria);
	}

	@Override
	public String borrar(Integer id) {
		categoriaRepo.deleteById(id);
		return "Borrado correctamente";
	}

	@Override
	public Categoria buscarPorNombre(String nombre) {
		return categoriaRepo.findByNombre(nombre);
	}

}
