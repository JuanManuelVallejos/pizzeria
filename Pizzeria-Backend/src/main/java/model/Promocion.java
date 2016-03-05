package model;

import java.util.ArrayList;

public class Promocion extends Entity{
	
	private ArrayList<ItemPedido> items = new ArrayList<ItemPedido>();
	private Integer precio;
	
	public ArrayList<ItemPedido> getItems() {
		return items;
	}
	public void setItems(ArrayList<ItemPedido> items) {
		this.items = items;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Promocion(){}
	
}
