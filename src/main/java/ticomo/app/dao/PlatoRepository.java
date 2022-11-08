package ticomo.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ticomo.app.model.Plato;

public interface PlatoRepository extends MongoRepository<Plato, Long> {

	Optional<Plato> findByNombre(String nombre);

	List<Plato> findByNombreRestaurante(String nombre);

}