package ticomo.app.exception;

public class UsernameNotFound extends Exception {

	private static final long serialVersionUID = 1668398822129870029L;

	public UsernameNotFound() {
		super("Usuario o Id no encontrado");
	}
	
	public UsernameNotFound(String message) {
		super(message);
	}
}
