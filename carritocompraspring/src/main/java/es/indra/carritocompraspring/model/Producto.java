/**
 * 
 */

package es.indra.carritocompraspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author aula10
 *
 */

@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue
	private int id;

	private String nombre;

	private String descripcion;

	private double precio;

	@OneToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	private int stock;

	public Producto() {

	}

	public Producto(int id, String nombre, String descripcion, double precio, Categoria categoria, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Productos [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", categoria="
				+ categoria + ", stock=" + stock + "]";
	}

}
