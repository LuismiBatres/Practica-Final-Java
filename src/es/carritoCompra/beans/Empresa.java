/**
 * 
 */
package es.carritoCompra.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aula10
 *
 */
public class Empresa {
	
	private String nombreEmpresa;
	
	private ArrayList<Producto> productos = new ArrayList<>();
	
	private Map<String,ArrayList<Compra>> compraCliente = new HashMap<String,ArrayList<Compra>>();
	
	public Empresa() {
		
	}

	public Empresa(String nombreEmpresa, ArrayList<Producto> productos, Map<String, ArrayList<Compra>> compraCliente) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.productos = productos;
		this.compraCliente = compraCliente;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public Map<String, ArrayList<Compra>> getCompraCliente() {
		return compraCliente;
	}

	public void setCompraCliente(Map<String, ArrayList<Compra>> compraCliente) {
		this.compraCliente = compraCliente;
	}
	
	public void incremento(int numero, String nombre) {
		
		int suma = 0;
		
		for (Producto p : this.productos) {
			
			if(nombre.equals(p.getNombre())) {
				suma = p.getStock() + numero;
				p.setStock(suma);
			}
		}
		
	}
	
	public void disminuir(int numero, String nombre) {
		int resta = 0;
		
		for (Producto p : this.productos) {
			
			if(nombre.equals(p.getNombre())) {
				resta = p.getStock() - numero;
				p.setStock(resta);
			}
		}
	}
	
	public void crearProducto(String nombre,String descripcion, double precio, String categoria,int stock) {
		this.productos.add(new Producto(nombre,descripcion,precio,categoria,stock));
	}
}
