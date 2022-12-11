package com.dawes.manuelmc09.proyecto.vivero.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.manuelmc09.proyecto.vivero.entities.Pedidos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Usuario;
import com.dawes.manuelmc09.proyecto.vivero.repositories.PedidosRepository;
import com.dawes.manuelmc09.proyecto.vivero.repositories.UsuarioRepository;
import com.dawes.manuelmc09.proyecto.vivero.services.PedidosService;
import com.dawes.manuelmc09.proyecto.vivero.services.ProductosService;

/**
 * 
 * @author manuelmc09
 *
 */
@Service
public class PedidosServiceImpl implements PedidosService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PedidosRepository pedidosRepository;

	@Autowired
	private ProductosService productosService;

	@Override
	public List<Pedidos> findAll() {
		return pedidosRepository.findAll();
	}

	@Override
	public Optional<Pedidos> findById(Integer id) {
		return pedidosRepository.findById(id);
	}

	/*
	 * @Override public List<Pedidos> findPedidosUser() { Object usuario =
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); String
	 * u = ((UserDetails) usuario).getUsername(); Optional<Usuario> user =
	 * usuarioRepository.findByUser(u); List<Pedidos>
	 * pedidos=pedidosRepository.findIdUser(user.get().getIdusuario()); return null;
	 * }
	 */

	@Override
	public <S extends Pedidos> S save(S entity) {
		return pedidosRepository.save(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return pedidosRepository.existsById(id);
	}

	@Override
	public void deleteById(Integer id) {
		pedidosRepository.deleteById(id);

	}

	@Override
	public void delete(Pedidos entity) {
		pedidosRepository.delete(entity);

	}

	@Override
	public Pedidos getOne(Integer id) {
		return pedidosRepository.getOne(id);
	}

	@Override
	public void deleteAll() {
		pedidosRepository.deleteAll();
	}

	@Override
	public Pedidos getById(Integer id) {
		return pedidosRepository.getById(id);
	}

	@Override
	public Pedidos insertar(Pedidos pedido, Usuario usuario) {
		pedido.setPropietario(usuario);
		return pedidosRepository.save(pedido);
	}

	@Override
	public Pedidos insertar(Pedidos pedido) {
		return pedidosRepository.save(pedido);
	}

	@Override
	public Productos addProductoPedido(Productos producto, Pedidos pedido) {
		producto.setPedido(pedido);
		return productosService.save(producto);
	}

}
