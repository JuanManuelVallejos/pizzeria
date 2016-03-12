package model;

public class Administrador extends Entity{

	private String nombre;
	private String apellido;
	private Integer dni;
	
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
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
	
	public Administrador(){}
	
	public Administrador(String nombre, String apellido){
		this.setNombre(nombre);
		this.setApellido(apellido);
	}
	
	public void confirmarPedidoACliente(Pedido pedido, Cliente cliente){
		pedido.pedidoEntregadoAlCliente(cliente);
	}
	
}
