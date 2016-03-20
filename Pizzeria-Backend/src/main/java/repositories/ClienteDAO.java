package repositories;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Cliente;

public class ClienteDAO extends HibernateGenericDAO<Cliente> implements GenericRepository<Cliente> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<Cliente> getDomainClass() {
		return Cliente.class;
	}
	
	public Cliente buscarPorDni(Integer dni) {		
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("DNI", dni));
		return (Cliente) criteria.uniqueResult();
	}

	public Cliente buscarPorNumeroDeCliente(Integer numeroDeCliente) {	
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("NUMERO_DE_CLIENTE", numeroDeCliente));
		return (Cliente) criteria.uniqueResult();
	}
}
