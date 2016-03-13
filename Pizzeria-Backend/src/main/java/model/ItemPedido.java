package model;

@SuppressWarnings("serial")
public class ItemPedido extends Entity {

	private ObjetoCompra objetoCompra;
	private Integer cantidad;
	
	public ItemPedido(){}
	
	public ItemPedido(ObjetoCompra objetoCompra, Integer cantidad){
		this.setObjetoCompra(objetoCompra);
		this.setCantidad(cantidad);	
	}
	
	public ObjetoCompra getObjetoCompra() {
		return objetoCompra;
	}
	public void setObjetoCompra(ObjetoCompra objetoCompra) {
		this.objetoCompra = objetoCompra;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Integer precioTotalItem(){
		return this.getObjetoCompra().getPrecio() * this.getCantidad();
	}
}
