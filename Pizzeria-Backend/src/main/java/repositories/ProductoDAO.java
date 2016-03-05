package repositories;

import model.Producto;

public class ProductoDAO extends HibernateGenericDAO<Producto> implements GenericRepository<Producto> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<Producto> getDomainClass() {
		return Producto.class;
	}
	
}
