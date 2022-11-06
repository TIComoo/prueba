package ticomo.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import ticomo.app.model.Restaurante;

import java.util.*;
public interface RestauranteRepository extends MongoRepository<Restaurante,String>{

	Optional<Restaurante> findByEmail(String email);

	Optional<Restaurante> findByNombre(String nombre);

}

