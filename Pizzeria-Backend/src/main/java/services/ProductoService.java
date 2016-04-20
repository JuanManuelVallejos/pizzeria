package services;

import dtos.ProductoDTO;
import model.Producto;

public class ProductoService extends GenericService<Producto> {

	private static final long serialVersionUID = 7810311595651598047L;

	public ProductoDTO convertProductoADTO(Producto producto){
		ProductoDTO productoDTO = new ProductoDTO();
		productoDTO.setIdProducto(producto.getId());
		productoDTO.setNombre(producto.getNombre());
		productoDTO.setPrecio(producto.getPrecio());

		return productoDTO;
	}
}
