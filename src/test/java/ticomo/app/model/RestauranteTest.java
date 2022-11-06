package ticomo.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;


import ticomo.app.model.Restaurante;


@SpringBootTest

public class RestauranteTest {
   
    
    String nombre="Domino's ";
    String razon="Pizzerias Ciudad Real";
    String cif="1234567CJS";
    String direccion="C/Alegria";
    String tlf="67676767";
    String categoria="Pizzeria";
    String email="dominos@domino.com";

    Restaurante restauranteAux=new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);


    @Test
    public void test_CrearObjetoRestaurante() {
 
       String nombre="Domino's ";
       String razon="Pizzerias Ciudad Real";
       String cif="1234567CJS";
       String direccion="C/Alegria";
       String tlf="67676767";
       String categoria="Pizzeria";
       String email="dominos@domino.com";
       
       Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
 
       System.out.println(restauranteAux.toString());
       System.out.println(restauranteAux1.toString());
 
    }


    @Test
    public void test_setNombre() {
       Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
       restauranteAux1.setNombre("nombre");
       assertEquals("nombre", restauranteAux1.getNombre());
    }
    
    @Test
    public void test_setRazon() {
       Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
       restauranteAux1.setRazon("razon");
       assertEquals("razon", restauranteAux1.getRazon());
    }



    @Test
    public void test_setDireccion() {
      Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
      restauranteAux1.setDireccion("direccion");
       assertEquals("direccion", restauranteAux1.getDireccion());
    }

    @Test
    public void test_setTlf() {
      Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
      restauranteAux1.setTlf("12345");
       assertEquals("12345", restauranteAux1.getTlf());
    }

    @Test
    public void test_setCategoria() {
      Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
      restauranteAux1.setCategoria("categoria");
       assertEquals("categoria", restauranteAux1.getCategoria());
    }

    @Test
    public void test_setEmail() {
      Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
      restauranteAux1.setEmail("email");
       assertEquals("email", restauranteAux1.getEmail());
    }
}
