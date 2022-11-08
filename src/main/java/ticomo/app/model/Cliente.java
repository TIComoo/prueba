package ticomo.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cliente")
public class Cliente extends Usuario {

	private String nif;
	private String direccion;
	private String telefono;
	private String confirmarPwd;

	public Cliente(String email, String nombre, String apellido, String pwd, String nif, String direccion,
			String telefono) {
		super(email, nombre, apellido, pwd);

		this.nif = nif;
		this.direccion = direccion;
		this.telefono = telefono;

	}
	
    public String getConfirmarPwd() {
		return confirmarPwd;
	}
	public void setConfirmarPwd(String confirmarPwd) {
		this.confirmarPwd = confirmarPwd;
	}

	public Cliente(String email, String nombre, String apellido, String pwd, String confirmarPwd, String nif,
			String direccion,
			String telefono) {
		super(email, nombre, apellido, pwd);

		this.nif = nif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.confirmarPwd = confirmarPwd;

	}

	public Cliente() {
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
