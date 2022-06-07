package com.santixiao.practicaEntornoCliente.ecommerce.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	Categoria findByNombre(String nombre);
}
