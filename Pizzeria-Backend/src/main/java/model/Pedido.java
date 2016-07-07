package model;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Pedido extends Entity {
	
	private List<ItemPedido> items = new ArrayList<ItemPedido>();
	private boolean realizado = false;
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido(){}

	public void agregarItemPedido(ItemPedido item){
		this.getItems().add(item);
	}
	
	public List<ItemPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}
	
	public void agregarProductoYCantidad(Producto producto, Integer cantidad){
		ItemPedido nuevoItem = new ItemPedido(producto,cantidad);
		this.agregarItemPedido(nuevoItem);
	}
	
	public Integer totalCompra(){
		Integer total = 0;
		for(ItemPedido each : this.getItems()){
			total = total + each.precioTotalItem();
		}
		return total;
	}
	
	public void pedidoEntregadoAlCliente(Cliente cliente){
		this.setRealizado(true);
	}
	

}
