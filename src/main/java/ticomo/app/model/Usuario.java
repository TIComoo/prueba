package ticomo.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuario")
public class Usuario {

    @Id
    protected String email;
    protected String nombre;
    protected String apellido;
    protected String pwd;
    private String rol;

    //sin rol
    public Usuario(String email, String nombre, String apellido, String pwd) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pwd = pwd;
    }
    
    //vacio
    public Usuario() {
    }
    
    //con rol
    public Usuario(String email, String nombre, String apellido, String pwd, String rol) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pwd = pwd;
        this.rol = rol;
    }
    
    //constructor con email y pwd 
    public Usuario(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;

    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Usuario [email=" + email + ", nombre=" + nombre + ", apellido=" + apellido + ", pwd=" + pwd + "]";
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
