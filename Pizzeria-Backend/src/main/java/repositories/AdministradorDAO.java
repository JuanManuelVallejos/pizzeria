package repositories;

import model.Administrador;

public class AdministradorDAO extends HibernateGenericDAO<Administrador> implements GenericRepository<Administrador> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<Administrador> getDomainClass() {
		return Administrador.class;
	}
	
}
