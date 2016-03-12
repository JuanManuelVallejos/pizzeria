package model;

public class ObjetoCompra extends Entity {

	private String nombre;
	private Integer precio;
	
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ObjetoCompra(){
		
	}
	
	public ObjetoCompra(String nombre, Integer precio){
		this.setNombre(nombre);
		this.setPrecio(precio);
	}
}
