package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.Promocion;
import services.PromocionService;

@Path("/promociones")
public class PromocionRest {
	
	private PromocionService promocionService;
	
	public PromocionService getPromocionService() {
		return promocionService;
	}

	public void setPromocionService(PromocionService promocionService) {
		this.promocionService = promocionService;
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Promocion> obtenerTodosLasPromociones() {
		List<Promocion> promociones = getPromocionService().retriveAll();
        return promociones;
	}
}
