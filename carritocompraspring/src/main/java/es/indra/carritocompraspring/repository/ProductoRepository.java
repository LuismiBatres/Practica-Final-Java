package es.indra.carritocompraspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.indra.carritocompraspring.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
