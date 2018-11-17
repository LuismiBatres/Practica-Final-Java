package es.indra.carritocompraspring.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.indra.carritocompraspring.model.Categoria;
import es.indra.carritocompraspring.model.Producto;
import es.indra.carritocompraspring.repository.CategoriaRepository;
import es.indra.carritocompraspring.repository.ProductoRepository;
import es.indra.carritocompraspring.service.ProductoService;

@Component
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;
	CategoriaServiceImpl categoriaServiceImpl;

	@Override
	public List<Producto> getAllProducto() {
		return this.productoRepository.findAll();

	}

	@Override
	public Producto getProductoById(int id) {
		Optional<Producto> blog0 = this.productoRepository.findById(id);
		if (blog0.isPresent()) {
			return blog0.get();
		} else {
			return null;
		}
	}

	@Override
	public Producto saveProducto(Producto producto) {
		return this.productoRepository.save(producto);
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		if (this.getProductoById(producto.getId()) != null) {
			return this.productoRepository.save(producto);
		} else {
			return null;
		}
	}

	@Override
	public boolean removed(int id) {
		Producto b = this.getProductoById(id);
		if (b != null) {
			this.productoRepository.delete(b);
			return true;
		}
		return false;
	}

	@Override
	public List<Producto> getAllProductoCategoria(int id) {
		Categoria blog0 = this.categoriaServiceImpl.getCategoriaById(id);
		List<Producto>lista=new ArrayList<Producto>();
		if (blog0!=null) {
			List<Producto> blog = this.getAllProducto();
			for(Producto p:blog) {
				if(p.getCategoria().getId()==blog0.getId()) {
					lista.add(p);
				}
			}
			return lista;
		} else {
			return null;
		}
		
	}

}
