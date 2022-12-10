package com.dawes.manuelmc09.proyecto.vivero.mapper;

import com.dawes.manuelmc09.proyecto.vivero.entities.Pedidos;
import com.dawes.manuelmc09.proyecto.vivero.dto.PedidosDTO;

/**
 * 
 * @author manuelmc09
 *
 */
public interface PedidosMapper {

	PedidosDTO toPedidosDTO(Pedidos pedido);
}
