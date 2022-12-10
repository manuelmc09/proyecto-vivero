package com.dawes.manuelmc09.proyecto.vivero.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dawes.manuelmc09.proyecto.vivero.entities.Usuario;
import com.dawes.manuelmc09.proyecto.vivero.repositories.UsuarioRepository;
import com.dawes.manuelmc09.proyecto.vivero.services.UsuarioService;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 
 * @author manuelmc09
 *
 */
@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario " + username + " no existe en la base de datos");
		}
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (usuario.getRol() != null) {

			GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().getNombre());
			grantList.add(authority);
		}
		UserDetails userDetails = (UserDetails) new User(usuario.getUsername(), usuario.getPassword(), grantList);
		return userDetails;
	}

	@Override
	public Usuario findByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return usuarioRepository.existsById(id);
	}

	@Override
	public void delete(Usuario entity) {
		usuarioRepository.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public Usuario getOne(Integer id) {
		return usuarioRepository.getOne(id);
	}

	@Override
	public void deleteAll() {
		usuarioRepository.deleteAll();
	}

	@Override
	public Usuario getById(Integer id) {
		return usuarioRepository.getById(id);
	}

	@Override
	public void save(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		usuarioRepository.save(usuario);
		
	}



}
