package repositories;

import model.Promocion;

public class PromocionDAO extends HibernateGenericDAO<Promocion> implements GenericRepository<Promocion> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<Promocion> getDomainClass() {
		return Promocion.class;
	}
	
}
