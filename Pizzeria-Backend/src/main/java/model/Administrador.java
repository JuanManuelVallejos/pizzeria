package model;

public class Administrador {

	private String nombre;
	private String apellido;
	
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
	
	public Administrador(){}
	
	public Administrador(String nombre, String apellido){
		this.setNombre(nombre);
		this.setApellido(apellido);
	}
	
}
