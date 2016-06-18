package model;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Usuario extends Entity{

	private static final long serialVersionUID = -6088560814082665700L;

	private String nombre;
	private String apellido;
	private Integer dni;
	private Integer telefono;
	private String direccion;
	private String nombreUsuario;
	private String password;
	private Rol rol;
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
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
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public Usuario(){}

	public Usuario(String nombre, String apellido, String nombreUsuario, Integer dni, Integer telefono, String direccion, String password, Rol rol){
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setNombreUsuario(nombreUsuario);
		this.setDni(dni);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		this.setPassword(password);
		this.setRol(rol);
	}
	
	public boolean esAdmin(){
		return this.getRol().getNombreRol().equals("ADMIN");
	}
	
	public boolean esCliente(){
		return this.getRol().getNombreRol().equals("USER");
	}
	
	
	
}
