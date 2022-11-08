package ticomo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import ticomo.app.dao.UsuarioRepository;
import ticomo.app.exception.UsernameNotFound;
import ticomo.app.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void guardarUsuario(Usuario usr) {
		usuarioRepository.save(usr);
	}

	public void borrarUsuarioPorEmail(String email) {
		usuarioRepository.deleteById(email);
	}

	public Usuario buscarPorEmail(String email) throws UsernameNotFound {
		return usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFound("El email del usuario no existe."));
	}

	public String getLoggedUserRol() {
		// Obtener el usuario logeado
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		// Verificar que ese objeto traido de sesion es el usuario
		if (principal instanceof UserDetails loggedUser)
			return loggedUser.getAuthorities().iterator().next().toString();

		return null;
	}

}
