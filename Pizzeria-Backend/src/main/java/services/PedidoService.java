package services;

import java.util.List;

import dtos.PedidoDTO;
import model.Pedido;
import repositories.PedidoDAO;

public class PedidoService extends GenericService<Pedido> {

	private static final long serialVersionUID = 7810311595651598047L;

	public List<Pedido> obtenerPedidosActivos(int idCliente) {
		return  ((PedidoDAO) this.getRepository()).obtenerPedidosActivosDeCliente(idCliente);
	}
	
	public boolean tienePedidosActivos(int idCliente) {
		return  ((PedidoDAO) this.getRepository()).tienePedidosActivos(idCliente);
	}
	
	public PedidoDTO convertPedidoADTO(Pedido pedido){
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setIdPedido(pedido.getId());
		pedidoDTO.setIdCliente(pedido.getCliente().getId());
		pedidoDTO.setRealizado(pedido.isRealizado());
		pedidoDTO.setItems(pedido.getItems());

		return pedidoDTO;
	}
}
