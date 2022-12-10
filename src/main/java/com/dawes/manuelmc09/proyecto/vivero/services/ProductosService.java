package com.dawes.manuelmc09.proyecto.vivero.services;

import java.util.List;
import java.util.Optional;

import com.dawes.manuelmc09.proyecto.vivero.entities.Pedidos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;

/**
 * 
 * @author manuelmc09
 *
 */
public interface ProductosService {

	List<Productos> findByCategoria(String categoria);

	List<Productos> findAll();

	Optional<Productos> findById(Integer id);

	boolean existsById(Integer id);

	void deleteById(Integer id);

	void delete(Productos entity);

	Productos getOne(Integer id);

	Productos getById(Integer id);

	<S extends Productos> S save(S entity);
}
