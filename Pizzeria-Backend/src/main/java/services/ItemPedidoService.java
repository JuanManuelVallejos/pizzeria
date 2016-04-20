package services;

import dtos.ItemPedidoDTO;
import model.ItemPedido;

public class ItemPedidoService extends GenericService<ItemPedido> {

	private static final long serialVersionUID = 7810311595651598047L;

	public ItemPedidoDTO convertItemPedidoADTO(ItemPedido itemPedido){
		ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
		itemPedidoDTO.setCantidad(itemPedido.getCantidad());
		itemPedidoDTO.setIdObjectoCompra(itemPedido.getObjetoCompra().getId());

		return itemPedidoDTO;
	}
}
