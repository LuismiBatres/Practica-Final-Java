package es.indra.carritocompraspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.indra.carritocompraspring.model.Categoria;

@Service
public interface CategoriaService {
	public List<Categoria> getAllCategoria();

	public Categoria getCategoriaById(int id);

	public Categoria saveCategoria(Categoria categoria);

	public Categoria actualizarCategoria(Categoria categoria);

	public boolean removed(int id);
}
