package com.dawes.manuelmc09.proyecto.vivero.entities;

import java.util.List;

import javax.persistence.*;
import lombok.*;


/**
 * 
 * @author manuelmc09
 *
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "ROLES")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDROL")
	private int idrol;
	@Column(name = "NOMBRE", columnDefinition = "VARCHAR(50)")
	private String nombre;
	@OneToMany(mappedBy = "rol")
	private List<Usuario> usuarios;

	public int getIdrol() {
		return idrol;
	}

	public String getNombre() {
		return nombre;
	}

	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}
	

	public Rol() {
		super();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Rol(int idrol, String nombre, List<Usuario> usuarios) {
		super();
		this.idrol = idrol;
		this.nombre = nombre;
		this.usuarios = usuarios;
	}
	

	
}
