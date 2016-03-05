package repositories;

import model.Pedido;

public class PedidoDAO extends HibernateGenericDAO<Pedido> implements GenericRepository<Pedido> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<Pedido> getDomainClass() {
		return Pedido.class;
	}
	
}
