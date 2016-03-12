package repositories;

import model.ObjetoCompra;

public class ObjetoCompraDAO extends HibernateGenericDAO<ObjetoCompra> implements GenericRepository<ObjetoCompra> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<ObjetoCompra> getDomainClass() {
		return ObjetoCompra.class;
	}
	
}
