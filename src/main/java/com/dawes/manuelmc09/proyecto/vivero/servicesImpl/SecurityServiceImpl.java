package com.dawes.manuelmc09.proyecto.vivero.servicesImpl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dawes.manuelmc09.proyecto.vivero.services.SecurityService;

/**
 * 
 * @author manuelmc09
 *
 */
@Service
public class SecurityServiceImpl implements SecurityService {

	@Override
	public String toEncrypt(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

}
