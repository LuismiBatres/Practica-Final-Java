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
		
		Map <String,ArrayList<Compra>> listaClientes=new HashMap<String,ArrayList<Compra>>();
		
		ArrayList<Producto>productos=new ArrayList<Producto>();
		
		e.setProductos(productos);
		
		Cliente c1=new Cliente("Luismi","Sanchez","C/laguna","123456789","1");
		
		Producto limpiador = new Producto("Fairy","jabon para lavar platos",1.15,"Limpieza",150);
		productos.add(limpiador);
		
		Producto lomo = new Producto("Lomo","Lomo en rodajas",1,"Alimentacion",120);
		productos.add(lomo);
		
		Producto colonia = new Producto("Colonia","Colonia",2.15,"Perfumeria",130);
		productos.add(colonia);
		
		Scanner sc=new Scanner(System.in);
	
		int opcion=0;
		
		while(opcion!=3) {
			System.out.println("�Quien eres?: 1.Cliente 2.Empresa 3.Salida");
			opcion=sc.nextInt();
			switch(opcion) {
				case 1: menuCliente(c1,e,listaClientes);
				break;
				case 2:menuEmpresa(e);
				break;
			}
		}
		sc.close();
		
	}

	private static void menuEmpresa(Empresa e) {
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		while(opcion!=6) {
			System.out.println("1.Creacion de productos 2.Incremento de stock 3.Disminucion de stock 4.Listado de productos 5.Listado de compra de cliente 6.Salir");
			opcion=sc.nextInt();
			switch(opcion) {
				case 1: creacionProducto(e);
				break;
				case 2:incremento(e);
				break;
				case 3:disminucion(e);
				break;
				case 4: e.mostrarProductos();
				break;
				case 5: mostrarListaCliente(e);
				break;
			}
		}
		sc.close();
		
	}

	private static void mostrarListaCliente(Empresa e) {
		for (Map.Entry<String, ArrayList<Compra>> entry : e.getCompraCliente().entrySet()) {
		    System.out.println("clave=" + entry.getKey());
		    for(Compra c:entry.getValue()) {
		    	System.out.println(c.toString());
		    }
		}
		
	}

	private static void creacionProducto(Empresa e) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Categoria: Alimentacion Limpieza Perfumeria");
		String categoria=sc.nextLine();
		System.out.println("Nombre del producto:");
		String nombre=sc.nextLine();
		System.out.println("Descripcion del producto:");
		String descripcion=sc.nextLine();
		System.out.println("Precio del producto:");
		double precio=sc.nextDouble();
		System.out.println("Stock del producto");
		int stock=sc.nextInt();
		
		e.crearProducto(nombre, descripcion, precio, categoria, stock);
		sc.close();
	}

	private static void incremento(Empresa e) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el nombre del producto");
		String nombre=sc.nextLine();
		System.out.println("Introduce la cantidad de incremento de stock:"); 
		int stock=sc.nextInt();
			for(Producto p: e.getProductos()) {
				if(p.getNombre().equalsIgnoreCase(nombre)) {
					e.incremento(stock, nombre);
				}
			}
			sc.close();
		}	

	private static void disminucion(Empresa e) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el nombre del producto");
		String nombre=sc.nextLine();
		System.out.println("Introduce la cantidad de disminucion de stock:"); 
		int stock=sc.nextInt();
			for(Producto p: e.getProductos()) {
				if(p.getNombre().equalsIgnoreCase(nombre)) {
					e.disminuir(stock, nombre);
				}
			}
			sc.close();
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

	
	private static void menuCliente(Cliente c,Empresa e,Map <String,ArrayList<Compra>> listaClientes) {
		Scanner sc=new Scanner(System.in);
		Compra compra=new Compra();
		ArrayList<Compra> lista=new ArrayList<>();
		int opcion=0;
		while(opcion!=3) {
			System.out.println("1.Compra de producto 2.Paso por caja 3.Salir");
			opcion=sc.nextInt();
			switch(opcion) {
			case 1: eleccionProductos(c,e,compra,lista);
			break;
			case 2: pasoCaja(c,e,compra,listaClientes,lista);
			break;
			}
		}
		sc.close();
	}

	private static void pasoCaja(Cliente c, Empresa e,Compra compra,Map <String,ArrayList<Compra>> listaClientes,ArrayList<Compra>lista) {
		System.out.println("Precio final: "+compra.getTotal());
		ArrayList<Compra>lista2=new ArrayList<>();
		
		if(listaClientes.containsKey(c.getDni())) {
			lista2=listaClientes.get(c.getDni());
			lista.addAll(lista2);
		}
		
		listaClientes.put(c.getDni(), lista);
		e.setCompraCliente(listaClientes);
	}

	private static void eleccionProductos(Cliente c, Empresa e,Compra compra,ArrayList<Compra>lista) {
		Scanner sc=new Scanner(System.in);
		e.mostrarProductos();
		String fecha="08/11/2018";
		System.out.println("Introduce nombre producto");
		String nombre=sc.nextLine();
		System.out.println("Introduce cantidad del producto");
		int stock=sc.nextInt();
		for(Producto p:e.getProductos()) {
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				if(p.getStock()>stock) {
					compra.setCliente(c);
					compra.setFecha(fecha);
					compra.compraTotal(stock, p);
					e.disminuir(stock, nombre);
					lista.add(compra);
				}else {
					System.out.println("No hay stock");
				}
				
			}
		}
		sc.close();
	}

}
