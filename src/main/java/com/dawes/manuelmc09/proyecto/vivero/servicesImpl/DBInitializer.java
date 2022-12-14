package com.dawes.manuelmc09.proyecto.vivero.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;
import com.dawes.manuelmc09.proyecto.vivero.entities.Rol;
import com.dawes.manuelmc09.proyecto.vivero.entities.Usuario;
import com.dawes.manuelmc09.proyecto.vivero.repositories.ProductosRepository;
import com.dawes.manuelmc09.proyecto.vivero.repositories.RolRepository;
import com.dawes.manuelmc09.proyecto.vivero.repositories.UsuarioRepository;

/**
 * 
 * @author manuelmc09
 *
 */
@Service
public class DBInitializer {

	private static final Logger logger = LoggerFactory.getLogger(DBInitializer.class);
	@Autowired
	private ProductosRepository productosRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RolRepository rolRepository;

	@PostConstruct
	public void initDb() {
		logger.info("Starting database initialization...");
		// Productos
		logger.info("Create Productos objects ....");
		Productos raxao = new Productos(
				"Fruto de tamaño mediano, de forma redonda a troncocónica bastante aplanada, epidermis rayada de color rojo,con tonalidades naranja-marrón sobre fondo verde o amarillo verdoso.Variedad ácida",
				"EN MACETA", "raxao.png", "Raxao", 8.95f, 60);
		Productos regona = new Productos(
				"Fruto de tamaño mediano o pequeño en situaciones de sobrecarga de producción, de forma redondeada aplanada, color verde o amarillo-verdoso. Variedad ácido-amarga.",
				"DE TEMPORADA", "regona.png", "Regona", 8.95f, 100);
		Productos delariega = new Productos(
				"Fruto de tamaño mediano o algo pequeño de forma cónica oblonga a cónica globulosa y epidermis amarilla manchada de marrón anaranjado y estrías rosadas . Variedad semiácida.",
				"DE TEMPORADA", "delariega.png", "De la Riega", 8.95f, 120);
		Productos durona = new Productos(
				"Fruto de tamaño mediano de forma globulosa a algo troncocónica, color amarillo verdoso con manchas naranja o marrón en una superficie habitualmente inferior a su cuarta parte. Variedad ácida.",
				"DE TEMPORADA", "duronadetresali.png", "Durona de Tresali", 8.95f, 120);
		Productos amariega = new Productos(
				"Grupo tecnológico: Amargo\r\n" + "Vigor: Elevado\r\n" + "Sensibilidad a hongos: Baja – muy baja\r\n"
						+ "Floración: Tardía\r\n" + "Maduración: 3ª decena de octubre\r\n"
						+ "Producción: Rápida entrada en producción",
				"DE TEMPORADA", "amariega2.png", "Amariega", 8.95f, 230);
		List<Productos> losProductos = new ArrayList<>();
		productosRepository.save(raxao);
		productosRepository.save(regona);
		productosRepository.save(delariega);
		productosRepository.save(durona);
		productosRepository.save(amariega);

//		for (Productos p : losProductos) {
//			productosRepository.save(p);
//			logger.info("Producto insertado correctamente");
//		}

		// Roles
		logger.info("Create Roles objects ...");
		Rol admin = new Rol("ROLE_ADMIN");
		Rol user = new Rol("ROLE_USER");
		List<Rol> losRoles = new ArrayList<>();
		rolRepository.save(admin);
		rolRepository.save(user);

       
	}
}
