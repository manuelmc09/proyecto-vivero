package com.dawes.manuelmc09.proyecto.vivero.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;


/**
 * 
 * @author manuelmc09
 *
 */
@Entity
@Table(name = "PEDIDOS")
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Pedidos implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(Usuario.class);

	private static final long serialVersionUID = 10002L;

	@Id
	@Column(name = "IDPEDIDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpedido;
	@Column(name = "FECHA_PEDIDO", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaPedido;
	@Column(name = "PRECIO", precision = 4, scale = 2, columnDefinition = "float default 0.00")
	private float precio;

	@ManyToMany
	@JoinTable(name = "PEDIDOS_PRODUCTOS", joinColumns = { @JoinColumn(name = "IDPRODUCTO") }, inverseJoinColumns = {
			@JoinColumn(name = "IDPEDIDO") })
	private List<Productos> productos = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "IDUSUARIO")
	private Usuario usuario;

	public Pedidos() {
		super();
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
