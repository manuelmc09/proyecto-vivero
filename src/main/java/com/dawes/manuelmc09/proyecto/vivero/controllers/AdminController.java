package com.dawes.manuelmc09.proyecto.vivero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Usuario;
import com.dawes.manuelmc09.proyecto.vivero.services.ProductosService;
import com.dawes.manuelmc09.proyecto.vivero.services.RolService;
import com.dawes.manuelmc09.proyecto.vivero.services.UsuarioService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductosService productosService;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	RolService rolService;

	@RequestMapping("/indexadmin")
	public String indexAdmin() {
		return "admin/indexadmin";
	}

	@RequestMapping("/verproductos")
	public String verProductos(Model model) {
		model.addAttribute("productos", productosService.findAll());
		return "admin/verproductos";
	}
	@RequestMapping("/verusuarios")
	public String verUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.findAll());
		return "admin/verusuarios";
	}

	@RequestMapping("insertarproducto")
	public String insertarProducto(Model model) {
		model.addAttribute("producto", new Productos());
		return ("/admin/forminsertarproducto");
	}

	@RequestMapping(value = "/persistir", method = RequestMethod.POST)
	public String persistir(@ModelAttribute Productos producto) {
		productosService.save(producto);
		return "redirect:/admin/verproductos";
	}
	@RequestMapping(value = "/persistirusuario", method = RequestMethod.POST)
	public String persistirusuario(@ModelAttribute Usuario usuario) {
		usuario.setRol(rolService.getById(2));
			//para Heroku
//		usuario.setRol(rolService.getById(11));
		usuarioService.save(usuario);
		return "redirect:/admin/verusuarios";
	}

	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam int idproducto) {
		productosService.deleteById(idproducto);
		return "redirect:/admin/verproductos";
	}
	@RequestMapping("/eliminarusuario")
	public String eliminarusuario(@RequestParam int idusuario) {
		usuarioService.deleteById(idusuario);
		return "redirect:/admin/verusuario";
	}
	@RequestMapping("modificar")
	public String modificar(@RequestParam int idproducto,Model model) {
		model.addAttribute("producto", productosService.findById(idproducto));
		
		return "admin/modificarproducto";
	}
//	@RequestMapping("modificarusuario")
//	public String modificarusuario(@RequestParam int idusuario,Model model) {
////		Usuario u=usuarioService.getById(idusuario);
//	model.addAttribute("usuario", usuarioService.findById(idusuario));
////		model.addAttribute("usuario",u);
//		return "admin/modificarusuario";
//	}
	@RequestMapping("modificarusuario")
	public String modificarUsuario(@RequestParam int idusuario,Model model) {
		model.addAttribute("usuario",usuarioService.findById(idusuario));
		return "admin/modificarusuario";
	}
}
