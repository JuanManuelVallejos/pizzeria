package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.Pedido;
import services.PedidoService;

@Path("/pedidos")
public class PedidoRest {
	
	private PedidoService pedidoService;
	public PedidoService getPedidoService() {
		return pedidoService;
	}

	public void setPedidoService(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Pedido> obtenerTodosLosPedidos() {
		List<Pedido> pedidos = getPedidoService().retriveAll();
        return pedidos;
	}

}
