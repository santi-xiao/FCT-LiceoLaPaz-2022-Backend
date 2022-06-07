package com.santixiao.practicaEntornoCliente.ecommerce.controllerMVC;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeControllerMVC {
	
	@GetMapping("/")
	public String paginaPrincipal() {
		return "redirect:/admin/productos/todos";
	}

	@GetMapping("/login")
		public String mostrarLogin() {
			return "login";
		}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/login";
	}
}
