package ticomo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/*********************************************************************
 *
 * Class Name: WebSecurityConfig Author/s name: Gregorio Release/Creation date:
 * 19/10/2022 Class description: Se encarga de configurar la seguridad en la web
 * usando la implementación de Spring. Especifica el encargado del login y
 * encriptación de contraseñas
 *
 **********************************************************************
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**" };

	// Encriptador de contraseñas
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserDetailsService userDetailsService;

	/*********************************************************************
	 * Method name: filterChain
	 *
	 * Description of the Method: Especifica una serie de filtros a la web, tales
	 * como quién puede realizar peticiones, la url por defecto, etc
	 *
	 * Calling arguments: HttpSecurity http: Permite configurar la seguridad web
	 *
	 * Return value: SecurityFilterChain: Filtro que se le va a aplicar a las
	 * peticiones entrantes
	 *********************************************************************/

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(resources).permitAll()
				.antMatchers("/", "/index", "/cliente/signup", "/admin/admin-view", "/rider/guardarRider",
						"/restauranteForm", "/crearRestaurante", "/editRestaurante/{nombre}", "/editRestaurante",
						"/editRestaurante/crearRestaurante", "/deleteRestaurante/{nombre}", "/platoForm", "/crearPlato","/editPlato/{id}","/editPlato","/editPlato/crearPlato","/deletePlato/{id}",
						"/admin/borrarAdminPorEmail/{email}", "/rider/borrarRiderPorEmail/{email}", "/cliente/borrarClientePorEmail/{email}")
				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/users").failureUrl("/login?error=true").usernameParameter("username")
				.passwordParameter("password").and().csrf().disable().logout().permitAll()
				.logoutSuccessUrl("/login?logout");

		http.headers().httpStrictTransportSecurity().disable();

		return http.build();
	}

	/*********************************************************************
	 * Method name: configureGlobal
	 *
	 * Description of the Method: Especifica el encargado del login y la
	 * encriptación de contraseñas
	 *
	 * Calling arguments: AuthenticationManagerBuilder auth: Manejador de
	 * autenticaciones
	 *********************************************************************/

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

}

