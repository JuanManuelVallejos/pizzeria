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
import model.Rol;
import model.Usuario;
import services.RolService;
import services.UsuarioService;

@Path("/usuarios")
public class UsuarioRest {
	
	private UsuarioService usuarioService;
	private RolService rolService;
	
	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Usuario> obtenerTodosLosClientes() {
		List<Usuario> clientes = getUsuarioService().retriveAll();
        return clientes;
	}

	@POST
	@Path("/crear/{nombre}/{apellido}/{direccion}/{dni}/{nroDeCliente}/{password}/{nroDeTelefono}")
	@Produces("application/json")
	public Response crearCliente(@PathParam("nombre") String nombre, @PathParam("apellido") String apellido,@PathParam("direccion") String direccion,
			@PathParam("dni") Integer dni, @PathParam("nroDeCliente") String nroDeCliente, @PathParam("password") String password, @PathParam("nroDeTelefono") Integer nroDeTelefono,@PathParam("rol") Integer idRol ) throws UsuarioConDNIExistenteException, NombreUsuarioExistenteException{
		Rol rolCliente = this.getRolService().findById(1);
		Usuario cliente = this.getUsuarioService().darDeAltaNuevoCliente(nombre, apellido,nroDeCliente,dni,nroDeTelefono,direccion ,password, rolCliente);
		this.getUsuarioService().save(cliente);
		return Response.ok(cliente).build();
	}
	
	@POST
	@Path("/ingresar/")
	@Produces("application/json")
	public Response ingresar(@FormParam("usuario") String usuario, @FormParam("password") String password) {
		/*Cliente	cliente = new Cliente("juan", "dimeglio", "direccion", 37000000 , usuario, password, 40000000);*/
		
		Usuario	cliente;
		try {
			cliente = getUsuarioService(
			).obtenerClientePorUsuarioYPassword(usuario, password);
		} catch (UsuarioOPasswordInvalido e) {
			return Response.ok(-1).build();
		} 
        return Response.ok(cliente).build();
	}
}
