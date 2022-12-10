package com.dawes.manuelmc09.proyecto.vivero.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.manuelmc09.proyecto.vivero.entities.Rol;
import com.dawes.manuelmc09.proyecto.vivero.repositories.RolRepository;
import com.dawes.manuelmc09.proyecto.vivero.services.RolService;

/**
 * 
 * @author manuelmc09
 *
 */
@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository;

	@Override
	public List<Rol> findAll() {
		return rolRepository.findAll();
	}

	@Override
	public Optional<Rol> findById(Integer id) {
		return rolRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return rolRepository.existsById(id);
	}

	@Override
	public void deleteById(Integer id) {
		rolRepository.deleteById(id);

	}

	@Override
	public void delete(Rol entity) {
		rolRepository.delete(entity);

	}

	@Override
	public Rol getOne(Integer id) {
		return rolRepository.getOne(id);
	}

	@Override
	public void deleteAll() {
		rolRepository.deleteAll();

	}

	@Override
	public Rol getById(Integer id) {
		return rolRepository.getById(id);
	}

}
