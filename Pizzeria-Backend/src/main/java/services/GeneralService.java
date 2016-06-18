package services;

public class GeneralService {

	private UsuarioService usuarioService;
	private RolService rolService;
	private AdministradorService administradorService;
	private ClienteService clienteService;
	private ItemPedidoService itemPedidoService;
	private PedidoService pedidoService;
	private ProductoService productoService;
	private PromocionService promocionService;

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public AdministradorService getAdministradorService() {
		return administradorService;
	}

	public void setAdministradorService(AdministradorService administradorService) {
		this.administradorService = administradorService;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public ItemPedidoService getItemPedidoService() {
		return itemPedidoService;
	}

	public void setItemPedidoService(ItemPedidoService itemPedidoService) {
		this.itemPedidoService = itemPedidoService;
	}

	public PedidoService getPedidoService() {
		return pedidoService;
	}

	public void setPedidoService(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	public ProductoService getProductoService() {
		return productoService;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	public PromocionService getPromocionService() {
		return promocionService;
	}

	public void setPromocionService(PromocionService promocionService) {
		this.promocionService = promocionService;
	}

	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}	
	
	
}
