package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.Rol;
import services.AdministradorService;
import services.ClienteService;
import services.RolService;

@Path("/roles")
public class RolRest {
	
	private RolService rolService;
	private ClienteService clienteService;
	private AdministradorService administradorService;
	
	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public AdministradorService getAdministradorService() {
		return administradorService;
	}

	public void setAdministradorService(AdministradorService administradorService) {
		this.administradorService = administradorService;
	}

	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Rol> obtenerTodosLosRoles() {
		List<Rol> roles = getRolService().retriveAll();
        return roles;
	}
	
	@POST
	@Path("/init")
	@Produces("application/json")
	public Response inicializarRoles(){
//		List<Rol> roles = this.getRolService().inicializarRoles();
		this.getClienteService().init();
		this.getAdministradorService().init();
		return Response.ok("").build();
	}

}
