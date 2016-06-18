package repositories;

import model.Rol;

public class RolDAO extends HibernateGenericDAO<Rol> implements GenericRepository<Rol> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<Rol> getDomainClass() {
		return Rol.class;
	}
	
}
