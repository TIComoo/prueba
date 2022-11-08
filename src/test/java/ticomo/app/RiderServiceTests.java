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

import ticomo.app.dao.RiderRepository;
import ticomo.app.model.Rider;
import ticomo.app.service.RiderService;

@RunWith(MockitoJUnitRunner.class)
public class RiderServiceTests {

    String nombre = "John";
    String apellido = "Doe";
    String nif = "12345678k";
    String email = "johndoe@gmail.com";
    String pwd = "1234";
    String matricula = "1";
    String carnet = "1111";
    String tipo_vehiculo = "Motocicleta";

    Rider r = new Rider(email, nombre, apellido, pwd, nif,  tipo_vehiculo, matricula, carnet);

    @Mock
    RiderRepository riderRepository;
    @InjectMocks
    RiderService servicio;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_crearRider() throws Exception {
        Mockito.when(riderRepository.save(r)).thenReturn(r);
        servicio.guardarRider(r);
        assertNotNull(riderRepository.save(r));
    }

    @Test
    public void test_modificarRider() throws Exception { //
        Rider r_nuevo = new Rider(email, nombre, apellido, pwd, nif,  tipo_vehiculo, matricula, carnet);
        r_nuevo.setTipoVehiculo("Bicicleta");
        Mockito.when(riderRepository.save(r_nuevo)).thenReturn(r_nuevo);
        servicio.guardarRider(r_nuevo);
        assertNotNull(r_nuevo.toString(), r.toString());

    }

    @Test
    public void test_leerRiders() {
        List<Rider> riders = servicio.leerRiders();

        assertNotNull(riders);
    }

//    @Test
//    public void test_leerRideresPorEmail() {
//        String email = "johndoe@gmail.com";
//        Mockito.when(riderRepository.findById(email)).thenReturn(Optional.of(r));
//        Rider rider = servicio.leerRiderPorEmail(email);
//        assertEquals(email, rider.getEmail());
//    }
   
}
