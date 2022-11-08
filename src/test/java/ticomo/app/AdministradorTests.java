package ticomo.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ticomo.app.model.Administrador;

@SpringBootTest
public class AdministradorTests {
    /*
    * TDD 3 PASOS PRINCIPALES
    * - ESCRIBIR LOS TESTS Y PASARLOS CORRECTAMENTE
    * - IMPLEMENTAR EN SRC
    * - REFACTORIZAR SI ES NECESARIO
    */

    String nombre = "John";
    String apellido = "Doe";
    String email = "johndoe@gmail.com";
    String pwd = "1234";
    String zona = "El Pilar";

    Administrador a = new Administrador(nombre, apellido, email, pwd, zona);

    /*solo ha de  el atrubuto hacerse test del constructor y del atrubuto zona,
     ya que administrador hereda de Usuario sus atributos.*/
    
     @Test
     public void test_Administrador(){
        assertNotNull(a);
     }

     @Test
     public void test_getZona(){
        String zona =a.getZona();
        assertEquals("El Pilar", zona);
     }
     @Test
     public void test_setZona(){
        a.setZona("Pio XII");
        assertEquals("Pio XII", a.getZona());
     }


}
