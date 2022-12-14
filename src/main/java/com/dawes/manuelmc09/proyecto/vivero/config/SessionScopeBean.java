package com.dawes.manuelmc09.proyecto.vivero.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import com.dawes.manuelmc09.proyecto.vivero.servicesImpl.SessionCarrito;

/**
 * 
 * @author manuelmc09
 *
 */
@Configuration
public class SessionScopeBean {
	public SessionCarrito sessionCarrito;

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public SessionCarrito SessionScopeBean() {
		return new SessionCarrito();
	}

}
