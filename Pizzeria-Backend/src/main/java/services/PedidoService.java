package services;

import java.util.List;

import model.Pedido;
import repositories.PedidoDAO;

public class PedidoService extends GenericService<Pedido> {

	private static final long serialVersionUID = 7810311595651598047L;

	public List<Pedido> obtenerPedidosActivos(String idCliente) {
		return  ((PedidoDAO) this.getRepository()).obtenerPedidosActivos(idCliente);
	}

}
