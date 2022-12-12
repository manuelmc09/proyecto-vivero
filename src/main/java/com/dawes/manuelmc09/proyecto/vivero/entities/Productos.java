package com.dawes.manuelmc09.proyecto.vivero.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author manuelmc09
 *
 */
@Entity
@Table(name = "PRODUCTOS")
@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Productos implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(Usuario.class);

	private static final long serialVersionUID = 10003L;

	@Id
	@Column(name = "IDPRODUCTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproducto;
	@Column(name = "NOMBRE", columnDefinition = "VARCHAR(50)")
	private String nombre;
	@Column(name = "CARACTERISTICAS", columnDefinition = "VARCHAR(255)")
	private String caracteristicas;
	@Column(name = "CATEGORIA", columnDefinition = "VARCHAR(255)")
	private String categoria;
	@Column(name = "IMAGEN")
	private String imagen;
	@Column(name = "STOCK", columnDefinition = "Integer default 0")
	private int stock;
	@Column(name = "PRECIO", precision = 4, scale = 2, columnDefinition = "float default 0.00")
	private float precio;
//
//	@ManyToMany
//	@JoinTable(name = "PEDIDOS_PRODUCTOS", joinColumns = { @JoinColumn(name = "IDPEDIDO") }, inverseJoinColumns = {
//			@JoinColumn(name = "IDPRODUCTO") })
//	private List<Pedidos> pedidos = new ArrayList<>();

	@ManyToOne
	private Usuario propietario;

	@ManyToOne
	private Pedidos pedido;

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

//	public List<Pedidos> getPedidos() {
//		return pedidos;
//	}
//
//	public void setPedidos(List<Pedidos> pedidos) {
//		this.pedidos = pedidos;
//	}

	public Productos() {
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	public Pedidos getPedido() {
		return pedido;
	}

	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}

	public Productos(String nombre, String imagen, float precio, Usuario propietario) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.precio = precio;
		this.propietario = propietario;
	}

	public Productos(String caracteristicas, String categoria, String imagen, String nombre, float precio, int stock) {
		super();
		this.caracteristicas = caracteristicas;
		this.categoria = categoria;
		this.imagen = imagen;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public Productos(int idproducto, String nombre, String caracteristicas, String categoria, String imagen, int stock,
			float precio, Usuario propietario, Pedidos pedido) {
		super();
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.caracteristicas = caracteristicas;
		this.categoria = categoria;
		this.imagen = imagen;
		this.stock = stock;
		this.precio = precio;
		this.propietario = propietario;
		this.pedido = pedido;
	}
	

}
