package services;

import java.util.List;

import dtos.PedidoDTO;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Producto;
import repositories.ClienteDAO;
import repositories.ItemPedidoDAO;
import repositories.PedidoDAO;
import repositories.ProductoDAO;

public class PedidoService extends GenericService<Pedido> {

	private static final long serialVersionUID = 7810311595651598047L;

	private ClienteDAO clienteDAO;
	private ProductoDAO productoDAO;
	private ItemPedidoDAO itemPedidoDAO;
	


	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	public ItemPedidoDAO getItemPedidoDAO() {
		return itemPedidoDAO;
	}

	public void setItemPedidoDAO(ItemPedidoDAO itemPedidoDAO) {
		this.itemPedidoDAO = itemPedidoDAO;
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public List<Pedido> obtenerPedidosActivos(int idCliente) {
		return  ((PedidoDAO) this.getRepository()).obtenerPedidosActivosDeCliente(idCliente);
	}
	
	public boolean tienePedidosActivos(int idCliente) {
		return  ((PedidoDAO) this.getRepository()).tienePedidosActivos(idCliente);
	}
	
	public void asociarPedidoAlCliente(int idPedido, int idCliente){
		Pedido pedido = this.findById(idPedido);
		Cliente cliente = this.getClienteDAO().findById(idCliente);
		pedido.setCliente(cliente);
		this.getRepository().save(pedido);
	}
	
	public void agregarItemAlPedido(int idPedido, int idProducto, int cantidad){
		Producto producto = this.getProductoDAO().findById(idProducto);
		Pedido pedido = this.findById(idPedido);
		ItemPedido item = new ItemPedido();
		item.setCantidad(cantidad);
		item.setObjetoCompra(producto);
		pedido.getItems().add(item);
		this.getItemPedidoDAO().save(item);
		this.getRepository().save(pedido);
	}
	
	public void marcarPedidoComoEntregado(int idPedido){
		Pedido pedido = this.findById(idPedido);
		pedido.setRealizado(true);
		this.getRepository().save(pedido);
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
