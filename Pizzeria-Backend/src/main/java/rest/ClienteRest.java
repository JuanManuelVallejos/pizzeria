package rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import exceptions.UsuarioOPasswordInvalido;
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


	@GET
	@Path("/pedidosActivos/{idCliente}")
	@Produces("application/json")
	public List<Pedido> obtenerPedidosActivos(@PathParam("idCliente") int idCliente) {
		List<Pedido> pedidos = getPedidoService().obtenerPedidosActivos(idCliente);
        return pedidos;
	}
	
	@POST
	@Path("/ingresar/")
	@Produces("application/json")
	public Response ingresar(@FormParam("usuario") Integer usuario, @FormParam("password") String password) {
		/*Cliente	cliente = new Cliente("juan", "dimeglio", "direccion", 37000000 , usuario, password, 40000000);*/
		
		Cliente	cliente;
		try {
			cliente = getClienteService(
			).obtenerClientePorUsuarioYPassword(usuario, password);
		} catch (UsuarioOPasswordInvalido e) {
			return Response.ok(-1).build();
		} 
        return Response.ok(cliente).build();
	}
}
