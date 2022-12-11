package com.dawes.manuelmc09.proyecto.vivero.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.manuelmc09.proyecto.vivero.entities.Pedidos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Usuario;

/**
 * 
 * @author manuelmc09
 *
 */
@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {

	List<Productos> findByCategoria(String categoria);

	List<Productos> findByPropietario(Usuario propietario);

	List<Productos> findByPedido(Pedidos pedido);

	List<Productos> findByPedidoIsNull();

	List<Productos> findByNombreContainsIgnoreCaseAndPropietario(String nombre, Usuario propietario);
}
