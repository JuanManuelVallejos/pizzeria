package dtos;

import java.util.ArrayList;

import model.ItemPedido;

public class PedidoDTO {

	private int idPedido;
	private ArrayList<ItemPedido> items;
	private boolean realizado = false;
	private int idCliente;
	
	
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
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
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
}
