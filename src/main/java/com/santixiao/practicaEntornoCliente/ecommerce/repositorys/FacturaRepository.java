package com.santixiao.practicaEntornoCliente.ecommerce.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
