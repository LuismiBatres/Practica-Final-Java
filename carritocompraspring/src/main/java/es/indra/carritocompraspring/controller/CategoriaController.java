package es.indra.carritocompraspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.indra.carritocompraspring.model.Categoria;
import es.indra.carritocompraspring.service.CategoriaService;

@RestController
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@RequestMapping(value = "/categoria", method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> getAllBlog() {
		List<Categoria> todosBlogs = this.categoriaService.getAllCategoria();
		ResponseEntity<List<Categoria>> response = new ResponseEntity<List<Categoria>>(todosBlogs, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/categoria/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> getToDoById(@PathVariable("id") int id) {
		Categoria encontrado = this.categoriaService.getCategoriaById(id);
		if (encontrado == null) {
			return new ResponseEntity<Categoria>(encontrado, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Categoria>(encontrado, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/categoria", method = RequestMethod.POST)
	public ResponseEntity<Void> saveToDo(@RequestBody Categoria blog) {
		Categoria b = this.categoriaService.saveCategoria(blog);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/categoria", method = RequestMethod.PUT)
	public ResponseEntity<Categoria> updateToDo(@RequestBody Categoria blog) {
		Categoria b = this.categoriaService.actualizarCategoria(blog);
		if (b != null) {
			return new ResponseEntity<Categoria>(b, HttpStatus.OK);
		} else {
			return new ResponseEntity<Categoria>(b, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/categoria/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removed(@PathVariable("id") int id) {
		if (!categoriaService.removed(id)) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

	}

}
