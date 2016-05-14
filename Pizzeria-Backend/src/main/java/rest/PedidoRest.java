package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.Pedido;
import services.ClienteService;
import services.PedidoService;

@Path("/pedidos")
public class PedidoRest {
	
	private PedidoService pedidoService;
	private ClienteService clienteService;
	
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

//	@POST
//	@Path("/nuevo/{idCliente}/{idsItemPedido}")
//	@Produces("application/json")
//	public Response nuevoPedido(@PathParam("idCliente") Integer idCliente, @PathParam("idsItemPedido") String idsItemPedido){
//		List<String> idsItemsAsList = Arrays.asList(StringUtils.split(idsItemPedido, ","));
//		Cliente cliente = new Cliente(nombre, apellido,direccion, dni, nroDeCliente,password);
//		getClienteService().save(cliente);
//		return Response.ok(cliente).build();
//	}
	
}
