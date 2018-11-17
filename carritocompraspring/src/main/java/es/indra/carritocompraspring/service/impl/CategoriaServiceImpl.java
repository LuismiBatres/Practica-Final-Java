package es.indra.carritocompraspring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.indra.carritocompraspring.model.Categoria;
import es.indra.carritocompraspring.repository.CategoriaRepository;
import es.indra.carritocompraspring.service.CategoriaService;

@Component
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> getAllCategoria() {
		return this.categoriaRepository.findAll();
	}

	@Override
	public Categoria getCategoriaById(int id) {
		Optional<Categoria> blog0 = this.categoriaRepository.findById(id);
		if (blog0.isPresent()) {
			return blog0.get();
		} else {
			return null;
		}
	}

	@Override
	public Categoria saveCategoria(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}

	@Override
	public Categoria actualizarCategoria(Categoria categoria) {
		if (this.getCategoriaById(categoria.getId()) != null) {
			return this.categoriaRepository.save(categoria);
		} else {
			return null;
		}
	}

	@Override
	public boolean removed(int id) {
		Categoria b = this.getCategoriaById(id);
		if (b != null) {
			this.categoriaRepository.delete(b);
			return true;
		}
		return false;
	}

}
