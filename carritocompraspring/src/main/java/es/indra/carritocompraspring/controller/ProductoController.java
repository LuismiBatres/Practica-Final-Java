package es.indra.carritocompraspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.indra.carritocompraspring.model.Producto;
import es.indra.carritocompraspring.service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	ProductoService productoService;

	@RequestMapping(value = "/producto", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> getAllBlog() {
		List<Producto> todosBlogs = this.productoService.getAllProducto();
		ResponseEntity<List<Producto>> response = new ResponseEntity<List<Producto>>(todosBlogs, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/producto/{id}", method = RequestMethod.GET)
	public ResponseEntity<Producto> getToDoById(@PathVariable("id") int id) {
		Producto encontrado = this.productoService.getProductoById(id);
		if (encontrado == null) {
			return new ResponseEntity<Producto>(encontrado, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Producto>(encontrado, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/producto", method = RequestMethod.POST)
	public ResponseEntity<Void> saveToDo(@RequestBody Producto blog) {
		Producto b = this.productoService.saveProducto(blog);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/producto", method = RequestMethod.PUT)
	public ResponseEntity<Producto> updateToDo(@RequestBody Producto blog) {
		Producto b = this.productoService.actualizarProducto(blog);
		if (b != null) {
			return new ResponseEntity<Producto>(b, HttpStatus.OK);
		} else {
			return new ResponseEntity<Producto>(b, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/producto/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removed(@PathVariable("id") int id) {
		if (!productoService.removed(id)) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

	}

	@RequestMapping(value = "/producto/categoria/{id}", method = RequestMethod.GET)
	public ResponseEntity <List<Producto>> getTodoByCategory(@PathVariable("id") int id) {
		List<Producto>encontrado = this.productoService.getAllProductoCategoria(id);
		if (encontrado == null) {
			return new ResponseEntity<List<Producto>>(encontrado, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Producto>>(encontrado, HttpStatus.OK);
		}

	}
}
