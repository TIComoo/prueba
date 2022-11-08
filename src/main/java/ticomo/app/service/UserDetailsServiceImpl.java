package ticomo.app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ticomo.app.dao.UsuarioRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		ticomo.app.model.Usuario appUser = repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Login Username Inválido."));

		Set<GrantedAuthority> grantList = new HashSet<>();
		grantList.add(new SimpleGrantedAuthority(appUser.getRol()));

		return new User(email, appUser.getPwd(), grantList);
	}

}
