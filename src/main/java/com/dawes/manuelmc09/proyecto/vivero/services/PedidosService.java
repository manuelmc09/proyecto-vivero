package com.dawes.manuelmc09.proyecto.vivero.services;

import java.util.List;
import java.util.Optional;

import com.dawes.manuelmc09.proyecto.vivero.entities.Pedidos;

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

}
