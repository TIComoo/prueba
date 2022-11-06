package ticomo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticomo.app.dao.RestauranteRepository;
import ticomo.app.model.Restaurante;


 
@Service
public class RestauranteServiceImpl implements RestauranteService{

	@Autowired
	RestauranteRepository restauranteRepository;
	

	public Restaurante createRestaurante(Restaurante restaurante) {

		
		if (restaurante.getNombre().isEmpty() || restaurante.getRazon().isEmpty() || restaurante.getCIF().isEmpty() || restaurante.getDireccion().isEmpty()|| restaurante.getTlf().isEmpty()|| restaurante.getCategoria().isEmpty()|| restaurante.getEmail().isEmpty())
			throw new IllegalArgumentException("Rellene todos los campos");


		if (this.restauranteRepository.findById(restaurante.getNombre()).isPresent())
			throw new IllegalArgumentException("El restaurante ya existe en el sistema");
		
		if (this.restauranteRepository.findByEmail(restaurante.getEmail()).isPresent()) 
			throw new IllegalArgumentException("El correo introducido ya esta asociado a un restaurante");
	
				
		
		restauranteRepository.save(restaurante);
		return restaurante;	
		
		
		}



	public Restaurante editarRestaurante(Restaurante restaurante) {


		java.util.Optional<Restaurante>  restauranteAux = this.restauranteRepository.findById(restaurante.getNombre());
		java.util.Optional<Restaurante>  emailAux = this.restauranteRepository.findByEmail(restaurante.getEmail());


		if (restaurante.getNombre().isEmpty() || restaurante.getRazon().isEmpty() || restaurante.getCIF().isEmpty() || restaurante.getDireccion().isEmpty()|| restaurante.getTlf().isEmpty()|| restaurante.getCategoria().isEmpty()|| restaurante.getEmail().isEmpty())
		throw new IllegalArgumentException("Rellene todos los campos");

		if (!restauranteAux.isPresent())
			throw new IllegalArgumentException("No hay un restaurante con este nombre en el sistema");	

			
		if (!restaurante.getEmail().contains("@"))
			throw new IllegalArgumentException("Introduzca un correo valido");

		if (emailAux.isPresent() && !(emailAux.get().getEmail().equals(restauranteAux.get().getEmail()))) 
			throw new IllegalArgumentException("El correo introducido ya esta asociado a un restaurante");

	
		this.restauranteRepository.save(restaurante);		
		return restaurante;

	}


	public void eliminarRestaurante(String nombre) {

		java.util.Optional<Restaurante>  restauranteAux = this.restauranteRepository.findById(nombre);

		if (!restauranteAux.isPresent()){
			throw new IllegalArgumentException("No hay un restaurante con este nombre en el sistema");	

		}else{
			this.restauranteRepository.deleteById(nombre);

	}

}

	public Iterable<Restaurante> getAllRestaurantes() {
		return restauranteRepository.findAll();
	}










}