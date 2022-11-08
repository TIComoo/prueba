package ticomo.app.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Administrador")
public class Administrador extends Usuario {

   
    private String zona;
  
    // he cambiado el orden de las entradas al constructor para que los atributos de usuario tengan el mismo orden en todas las clases
    public Administrador(String email, String nombre, String apellido, String pwd, String zona) {
        super(email, nombre, apellido, pwd);
        
        this.zona = zona;
       
    }

    public Administrador() {
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    

}
