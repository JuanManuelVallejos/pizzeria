package model;

import java.util.ArrayList;

public class Cliente extends Entity{
	
	private String nombre;
	private String apellido;
	private String direccion;
	private Integer dni;
	private Integer telefono;
	private Integer numeroDeCliente;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
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
	public Integer getNumeroDeCliente() {
		return numeroDeCliente;
	}
	public void setNumeroDeCliente(Integer numeroDeCliente) {
		this.numeroDeCliente = numeroDeCliente;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public Cliente(){}
	
	public Cliente(String nombre, String apellido, String direccion, Integer dni, Integer nroDeCliente){
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDireccion(direccion);
		this.setDni(dni);
		this.setNumeroDeCliente(nroDeCliente);
	}
	
	public void agregarPedidoAlHistorial(Pedido pedido){
		this.getPedidos().add(pedido);
	}
	
	public ArrayList<Pedido> pedidosActivos(){
		
		ArrayList<Pedido> activos = new ArrayList<Pedido>();
		
		for(Pedido each : this.getPedidos()){
			if(!each.isRealizado()){
				activos.add(each);
			}
		}		
		return activos;		
	}
	
	public boolean tienePedidosPendientes(){
		return this.pedidosActivos().size() > 0;
	}
}