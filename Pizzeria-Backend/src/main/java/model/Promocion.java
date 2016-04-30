package model;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Promocion extends ObjetoCompra{
	
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public Promocion(){}
	
	public Promocion(String nombre, Integer precio, byte[] imagen){
		super(nombre, precio, imagen);
	}
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	public Promocion(String nombre, Integer precio,ArrayList<Producto> productos, byte[] imagen){
		super(nombre, precio, imagen);
		this.setProductos(productos);
	}
	
	public void agregarProducto(Producto producto){
		this.getProductos().add(producto);
	}
	
	public void aplicarDescuentoEnPorcentaje(Integer descuento){
		Integer total = 0;
		for(Producto each : this.getProductos()){
			total = total + each.getPrecio();
		}
		total = total - (total*descuento) / 100;
		this.setPrecio(total);
	}
}
