package model;

@SuppressWarnings("serial")
public class Usuario extends Entity{
	
	private String nombre;
	private String apellido;
	private String direccion;
	private Integer dni;
	private Integer telefono;
	private String nombreUsuario;
	private String password;

	public Usuario(){

	}
	
	public Usuario(String nombre, String apellido, String direccion, Integer dni, String nombreUsuario, String password, Integer nroDeTelefono){
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDireccion(direccion);
		this.setDni(dni);
		this.setNombreUsuario(nombreUsuario);
		this.setPassword(password);
		this.setTelefono(nroDeTelefono);
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
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
		
	public void agregarPedidoAlHistorial(Pedido pedido){
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}