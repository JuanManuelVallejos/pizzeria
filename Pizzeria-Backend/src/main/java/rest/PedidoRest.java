package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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

	@POST
	@Path("/realizar")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Response nuevoPedido(@FormParam("itemsPedido") List<String> itemsPedido){

		return Response.ok(1).build();
	}
	
}
