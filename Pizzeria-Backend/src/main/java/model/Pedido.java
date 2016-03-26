package model;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Pedido extends Entity {
	
	private ArrayList<ItemPedido> items;
	private boolean realizado = false;
	
	public Pedido(){}

	public void agregarItemPedido(ItemPedido item){
		this.getItems().add(item);
	}

	public ArrayList<ItemPedido> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemPedido> items) {
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
		cliente.agregarPedidoAlHistorial(this);
	}
}
