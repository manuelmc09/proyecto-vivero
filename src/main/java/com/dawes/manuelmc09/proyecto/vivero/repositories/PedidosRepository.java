package com.dawes.manuelmc09.proyecto.vivero.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dawes.manuelmc09.proyecto.vivero.entities.Pedidos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Usuario;

/**
 * 
 * @author manuelmc09
 *
 */
@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {

	@Query(value = "SELECT p FROM Pedidos p WHERE p.propietario.id=?1")
	List<Pedidos> findIdUser(Integer id);

	List<Pedidos> findByPropietario(Usuario propietario);
}
