package com.dawes.manuelmc09.proyecto.vivero.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.manuelmc09.proyecto.vivero.entities.Productos;
import com.dawes.manuelmc09.proyecto.vivero.repositories.ProductosRepository;
import com.dawes.manuelmc09.proyecto.vivero.services.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService {
	
	@Autowired
	private ProductosRepository productosRepository;

	@Override
	public List<Productos> findByCategoria(String categoria) {
		return productosRepository.findByCategoria(categoria);
	}

	@Override
	public List<Productos> findAll() {
		return productosRepository.findAll();
	}

	@Override
	public Optional<Productos> findById(Integer id) {
		return productosRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return productosRepository.existsById(id);
	}

	@Override
	public void deleteById(Integer id) {
		productosRepository.deleteById(id);

	}

	@Override
	public void delete(Productos entity) {
		productosRepository.delete(entity);
	}

	@Override
	public Productos getOne(Integer id) {
		return productosRepository.getOne(id);
	}

	@Override
	public Productos getById(Integer id) {
		return productosRepository.getById(id);
	}

	@Override
	public <S extends Productos> S save(S entity) {
		return productosRepository.save(entity);
	}

}
