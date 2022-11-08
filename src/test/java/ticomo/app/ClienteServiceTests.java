package ticomo.app;

import static org.junit.Assert.assertEquals;
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

import ticomo.app.dao.ClienteRepository;
import ticomo.app.model.Cliente;
import ticomo.app.service.ClienteService;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTests {
    
    
    String nombre = "John";
    String apellido = "Doe";
    String nif = "12345678k";
    String direccion = "Calle Falsa 123";
    String telefono = "12345678";
    String email = "johndoe@gmail.com";
    String pwd = "1234";

    Cliente u = new Cliente(email, nombre, apellido, nif, direccion, telefono, pwd);

    @Mock
    ClienteRepository usuarioRepository;

    @InjectMocks
    ClienteService servicio;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_crearUsuario() {
       
        Cliente u = new Cliente(email, nombre, apellido, nif, direccion, telefono, pwd); 
        Mockito.when(usuarioRepository.save(u)).thenReturn(u);
        Cliente u_resultado = servicio.guardarCliente(u);
        assertEquals(u, u_resultado);

    }

    @Test 
    public void test_leerClientes(){
        List<Cliente> clientes = servicio.consultarClientes();

        
        assertNotNull(clientes);
    }
    @Test
    public void test_leerClientePorEmail(){
        String email = "johndoe@gmail.com";
        Mockito.when(usuarioRepository.findById(email)).thenReturn(Optional.of(u));
        Cliente cliente = servicio.leerClientePorEmail(email);
        assertEquals(email, cliente.getEmail());
    }
  

}
