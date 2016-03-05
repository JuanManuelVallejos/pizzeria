package model;

import java.util.ArrayList;

public class Pedido extends Entity {
	
	private ArrayList<ItemPedido> items = new ArrayList<ItemPedido>();

	public ArrayList<ItemPedido> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemPedido> items) {
		this.items = items;
	}
	
	public Pedido(){}

	public void agregarItemPedido(ItemPedido item){
		this.getItems().add(item);
	}
}
