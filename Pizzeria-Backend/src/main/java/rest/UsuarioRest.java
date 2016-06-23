package rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import exceptions.NombreUsuarioExistenteException;
import exceptions.UsuarioConDNIExistenteException;
import exceptions.UsuarioOPasswordInvalido;
import model.Cliente;
import model.Pedido;
import model.Usuario;
import services.PedidoService;
import services.UsuarioService;

@Path("/usuarios")
public class UsuarioRest {
	
	private UsuarioService usuarioService;
	private PedidoService pedidoService;
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
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
	public List<Usuario> obtenerTodosLosUsuarios() {
		List<Usuario> usuarios = getUsuarioService().retriveAll();
        return usuarios;
	}

	@POST
	@Path("/crear/{nombre}/{apellido}/{direccion}/{dni}/{nombreUsuario}/{password}/{nroDeTelefono}")
	@Produces("application/json")
	public Response crearCliente(@PathParam("nombre") String nombre, @PathParam("apellido") String apellido,@PathParam("direccion") String direccion,
			@PathParam("dni") Integer dni, @PathParam("nombreUsuario") String nombreUsuario, @PathParam("password") String password, @PathParam("nroDeTelefono") Integer nroDeTelefono) throws UsuarioConDNIExistenteException, NombreUsuarioExistenteException{
		
		Cliente cliente = this.getUsuarioService().darDeAltaNuevoCliente(nombre, apellido,direccion, dni, nombreUsuario,password, nroDeTelefono);
		this.getUsuarioService().save(cliente);
		return Response.ok(cliente).build();
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
			cliente = getUsuarioService(
			).obtenerClientePorUsuarioYPassword(usuario, password);
		} catch (UsuarioOPasswordInvalido e) {
			return Response.ok(-1).build();
		} 
        return Response.ok(cliente).build();
	}
}
