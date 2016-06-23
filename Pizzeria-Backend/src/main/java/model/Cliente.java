package model;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Cliente extends Usuario{
	
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Cliente(){}
	
	public Cliente(String nombre, String apellido, String direccion, Integer dni, String nombreUsuario, String password, Integer nroDeTelefono){
		super(nombre,apellido,direccion,dni,nombreUsuario,password,nroDeTelefono);
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
		
	public void agregarPedidoAlHistorial(Pedido pedido){
		this.getPedidos().add(pedido);
	}
}