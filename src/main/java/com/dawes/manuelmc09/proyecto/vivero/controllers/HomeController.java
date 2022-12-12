package com.dawes.manuelmc09.proyecto.vivero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.manuelmc09.proyecto.vivero.entities.Usuario;
import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;
import com.dawes.manuelmc09.proyecto.vivero.services.ProductosService;
import com.dawes.manuelmc09.proyecto.vivero.services.RolService;
import com.dawes.manuelmc09.proyecto.vivero.services.SecurityService;
import com.dawes.manuelmc09.proyecto.vivero.services.UsuarioService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	ProductosService productosService;

	@Autowired
	SecurityService securityService;

	@Autowired
	RolService rolService;

	@RequestMapping("/")
	public String homeView(Model model) {
		List<Productos> productos = productosService.findAll();
		model.addAttribute("productos", productos);
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
//
//	@RequestMapping("/logout")
//	public String logout() {
//		return "logout";
//	}

	@RequestMapping("/nosotros")
	public String nosotros() {
		return "nosotros";
	}

	@RequestMapping("/contactanos")
	public String contacto() {
		return "contactanos";

	}

	@RequestMapping("/registrarse")
	public String registrarse(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro";
	}
	

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Usuario usuario,  Model model) {
		String username = usuario.getUsername();
		String logemail = usuario.getEmail();
		String logname = usuario.getNombre();
		String password = usuario.getPassword();
//		usuario.setRol(rolService.getById(2));
		//para Heroku
		usuario.setRol(rolService.getById(11));
		usuario.setUsername(username);
		usuario.setEmail(logemail);
		usuario.setNombre(logname);
		usuarioService.save(usuario);
		return "index";
	}

	

}
