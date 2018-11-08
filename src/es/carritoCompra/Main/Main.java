package es.carritoCompra.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import es.carritoCompra.beans.Cliente;
import es.carritoCompra.beans.Compra;
import es.carritoCompra.beans.Empresa;
import es.carritoCompra.beans.Producto;

public class Main {

	public static void main(String[] args) {
		Empresa e=new Empresa();
		
		e.setNombreEmpresa("Mercadona");
		
		Map <Cliente,ArrayList<Compra>> listaClientes=new HashMap<Cliente,ArrayList<Compra>>();
		
		Cliente c1=new Cliente("Luismi","Sanchez","C/laguna","123456789","1");
		
		Producto limpiador = new Producto("Fairy","jabon para lavar platos",1.15,"Limpieza",150);
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("¿Quien eres?: 1.Cliente 2.Empresa 3.Salida");
		
		switch(sc.nextInt()) {
			case 1: menuCliente(c1,e,listaClientes);
			break;
			case 2:menuEmpresa(e,listaClientes);
			break;
			case 3: 
			break;
		}
	}

	private static void menuEmpresa(Empresa e,Map <Cliente,ArrayList<Compra>> listaClientes) {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Creacion de productos 2.Incremento de stock 3.Disminucion de stock");
		switch(sc.nextInt()) {
			case 1: creacionProducto(e);
			break;
			case 2:System.out.println("Introduce el nombre del producto");
				String nombre=sc.nextLine();
				System.out.println("Introduce la cantidad de incremento de stock:"); 
				String stock=sc.nextLine();
				if(isNumeric(stock) && stock.isEmpty() && stock!=null) {
					incremento(Integer.parseInt(stock),e,nombre);
				}
			break;
			case 3:System.out.println("Introduce el nombre del producto");
			String nombre1=sc.nextLine();
			System.out.println("Introduce la cantidad de disminucion de stock:"); 
			String stock1=sc.nextLine();
			if(isNumeric(stock1) && stock1.isEmpty() && stock1 !=null) {
				disminucion(Integer.parseInt(stock1),e,nombre1);
			}
			break;
		}
		
		
	}

	private static void incremento(int stock, Empresa e, String nombre) {
		for(Producto p: e.getProductos()) {
			if(p.getNombre().equals(nombre)) {
				e.incremento(stock, nombre);
			}
		}
		
	}

	private static void disminucion(int stock,Empresa e,String nombre) {
		for(Producto p: e.getProductos()) {
			if(p.getNombre().equals(nombre)) {
				e.disminuir(stock, nombre);
			}
		}
	}
	
	

	public static boolean isNumeric(String cadena) {

        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

	
	private static void menuCliente(Cliente c,Empresa e,Map <Cliente,ArrayList<Compra>> listaClientes) {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Compra de producto 2.Paso por caja");
		Compra compra=new Compra();
		switch(sc.nextInt()) {
			case 1: eleccionProductos(c,e,compra);
			break;
			case 2: pasoCaja(c,e,compra,listaClientes);
			break;
		}
		
	}

	private static void pasoCaja(Cliente c, Empresa e,Compra compra,Map <Cliente,ArrayList<Compra>> listaClientes) {
		System.out.println("Precio final: "+compra.getTotal());
		ArrayList<Compra> lista=new ArrayList<>();
		lista.add(compra);
		
		listaClientes.put(c, lista);
		e.setCompraCliente(listaClientes);
	}

	private static void eleccionProductos(Cliente c, Empresa e,Compra compra) {
		Scanner sc=new Scanner(System.in);
		mostrarProductos(e);
		String fecha="08/11/2018";
		System.out.println("Introduce nombre producto");
		String nombre=sc.nextLine();
		System.out.println("Introduce cantidad del producto");
		int stock=sc.nextInt();
		for(Producto p:e.getProductos()) {
			if(p.getNombre().equals(nombre)) {
				if(p.getStock()>stock) {
					compra.setCliente(c);
					compra.setFecha(fecha);
					compra.compraTotal(stock, p);
				}else {
					System.out.println("No hay stock");
				}
				
			}
		}
	}

	private static void mostrarProductos(Empresa e) {
		for(Producto p:e.getProductos()) {
			System.out.println(p.toString());
		}
	}
}
