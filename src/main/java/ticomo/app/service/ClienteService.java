package ticomo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticomo.app.dao.ClienteRepository;
import ticomo.app.model.Cliente;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	/*
	 * @Autowired private UsuarioRepository userRepository;
	 */

	// CRUD Crear con TDD. Crea o modifica un usuario. Al ser su id el email es
	// inmutable.
	public Cliente guardarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> consultarClientes() {
		List<Cliente> clientes = clienteRepository.findAll();

		return clientes;
	}

	public Cliente leerClientePorEmail(String email) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(email);

		Cliente cliente = clienteOptional.get();

		return cliente;
	}

	public void borrarClientePorEmail(String email) {
		clienteRepository.deleteById(email);
	}

}
