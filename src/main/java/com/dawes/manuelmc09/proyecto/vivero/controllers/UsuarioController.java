package com.dawes.manuelmc09.proyecto.vivero.controllers;

import java.util.HashSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.manuelmc09.proyecto.vivero.dto.PedidosDTO;
import com.dawes.manuelmc09.proyecto.vivero.entities.Pedidos;
import com.dawes.manuelmc09.proyecto.vivero.mapper.PedidosMapper;
import com.dawes.manuelmc09.proyecto.vivero.services.PedidosService;
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

	@RequestMapping("/carrito")
	public String carrito(HttpSession sesion,Model model, @RequestParam Integer idpedido) {
//		if(sesion.getAttribute("carrito")==null) {
//			sesion.setAttribute("carrito", new HashSet<PedidosDTO>());
//		}
//		
//		HashSet<PedidosDTO> carrito = (HashSet<PedidosDTO>) sesion.getAttribute("carrito");
//		if ( idpedido != null) {
//			Pedidos pedido=pedidosService.findById(idpedido).get();
//			carrito.add(pedidosMapper.toPedidosDTO(pedido));
//		
//
//			sesion.setAttribute("carrito", carrito);
//		}
//		
		
		
		
		return "user/carrito";
	}
	
	@RequestMapping("/confirmarCompra")
	public String confirmarCompra(Model model, Authentication Authentication,HttpSession sesion) {
		return "/user/confirmacionCompra";
	}

	@RequestMapping("/miperfil")
	public String miPerfil() {
		return "user/miperfil";
	}
}
