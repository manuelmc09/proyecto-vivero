package com.dawes.manuelmc09.proyecto.vivero.mapperImpl;

import com.dawes.manuelmc09.proyecto.vivero.dto.PedidosDTO;
import com.dawes.manuelmc09.proyecto.vivero.entities.Pedidos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;
import com.dawes.manuelmc09.proyecto.vivero.mapper.PedidosMapper;

/**
 * 
 * @author manuelmc09
 *
 */
public class PedidosMapperImpl implements PedidosMapper {

	@Override
	public PedidosDTO toPedidosDTO(Pedidos pedido) {
		if (pedido != null) {
			PedidosDTO pedidosdto = new PedidosDTO();
			pedidosdto.setIdpedido(pedido.getIdpedido());
			pedidosdto.setFechaPedido(pedido.getFechaPedido());
			pedidosdto.setPrecio(pedido.getPrecio());
			pedidosdto.setUsuario(pedido.getPropietario());

			return pedidosdto;
		}
		return null;
	}

}
