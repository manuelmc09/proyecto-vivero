package com.dawes.manuelmc09.proyecto.vivero.services;

import java.util.List;
import java.util.Optional;

import com.dawes.manuelmc09.proyecto.vivero.entities.Pedidos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Usuario;

/**
 * 
 * @author manuelmc09
 *
 */
public interface PedidosService {

	List<Pedidos> findAll();

	Optional<Pedidos> findById(Integer id);

	/*
	 * List<Pedidos> findPedidosUser();
	 */
	<S extends Pedidos> S save(S entity);

	boolean existsById(Integer id);

	void deleteById(Integer id);

	void delete(Pedidos entity);

	Pedidos getOne(Integer id);

	void deleteAll();

	Pedidos getById(Integer id);

	Pedidos insertar(Pedidos pedido, Usuario usuario);

	Pedidos insertar(Pedidos pedido);
	
	Productos addProductoPedido(Productos producto, Pedidos pedido);

}
