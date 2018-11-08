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
	
	private Map<Cliente,ArrayList<Compra>> compraCliente = new HashMap<Cliente,ArrayList<Compra>>();
	
	public Empresa() {
		
	}

	public Empresa(String nombreEmpresa, ArrayList<Producto> productos, Map<Cliente, ArrayList<Compra>> compraCliente) {
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

	public Map<Cliente, ArrayList<Compra>> getCompraCliente() {
		return compraCliente;
	}

	public void setCompraCliente(Map<Cliente, ArrayList<Compra>> compraCliente) {
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
	
}
