package com.dawes.manuelmc09.proyecto.vivero.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;

/**
 * 
 * @author manuelmc09
 *
 */
@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
	public List<Productos> findByCategoria(String categoria);
}
