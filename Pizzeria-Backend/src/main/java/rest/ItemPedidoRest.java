package rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.ItemPedido;
import model.Producto;
import services.ItemPedidoService;

@Path("/itemspedidos")
public class ItemPedidoRest {
	
	private ItemPedidoService itemPedidoService;

	public ItemPedidoService getItemPedidoService() {
		return itemPedidoService;
	}

	public void setItemPedidoService(ItemPedidoService itemPedidoService) {
		this.itemPedidoService = itemPedidoService;
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<ItemPedido> obtenerTodosLosItemsPedidos() {
		List<ItemPedido> items = getItemPedidoService().retriveAll();
        return items;
	}
	
	@POST
	@Path("/crear")
	@Produces("application/json")
	public Response crearItemPedido(@FormParam("nombreProducto") String nombreProducto, @FormParam("precioProducto") Integer precioProducto,
			@FormParam("cantidadProducto") Integer cantidadProducto){
		Producto producto = new Producto(nombreProducto, precioProducto);
		ItemPedido item = new ItemPedido(producto, cantidadProducto);
		getItemPedidoService().save(item);
		return Response.ok(item).build();
	}

}
