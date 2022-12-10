package com.dawes.manuelmc09.proyecto.vivero.mapperImpl;

import com.dawes.manuelmc09.proyecto.vivero.dto.PedidosDTO;
import com.dawes.manuelmc09.proyecto.vivero.dto.ProductosDTO;
import com.dawes.manuelmc09.proyecto.vivero.entities.Pedidos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;
import com.dawes.manuelmc09.proyecto.vivero.mapper.ProductosMapper;

/**
 * 
 * @author manuelmc09
 *
 */
public class ProductosMapperImpl implements ProductosMapper {

	@Override
	public ProductosDTO toProductosDTO(Productos producto) {
		if (producto != null) {
			ProductosDTO productosDTO = new ProductosDTO();
			
			return productosDTO;
		}
		return null;
	}

}
