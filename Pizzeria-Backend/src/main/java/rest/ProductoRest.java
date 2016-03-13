package rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.Producto;
import services.ProductoService;

@Path("/productos")
public class ProductoRest {
	
	private ProductoService productoService;

	public ProductoService getProductoService() {
		return productoService;
	}
	
	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Producto> obtenerTodosLosProductos() {
		List<Producto> productos = getProductoService().retriveAll();
        return productos;
	}
	
	@POST
	@Path("/crear")
	@Produces("application/json")
	public Response crearProducto(@FormParam("nombre") String nombre, @FormParam("precio") Integer precio){
		Producto producto = new Producto(nombre, precio);
		getProductoService().save(producto);
		return Response.ok(producto).build();
	}

}
