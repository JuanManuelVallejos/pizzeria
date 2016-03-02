package model;

public class Producto {
	
	private String nombre;
	private Integer precio;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Producto(String nombre, Integer precio){
		this.setNombre(nombre);
		this.setPrecio(precio);
	}
}
