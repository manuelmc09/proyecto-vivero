package com.dawes.manuelmc09.proyecto.vivero.controllers;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.manuelmc09.proyecto.vivero.dto.PedidosDTO;
import com.dawes.manuelmc09.proyecto.vivero.entities.Pedidos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Usuario;
import com.dawes.manuelmc09.proyecto.vivero.mapper.PedidosMapper;
import com.dawes.manuelmc09.proyecto.vivero.services.PedidosService;
import com.dawes.manuelmc09.proyecto.vivero.services.ProductosService;
import com.dawes.manuelmc09.proyecto.vivero.services.RolService;
import com.dawes.manuelmc09.proyecto.vivero.services.SecurityService;
import com.dawes.manuelmc09.proyecto.vivero.services.UsuarioService;

/**
 * 
 * @author manuelmc09
 *
 */

@Controller
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

//	@Autowired
//	PedidosMapper pedidosMapper;

	@Autowired
	PedidosService pedidosService;

	@Autowired
	RolService rolService;

	@Autowired
	SecurityService securityService;

	@Autowired
	ProductosService productosService;

	@Autowired
	HttpSession session;

	@RequestMapping("/carrito")
	public String verCarrito(Model model) {

		return "user/carrito";

	}
//	@RequestMapping("carrito")
//	public List<Productos> carrito(Model model) {
//		List<Integer> contenido = (List<Integer>) session.getAttribute("carrito");
//
//		return (contenido == null) ? null : productosService.variosPorId(contenido);
//
//	}

	@RequestMapping("/confirmarCompra")
	public String confirmarCompra(Model model, Authentication Authentication, HttpSession sesion) {
		return "/user/confirmacionCompra";
	}

	@RequestMapping("/miperfil")
	public String miPerfil(Model model,Authentication authentication) {
		Usuario usuario=usuarioService.findByUsername(authentication.getName());
		model.addAttribute("usuario",usuario);
		return "user/miperfil";
	}
	@RequestMapping("/editarperfil")
	public String editarPerfil(Model model,Authentication authentication) {
		Usuario usuario=usuarioService.findByUsername(authentication.getName());
		model.addAttribute("usuario",usuario);
		return "user/editarperfil";
	}
//	@RequestMapping("modificarusuario")
//	public String modificarusuario(@RequestParam int idusuario,Model model) {
//		model.addAttribute("usuario", usuarioService.findById(idusuario));
//		
//		return "admin/productos/modificarusuario";
//	}
//	@RequestMapping(value = "/persistirusuario", method = RequestMethod.POST)
//	public String persistirusuario(@ModelAttribute Usuario usuario) {
////		usuario.setRol(rolService.findById(2).get());
//		usuario.setRol(rolService.getById(2));
//		usuarioService.save(usuario);
//		return "redirect:/admin/verusuarios";
//	}
	@RequestMapping(value="/guardarperfil",method=RequestMethod.POST)
		public String guardarPerfil(@ModelAttribute Usuario usuario) {
//		String nombre=
//		usuario.setNombre(nombre);
		usuario.setPassword(usuario.getPassword());
		usuario.setRol(rolService.getById(11));
		usuario.setUsername(usuario.getUsername());
		usuarioService.save(usuario);
		return "redirect:/user/miperfil";
		
	}
}
