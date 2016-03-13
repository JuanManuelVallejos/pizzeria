package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.ObjetoCompra;
import services.ObjetoCompraService;

@Path("/objetoscompra")
public class ObjetoCompraRest {
	
	private ObjetoCompraService objetoCompraService;


	public ObjetoCompraService getObjetoCompraService() {
		return objetoCompraService;
	}

	public void setObjetoCompraService(ObjetoCompraService objetoCompraService) {
		this.objetoCompraService = objetoCompraService;
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<ObjetoCompra> obtenerTodosLosItemsPedidos() {
		List<ObjetoCompra> items = getObjetoCompraService().retriveAll();
        return items;
	}
	

}
