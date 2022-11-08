package ticomo.app.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ticomo.app.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	Optional<Usuario> findByEmail(String email);

}