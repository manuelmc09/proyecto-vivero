package com.dawes.manuelmc09.proyecto.vivero.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.dawes.manuelmc09.proyecto.vivero.servicesImpl.UsuarioServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoderBcript = new BCryptPasswordEncoder();
		return encoderBcript;

	}
	@Bean 
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		List<UserDetails> userDetailsList=new ArrayList<>();
		userDetailsList.add(User.withUsername("administrador").password(passwordEncoder().encode("administrador"))
				.roles("ADMIN","USER").build());
		return new InMemoryUserDetailsManager(userDetailsList);
	}

	public static String toEncrypt(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

	/**
	 * Metodo para la autenticación
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(usuarioServiceImpl);
		auth.userDetailsService(inMemoryUserDetailsManager());

	}

	/**
	 * Metodo para  la autorizacion
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.authorizeRequests().antMatchers("/", "/login").permitAll()
		.and()
		.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
		.and()
		.authorizeRequests()
				.antMatchers("/user/**")
				.hasAnyRole("USER", "ADMIN");

		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		http.authorizeRequests().and().formLogin()
		.loginPage("/login")
		.failureUrl("/login?error=true");

	}

}
