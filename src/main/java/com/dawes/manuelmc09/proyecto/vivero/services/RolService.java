package com.dawes.manuelmc09.proyecto.vivero.services;

import java.util.List;
import java.util.Optional;

import com.dawes.manuelmc09.proyecto.vivero.entities.Rol;

/**
 * 
 * @author manuelmc09
 *
 */
public interface RolService {

	List<Rol> findAll();

	Optional<Rol> findById(Integer id);

	boolean existsById(Integer id);

	void deleteById(Integer id);

	void delete(Rol entity);

	Rol getOne(Integer id);

	void deleteAll();

	Rol getById(Integer id);
}
