package repositories;

import model.ItemPedido;

public class ItemPedidoDAO extends HibernateGenericDAO<ItemPedido> implements GenericRepository<ItemPedido> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<ItemPedido> getDomainClass() {
		return ItemPedido.class;
	}
	
}
