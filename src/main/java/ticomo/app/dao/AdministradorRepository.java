package ticomo.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import ticomo.app.model.Administrador;

public interface AdministradorRepository extends MongoRepository<Administrador, String> {

}
