package rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.ItemPedido;
import model.ObjetoCompra;
import model.Producto;
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
