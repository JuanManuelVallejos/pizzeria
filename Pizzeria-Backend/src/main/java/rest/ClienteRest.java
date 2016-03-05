package rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import model.Cliente;
import services.ClienteService;

@Path("/clientes")
public class ClienteRest {
	
	private ClienteService clienteService;
	
	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Cliente> obtenerTodosLosClientes() {
		List<Cliente> clientes = getClienteService().retriveAll();
        return clientes;
	}

	@POST
	@Path("/crear")
	@Produces("application/json")
	public Response crearCliente(@FormParam("nombre") String nombre, @FormParam("apellido") String apellido, @FormParam("direccion") String direccion,
			@FormParam("dni") Integer dni, @FormParam("nroDeCliente") Integer nroDeCliente){
		Cliente cliente = new Cliente(nombre, apellido,direccion, dni, nroDeCliente);
		getClienteService().save(cliente);
		return Response.ok(cliente).build();
	}
}
