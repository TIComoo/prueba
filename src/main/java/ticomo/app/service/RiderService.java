package ticomo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ticomo.app.dao.RiderRepository;
import ticomo.app.model.Rider;

@Service
public class RiderService {

	@Autowired
	RiderRepository riderRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public void guardarRider(Rider rider) throws Exception {
		/*
		 * if (emailValido(rider)) { String encodedPassword =
		 * bCryptPasswordEncoder.encode(rider.getPwd()); rider.setPwd(encodedPassword);
		 */
		riderRepository.save(rider);

	}
	/*
	 * private boolean emailValido(Rider rider) throws Exception { Rider encontrado
	 * = leerRiderPorEmail(rider.getEmail()); if (encontrado != null) { throw new
	 * Exception(); } return true; }
	 */

	public List<Rider> leerRiders() {
		List<Rider> administradores = riderRepository.findAll();

		return administradores;
	}

	public Rider leerRiderPorEmail(String email) {
		Rider rider = riderRepository.findByEmail(email);

		return rider;

	}

	public void borrarRiderPorEmail(String email) {
		riderRepository.deleteById(email);
	}

}