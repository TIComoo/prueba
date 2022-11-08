package ticomo.app;
/* 

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import g5.app.dao.AdministradorRepository;
import g5.app.model.Administrador;
import g5.app.service.AdministradorService;

@RunWith(MockitoJUnitRunner.class)
public class AdministradorServiceTests {

    String nombre = "John";
    String apellido = "Doe";
    String email = "johndoe@gmail.com";
    String pwd = "1234";
    String zona = "El pilar";

    Administrador a = new Administrador( email,nombre, apellido, pwd, zona);

    @Mock
    AdministradorRepository adminRepository;
    @InjectMocks
    AdministradorService servicio;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_crearAdministrador(){
        Mockito.when(adminRepository.save(a)).thenReturn(a);
       assertNotNull(adminRepository.save(a));
    }

    @Test 
    public void test_modificarAdministrador(){
        Administrador nuevo_a = new Administrador(email,nombre,apellido,pwd,zona);
        nuevo_a.setNombre("Jose");
        Mockito.when(adminRepository.save(nuevo_a)).thenReturn(a);
        servicio.guardarAdministrador(nuevo_a);
        assertNotEquals(nuevo_a.toString(), a.toString());
        ;
    }

    @Test 
    public void test_leerRiders(){
        List<Administrador> administradores = servicio.leerAdministradores();
        
        assertNotNull(administradores);
    }
    @Test
    public void test_leerRidersPorEmail(){
        String email = "johndoe@gmail.com";
        Mockito.when(adminRepository.findById(email)).thenReturn(Optional.of(a));
        Administrador admin = servicio.leerAdminPorEmail(email);
        assertEquals(email, admin.getEmail());
    }

  
}
 */