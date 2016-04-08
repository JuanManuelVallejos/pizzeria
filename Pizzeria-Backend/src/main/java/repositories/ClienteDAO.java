package repositories;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import exceptions.UsuarioOPasswordInvalido;
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
		criteria.add(Restrictions.eq("dni", dni));
		return (Cliente) criteria.uniqueResult();
	}

	public Cliente buscarPorNumeroDeCliente(Integer numeroDeCliente) {	
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("numeroDeCliente", numeroDeCliente));
		return (Cliente) criteria.uniqueResult();
	}

	public Cliente obtenerClientePorUsuarioYPassword(int usuario, String password) throws UsuarioOPasswordInvalido {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("numeroDeCliente", usuario));
		criteria.add(Restrictions.eq("password", password));
		
		Cliente cliente = (Cliente) criteria.uniqueResult();
		
		if(cliente == null)
			throw new UsuarioOPasswordInvalido();
		
		return cliente;
	}
	
	public Cliente obtenerClientePorUsuario(int usuario) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("numeroDeCliente", usuario));
		
		Cliente cliente = (Cliente) criteria.uniqueResult();
		
		return cliente;
	}
}
