package model;

public class ItemPedido extends Entity {

	private Producto producto;
	private Integer cantidad;
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public ItemPedido(){}
	
	public ItemPedido(Producto producto, Integer cantidad){
		this.setProducto(producto);
		this.setCantidad(cantidad);	
	}
}
