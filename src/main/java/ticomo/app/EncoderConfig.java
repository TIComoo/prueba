package ticomo.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/*********************************************************************
*
* Class Name: EncoderConfig
* Author/s name: Gregorio
* Release/Creation date: 19/10/2022
* Class description: Devuelve un encriptador de contraseñas. Se utiliza en WebSecurityConfig
*
**********************************************************************
*/


@Configuration
public class EncoderConfig {
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }
    
}
