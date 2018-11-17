package es.indra.carritocompraspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.indra.carritocompraspring.model.Categoria;
import es.indra.carritocompraspring.model.Producto;

@Service
public interface ProductoService {
	public List<Producto> getAllProducto();

	public Producto getProductoById(int id);

	public Producto saveProducto(Producto producto);

	public Producto actualizarProducto(Producto producto);

	public List<Producto> getAllProductoCategoria(int id);

	public boolean removed(int id);
}
