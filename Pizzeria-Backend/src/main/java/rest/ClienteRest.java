package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.Cliente;
import model.Pedido;
import services.ClienteService;
import services.PedidoService;

@Path("/clientes")
public class ClienteRest {
	
	private ClienteService clienteService;
	private PedidoService pedidoService;
	
	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	public PedidoService getPedidoService() {
		return pedidoService;
	}

	public void setPedidoService(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Cliente> obtenerTodosLosClientes() {
		List<Cliente> clientes = getClienteService().retriveAll();
        return clientes;
	}

	@POST
	@Path("/crear/{nombre}/{apellido}/{direccion}/{dni}/{nroDeCliente}")
	@Produces("application/json")
	public Response crearCliente(@PathParam("nombre") String nombre, @PathParam("apellido") String apellido,@PathParam("direccion") String direccion,
			@PathParam("dni") Integer dni, @PathParam("nroDeCliente") Integer nroDeCliente){
		Cliente cliente = new Cliente(nombre, apellido,direccion, dni, nroDeCliente);
		getClienteService().save(cliente);
		return Response.ok(cliente).build();
	}

	@GET
	@Path("/pedidosActivos/{idCliente}")
	@Produces("application/json")
	public List<Pedido> obtenerPedidosActivos(@PathParam("idCliente") int idCliente) {
		List<Pedido> pedidos = getPedidoService().obtenerPedidosActivos(idCliente);
        return pedidos;
	}
	
}
