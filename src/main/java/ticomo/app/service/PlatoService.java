package ticomo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticomo.app.SequenceGeneratorServicePlato;
import ticomo.app.dao.PlatoRepository;
import ticomo.app.dao.RestauranteRepository;
import ticomo.app.exception.CustomException;
import ticomo.app.model.Plato;

@Service
public class PlatoService {

	@Autowired
	private PlatoRepository platoRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	public Boolean validarNombreNoRepe(Plato plato) throws CustomException {

		if (platoRepository.findByNombre(plato.getNombre()).isPresent()) {

			throw new CustomException("Nombre no disponible");

		}
		return true;
	}

	public Boolean validarNombreRestaurante(Plato plato) throws CustomException {

		if (!restauranteRepository.findByNombre(plato.getNombreRestaurante()).isPresent()) {

			throw new CustomException("El restaurante no existe");

		}

		return true;
	}

	public Boolean categoriaValida(Plato plato) throws CustomException {

		if (!plato.getCategoria().equalsIgnoreCase("primero") && !plato.getCategoria().equalsIgnoreCase("segundo")
				&& !plato.getCategoria().equalsIgnoreCase("postre")
				&& !plato.getCategoria().equalsIgnoreCase("entrante")) {

			throw new CustomException("La categoria debe de ser: Entrante,primero,segundo o postre");
		}

		return true;
	}

	public void insert(Plato plato) throws CustomException {

		if (validarNombreNoRepe(plato) && categoriaValida(plato) && validarNombreRestaurante(plato)) {
			plato.setId(SequenceGeneratorServicePlato.generateSequence(Plato.SEQUENCE_NAME));
			platoRepository.insert(plato);
		}

	}

	public void update(Plato fromPlato) throws CustomException {

		if (validarNombreNoRepe(fromPlato) && categoriaValida(fromPlato) && validarNombreRestaurante(fromPlato)) {
			Plato toPlato = getPlatorById(fromPlato.getId());
			mapUser(fromPlato, toPlato);

			this.platoRepository.save(toPlato);
		}

	}

	public void delete(Long id) throws CustomException {

		Plato plato = this.getPlatorById(id);
		platoRepository.delete(plato);

	}

	public Plato getPlatorById(Long id) throws CustomException {
		return platoRepository.findById(id).orElseThrow(() -> new CustomException("El Id del plato no existe."));
	}

	protected void mapUser(Plato from, Plato to) {
		to.setNombre(from.getNombre());
		to.setAptoVeganos(from.getAptoVeganos());
		to.setCategoria(from.getCategoria());
		to.setDescripcion(from.getDescripcion());
		to.setImagen(from.getImagen());
		to.setPrecio(from.getPrecio());

	}

	public Iterable<Plato> getAllPlatos() {
		return platoRepository.findAll();
	}
}
