package com.dawes.manuelmc09.proyecto.vivero.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.*;

/**
 * 
 * @author manuelmc09
 *
 */
@Data
@Entity
@Table(name = "USUARIOS")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(Usuario.class);

	private static final long serialVersionUID = 10001L;

	@Id
	@Column(name = "IDUSUARIO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuario;
	@Column(name = "NOMBRE", columnDefinition = "VARCHAR(50)")
	private String nombre;
	@Column(name = "EMAIL", columnDefinition = "VARCHAR(100)")
	private String email;
	@Column(name = "USERNAME", columnDefinition = "VARCHAR(50)", unique = true)
	private String username;
	@Column(name = "PASSWORD", columnDefinition = "VARCHAR(150)")
	private String password;
	@ManyToOne
	private Rol rol;
	@OneToMany(mappedBy = "usuario")
	private List<Pedidos> pedidos = new ArrayList<>();

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Rol getRol() {
		return rol;
	}

	public String getNombre() {
		return nombre;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getEmail() {
		return email;
	}
	
	
	

	public List<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Usuario(String nombre, String email, String username, String password, Rol rol) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.username = username;
		this.password = password;
		this.rol = rol;
	}

	public Usuario() {
	}

}
