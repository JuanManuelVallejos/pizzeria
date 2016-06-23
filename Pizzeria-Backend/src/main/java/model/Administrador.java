package model;

@SuppressWarnings("serial")
public class Administrador extends Usuario{

	public Administrador(){}
	
	public Administrador(String nombre, String apellido){
		this.setNombre(nombre);
		this.setApellido(apellido);
	}
	
	public Administrador(String nombre, String apellido, String direccion, Integer dni, String nombreUsuario, String password, Integer nroDeTelefono){
		super(nombre,apellido,direccion,dni,nombreUsuario,password,nroDeTelefono);
	}
	
	public void confirmarPedidoACliente(Pedido pedido, Cliente cliente){
		pedido.pedidoEntregadoAlCliente(cliente);
	}
}
