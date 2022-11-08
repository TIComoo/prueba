package ticomo.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ticomo.app.model.Cliente;

/*Debe permitir a los usuarios registrarse en el sistema, solicitar, gestionar y valorar sus 
pedidos de comida. Una vez entregado el pedido se podrá valorar tanto al restaurante 
como al rider. */
@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {

}