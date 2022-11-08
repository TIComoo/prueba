package ticomo.app.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Plato")
public class Plato {

    @Transient
    public static final String SEQUENCE_NAME = "platos_sequence";

    @Id
    private long id;

    @NotBlank(message = "Campo requerido")
    @Pattern(regexp = "[a-zA-Z ]{0,20}", message = "Este campo no debe contener valores numéricos")
    private String nombre;

    @NotBlank(message = "Campo requerido")
    @Pattern(regexp = "[a-zA-Z ]{0,10}", message = "Este campo no debe contener valores numéricos")
    private String nombreRestaurante;

    private String imagen;

    @NotBlank(message = "Campo requerido")
    @Pattern(regexp = "[a-zA-Z ]{0,30}", message = "Este campo no debe contener valores numéricos")
    private String descripcion;

    
    @Digits(integer = 4,fraction = 2,message = "Este campo debe de ser un numero")
    private double precio;

    @NotNull
    private boolean aptoVeganos;

    @NotBlank(message = "Campo requerido")
    @Pattern(regexp = "[a-zA-Z ]{0,8}", message = "Este campo no debe contener valores numéricos")
    private String categoria;

    public Plato(String nombre,String nombreRestaurante,String categoria, String imagen, String descripcion, double precio, boolean aptoVeganos) {
       this.nombreRestaurante=nombreRestaurante;
        this.categoria=categoria;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.aptoVeganos = aptoVeganos;
    }

    public Plato(){
            
    }

    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }
    public String getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean getAptoVeganos() {
        return aptoVeganos;
    }

    public void setId(long id) {
       this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setAptoVeganos(boolean aptoVeganos) {
        this.aptoVeganos = aptoVeganos;
    }


    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    @Override
    public String toString() {
        return "Plato [id=" + id + ", nombre=" + nombre + ", nombreRestaruante=" + nombreRestaurante + ", imagen="
                + imagen + ", descripcion=" + descripcion + ", precio=" + precio + ", aptoVeganos=" + aptoVeganos
                + ", categoria=" + categoria + "]";
    }

    

    

   

    

   
}
