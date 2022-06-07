package com.santixiao.practicaEntornoCliente.ecommerce.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select email, contraseña, activo from Usuarios where email=?")
				.authoritiesByUsernameQuery(
						"select email, Tipo_usuario.nombre from Usuarios inner join Tipo_usuario on Usuarios.tipo = Tipo_usuario.id where email = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests().antMatchers("/api/productos/todos",
											"/api/productos/producto/{id}",
											"/api/productos/{nombre}/todos",
											"/api/productos/new",
											"/api/usuarios/new").permitAll().antMatchers("/admin/**").hasAnyAuthority("ADMIN").and().formLogin().loginPage("/login").permitAll();
	}


}
