package ticomo.app;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ticomo.app.model.Cliente;

@SpringBootTest
public class ClienteTests {
   /*
    * TDD 3 PASOS PRINCIPALES
    * - ESCRIBIR LOS TESTS Y PASARLOS CORRECTAMENTE
    * - IMPLEMENTAR EN SRC
    * - REFACTORIZAR SI ES NECESARIO
    */
   String nombre = "John";
   String apellido = "Doe";
   String nif = "12345678k";
   String direccion = "Calle Falsa 123";
   String telefono = "12345678";
   String email = "johndoe@gmail.com";
   String pwd = "1234";

   Cliente u = new Cliente(email, nombre, apellido,   pwd, nif, direccion, telefono);


   @Test
   public void test_CrearObjetoUsuario() {
      // constructor vacio
      Cliente cliente = new Cliente();

      // constructor con atributos
      String nombre = "John";
      String apellido = "Doe";
      String nif = "12345678k";
      String direccion = "Calle Falsa 123";
      String telefono = "12345678";
      String email = "johndoe@gmail.com";
      String pwd = "1234";

      Cliente cliente2 = new Cliente(email, nombre, apellido,   pwd, nif, direccion, telefono);

      System.out.println(cliente.toString());
      System.out.println(cliente2.toString());

   }

   @Test
   public void test_getNombre() {
      String nombre = u.getNombre();
      System.out.println(nombre);
   }

   @Test
   public void test_setNombre() {
      Cliente cliente =new Cliente(email, nombre, apellido,   pwd, nif, direccion, telefono);

      cliente.setNombre("Jose");
   }

   @Test
   public void test_getApellido() {
      String apellido = u.getApellido();
      assertEquals(apellido, "Doe");

   }

   @Test
   public void test_setApellido() {
      u.setApellido("Rambo");
      System.out.println();
   }

   @Test
   public void test_getNif() {
      String nif = u.getNif();
      assertEquals(nif, "12345678k");

   }

   @Test
   public void test_setNif() {
      Cliente usuario = new Cliente(email, nombre, apellido,   pwd, nif, direccion, telefono);

      usuario.setNif("12234567");
      assertEquals("12234567", usuario.getNif());

   }

   @Test
   public void test_getDireccion() {
      String d = u.getDireccion();
      assertEquals(d, "Calle Falsa 123");
   }

   @Test
   public void test_setDireccion() {
      Cliente usuario = new Cliente(email, nombre, apellido,   pwd, nif, direccion, telefono);

      assertNotEquals(usuario.getDireccion(), "Calle Falsa 321");

   }

   @Test
   public void test_getTelefono() {
      String telefono = u.getTelefono();
      assertEquals(telefono, "12345678");
   }

   @Test
   public void test_setTelefono() {
      Cliente usuario = new Cliente(email, nombre, apellido,   pwd, nif, direccion, telefono);

      usuario.setTelefono("87654321");
      assertEquals("87654321", usuario.getTelefono());
   }

   @Test
   public void test_getEmail() {
      String e = u.getEmail();
      assertEquals("johndoe@gmail.com", e);
   }

   @Test
   public void test_setEmail() {
      Cliente usuario = new Cliente(email, nombre, apellido,   pwd, nif, direccion, telefono);

      usuario.setEmail("johndoe24@gmail.com");
      assertEquals("johndoe24@gmail.com", usuario.getEmail());

   }

   @Test
   public void test_getPwd() {
      String p = u.getPwd();
      assertEquals("1234", p);

   }

   @Test
   public void test_setPwd() {
      Cliente usuario =new Cliente(email, nombre, apellido,   pwd, nif, direccion, telefono);

      usuario.setPwd("4321");
      assertEquals("4321", usuario.getPwd());
   }
}
