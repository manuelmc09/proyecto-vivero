package com.dawes.manuelmc09.proyecto.vivero.services;

import java.util.List;
import java.util.Optional;

import com.dawes.manuelmc09.proyecto.vivero.entities.Usuario;

/**
 * 
 * @author manuelmc09
 *
 */
public interface UsuarioService {

	Usuario findByUsername(String username);
	
	void save(Usuario usuario);

	List<Usuario> findAll();

	Optional<Usuario> findById(Integer id);

	boolean existsById(Integer id);

	void delete(Usuario entity);

	void deleteById(Integer id);

	Usuario getOne(Integer id);

	void deleteAll();

	Usuario getById(Integer id);
}
