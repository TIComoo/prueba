

package ticomo.app.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Restaurante")
public class Restaurante {
    @Id
    String nombre;
    String razon;
    String cif;
    String direccion;
    String tlf;
    String categoria;
    String email;

    public Restaurante(String nombre, String razon, String cif, String direccion,String tlf, String categoria, String email) {
        this.nombre = nombre;
        this.razon = razon;
        this.cif = cif;
        this.direccion = direccion;
        this.tlf = tlf;
        this.categoria = categoria;
        this.email = email;
    }

    public Restaurante() {
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRazon() {
        return razon;
    }
    public void setRazon(String razon) {
        this.razon = razon;
    }
    public String getCIF() {
        return cif;
    }
    public void setCIF(String cif) {
        this.cif = cif;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTlf() {
        return tlf;
    }
    
    public void setTlf(String tlf) {
        this.tlf = tlf;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


@Override
public String toString() {
    return nombre + razon + cif + direccion + tlf + categoria + email;
}
    

}