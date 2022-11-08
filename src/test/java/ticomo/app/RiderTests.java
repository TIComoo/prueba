package ticomo.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ticomo.app.model.Rider;

@SpringBootTest
public class RiderTests {
    

    String nombre = "John";
    String apellido = "Doe";
    String nif = "12345678k";
    String email = "johndoe@gmail.com";
    String pwd = "1234";
    String tipo_vehiculo = "Motocicleta";
    String matricula = "1199";
    String carnet = "2222";

    Rider r = new Rider(nombre, apellido, nif, email, pwd, tipo_vehiculo, matricula, carnet);

    @Test
    public void test_Rider(){
        assertNotNull(r);
    }
    @Test
    public void test_setTipo_Vehiculo(){
    r.setTipoVehiculo("Scooter");
    assertEquals("Scooter", r.getTipoVehiculo());
    
    }
    public void test_setMatricula(){
        r.setMatricula("1111");
        assertEquals("1111", r.getMatricula());
        

    }
    @Test
    public void test_setCarnet(){
        r.setCarnet("9999");
        assertEquals("9999", r.getCarnet());
    }

}
