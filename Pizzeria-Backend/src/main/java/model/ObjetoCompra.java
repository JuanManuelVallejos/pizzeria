package model;

@SuppressWarnings("serial")
public class ObjetoCompra extends Entity {

	private String nombre;
	private Integer precio;
	private byte[] imagen;
	
	public ObjetoCompra(){
		
	}
	
	public ObjetoCompra(String nombre, Integer precio, byte[] imagen){
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setImagen(imagen);
	}
	
	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
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
}
