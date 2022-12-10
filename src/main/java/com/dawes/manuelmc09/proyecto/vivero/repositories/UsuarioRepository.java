package com.dawes.manuelmc09.proyecto.vivero.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dawes.manuelmc09.proyecto.vivero.entities.*;

/**
 * 
 * @author manuelmc09
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByUsername(String username);

	/*
	 * Optional<Usuario> findByUser(String user);
	 */
	}
