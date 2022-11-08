package ticomo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ticomo.app.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@GetMapping({ "/", "/login" })
	public String index() {
		return "index";
	}

	@GetMapping("/users")
	public String loggueado() {
		return "users/" + service.getLoggedUserRol().toLowerCase(); // cambiar redirección a las views
	}

}
