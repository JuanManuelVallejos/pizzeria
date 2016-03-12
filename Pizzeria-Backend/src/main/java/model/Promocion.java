package model;

import java.util.ArrayList;

public class Promocion extends ObjetoCompra{
	
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private Integer precio;
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	public Promocion(){}
	
	public Promocion(String nombre, Integer precio){
		super(nombre, precio);
	}
	
	public Promocion(String nombre, Integer precio,ArrayList<Producto> productos){
		super(nombre, precio);
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
