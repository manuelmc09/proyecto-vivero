package com.dawes.manuelmc09.proyecto.vivero.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author manuelmc09
 *
 */
@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode
@Data
public class ProductosDTO {

	private String nombre;
	private String imagen;
	private float precio;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ProductosDTO() {
		super();
	}

	public ProductosDTO(String nombre, String imagen, float precio) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.precio = precio;
	}

}
