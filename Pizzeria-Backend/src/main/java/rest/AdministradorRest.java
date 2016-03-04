package rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.Administrador;
import services.AdministradorService;

@Path("/administradores")
public class AdministradorRest {
	
	private AdministradorService administradorService;

	public AdministradorService getAdministradorService() {
		return administradorService;
	}

	public void setAdministradorService(AdministradorService administradorService) {
		this.administradorService = administradorService;
	}
	
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Administrador> obtenerTodosLosAdministradores() {
		List<Administrador> admins = getAdministradorService().retriveAll();
        return admins;
	}

	@POST
	@Path("/crear")
	@Produces("application/json")
	public Response crearAdministrador(@FormParam("nombre") String nombre, @FormParam("apellido") String apellido){
		Administrador admin = new Administrador(nombre, apellido);
		getAdministradorService().save(admin);
		return Response.ok(admin).build();
	}
}
