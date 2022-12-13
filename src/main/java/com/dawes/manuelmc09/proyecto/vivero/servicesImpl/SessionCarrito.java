package com.dawes.manuelmc09.proyecto.vivero.servicesImpl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;
import com.dawes.manuelmc09.proyecto.vivero.repositories.ProductosRepository;

/**
 * 
 * @author manuelmc09
 *
 */
/**
 * Spring crea un proxy para un ben con ámbito de sesión y hace que el procy
 * esté disponible para los servicios que inyectan este bean. Una ventaja de
 * usar este enfoque es que Spring maneja cualquier cambio de estado en este
 * bean, se encargaría de recuperar este bean de la sesión y propagar cualquier
 * cambio en el bean de vuelta a la sesión.
 * 
 * Además, si el bean tuviera algún método de ciclo de vida Spring (por ejemplo,
 * métodos anotados @PostConstruct o @PreDestroy), se llamarían apropiadamente.
 */
@Service
public class SessionCarrito implements Serializable {
	
	@Autowired
	private ProductosRepository productosRepository;

	private static final Logger logger = LoggerFactory.getLogger(SessionCarrito.class);

	private static final long serialVersionUID = 10006L;

	private Map<Productos, Integer> carrito = new HashMap<>();

	public Map<Productos, Integer> getCarrito() {
		return carrito;
	}
	
	public void addCarrito(int idproducto) {
		Optional<Productos> producto=productosRepository.findById(idproducto);
		if(producto.isPresent()) {
			if(carrito.containsKey(producto.get())) {
				carrito.replace(producto.get(), carrito.get(producto.get())+1);
			}else {
				carrito.put(producto.get(), 1);
			}
		}
		
	}
	
	public Float precioTotal() {
		float precio=0;
		for(Entry<Productos, Integer> producto : carrito.entrySet()) {
			precio += producto.getKey().getPrecio()*producto.getValue();
		}
		return precio;
	}

}
