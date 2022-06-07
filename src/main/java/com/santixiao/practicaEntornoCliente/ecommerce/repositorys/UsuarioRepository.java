package com.santixiao.practicaEntornoCliente.ecommerce.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santixiao.practicaEntornoCliente.ecommerce.entitys.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByEmail(String email);
}
