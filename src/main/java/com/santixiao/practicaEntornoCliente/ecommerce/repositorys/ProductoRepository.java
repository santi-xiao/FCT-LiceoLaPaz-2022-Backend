package com.santixiao.practicaEntornoCliente.ecommerce.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	List<Producto> findByCategoriaNombre(String categoria);
}
