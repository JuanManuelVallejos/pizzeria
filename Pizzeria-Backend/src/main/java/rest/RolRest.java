package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.Rol;
import services.RolService;

@Path("/roles")
public class RolRest  {
	
	private RolService rolService;
	
	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Rol> obtenerTodosLasPromociones() {
		List<Rol> roles = getRolService().retriveAll();
        return roles;
	}
}