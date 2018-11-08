/**
 * 
 */
package es.carritoCompra.beans;

import java.util.ArrayList;

/**
 * @author aula10
 *
 */
public class Producto {
	
	private String nombre;
	
	private String descripcion;
	
	private double precio;
	
	private String categoria;
	
	private int stock;
	
	
	public Producto () {
		
	}

	

	public Producto(String nombre, String descripcion, double precio, String categoria, int stock) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
		this.stock = stock;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
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
