package repositories;

import model.Cliente;

public class ClienteDAO extends HibernateGenericDAO<Cliente> implements GenericRepository<Cliente> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<Cliente> getDomainClass() {
		return Cliente.class;
	}
	
}
