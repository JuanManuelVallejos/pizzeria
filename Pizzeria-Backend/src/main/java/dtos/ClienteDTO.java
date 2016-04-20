package dtos;

import java.util.ArrayList;

import model.Pedido;

public class ClienteDTO {

	private int idCliente;
	private String nombre;
	private String apellido;
	private String direccion;
	private Integer dni;
	private Integer telefono;
	private Integer numeroDeCliente;
	private String password;
	private ArrayList<Pedido> pedidos;
	private int iDRol;
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
	public Integer getNumeroDeCliente() {
		return numeroDeCliente;
	}
	public void setNumeroDeCliente(Integer numeroDeCliente) {
		this.numeroDeCliente = numeroDeCliente;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public int getiDRol() {
		return iDRol;
	}
	public void setiDRol(int iDRol) {
		this.iDRol = iDRol;
	}
	
	
}
