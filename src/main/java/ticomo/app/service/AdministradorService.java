package ticomo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticomo.app.dao.AdministradorRepository;
import ticomo.app.dao.UsuarioRepository;
import ticomo.app.model.Administrador;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository adminRepository;

	@Autowired
	private UsuarioRepository userRepository;

	// CRUD Crear y Modificar. Testeado con TDD que Modificar funciona
	// correctamente.

	public void guardarAdministrador(Administrador a) {
		adminRepository.save(a);
	}

	public List<Administrador> leerAdministradores() {
		// <Administrador> administradores = adminRepository.findAll();
		List<Administrador> administradores = adminRepository.findAll();
		return administradores;

	}

	public Administrador leerAdminPorEmail(String email) {
		Optional<Administrador> adminOptional = adminRepository.findById(email);

		Administrador admin = adminOptional.get();

		return admin;

	}

	public void borrarAdminPorEmail(String email) {
		adminRepository.deleteById(email);
		userRepository.deleteById(email);
	}

}
