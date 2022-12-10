package com.dawes.manuelmc09.proyecto.vivero.mapper;

import com.dawes.manuelmc09.proyecto.vivero.dto.ProductosDTO;
import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;

/**
 * 
 * @author manuelmc09
 *
 */
public interface ProductosMapper {

	ProductosDTO toProductosDTO(Productos productos);
}
