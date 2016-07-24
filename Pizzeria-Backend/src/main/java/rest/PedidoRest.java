package rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;

import dtos.PedidoDTO;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Producto;
import services.ClienteService;
import services.ItemPedidoService;
import services.ObjetoCompraService;
import services.PedidoService;
import services.ProductoService;

@Path("/pedidos")
public class PedidoRest {
	
	private PedidoService pedidoService;
	private ClienteService clienteService;
	private ObjetoCompraService objetoCompraService;
	private ItemPedidoService itemPedidoService;
	private ProductoService productoService;
	
	public ProductoService getProductoService() {
		return productoService;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	public ItemPedidoService getItemPedidoService() {
		return itemPedidoService;
	}

	public void setItemPedidoService(ItemPedidoService itemPedidoService) {
		this.itemPedidoService = itemPedidoService;
	}

	public ObjetoCompraService getObjetoCompraService() {
		return objetoCompraService;
	}

	public void setObjetoCompraService(ObjetoCompraService objetoCompraService) {
		this.objetoCompraService = objetoCompraService;
	}

	public PedidoService getPedidoService() {
		return pedidoService;
	}

	public void setPedidoService(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Pedido> obtenerTodosLosPedidos() {
		List<Pedido> pedidos = getPedidoService().retriveAll();
        return pedidos;
	}
	
	@GET
	@Path("/historialPedidos/{idCliente}")
	@Produces("application/json")
	public List<PedidoDTO> obtenerPedidosPorCliente(@PathParam("idCliente") Integer idCliente) {
		Cliente cliente = getClienteService().findById(idCliente);
		List<PedidoDTO> pedidosDTO = new ArrayList<PedidoDTO>();
		List<Pedido> pedidos = getPedidoService().GetPedidosPorCliente(idCliente);
		for (Pedido pedido : pedidos) {
			PedidoDTO pedidoDTO = new PedidoDTO();
			pedidoDTO.seatearRealizado(pedido.isRealizado());
			pedidoDTO.setImporte(pedido.totalCompra());
			pedidoDTO.setDireccion(cliente.getDireccion());
			pedidosDTO.add(pedidoDTO);
		}
		
        return pedidosDTO;
	}
	
	@POST
	@Path("/realizar/{items}/{cantidades}/{idCliente}")
	@Produces("application/json")
	public Response newPedido(@PathParam("items") String items,@PathParam("cantidades") String cantidades,
			@PathParam("idCliente") Integer idCliente){
		
		List<String> idsItems = Arrays.asList(StringUtils.split(items, ","));
		List<String> cantsItems = Arrays.asList(StringUtils.split(cantidades, ","));
		ArrayList<ItemPedido> itemsPedido = new ArrayList<ItemPedido>();
		for(int i = 0; i < (idsItems.size()) ; i++){
			Integer id = Integer.parseInt(idsItems.get(i));
			Producto objCompra = this.getProductoService().findById(id);
			Integer cantidad = Integer.parseInt(cantsItems.get(i));
			ItemPedido item = new ItemPedido(objCompra,cantidad);
			itemsPedido.add(item);
		}
		Pedido pedido = new Pedido();
		pedido.setCliente(getClienteService().findById(idCliente));
		pedido.setItems(itemsPedido);
		this.getPedidoService().save(pedido);
		return Response.ok(pedido).build();
	}	
}
