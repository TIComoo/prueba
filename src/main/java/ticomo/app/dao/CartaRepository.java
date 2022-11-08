package ticomo.app.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ticomo.app.model.Carta;

public interface CartaRepository extends MongoRepository<Carta, Long> {

	Optional<Carta> findBynombreRestaurante(String nombre);

}