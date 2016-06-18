package repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import exceptions.UsuarioOPasswordInvalido;
import model.Cliente;
import model.Usuario;

public class UsuarioDAO extends HibernateGenericDAO<Usuario> implements GenericRepository<Usuario> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<Usuario> getDomainClass() {
		return Usuario.class;
	}
	
	public Usuario buscarPorDni(Integer dni) {		
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("dni", dni));
		return (Usuario) criteria.uniqueResult();
	}

	public Usuario buscarPorNombreDeUsuario(String numeroDeCliente) {	
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("nombreUsuario", numeroDeCliente));
		return (Usuario) criteria.uniqueResult();
	}

	public Usuario obtenerUsuarioPorUserYPassword(String usuario, String password) throws UsuarioOPasswordInvalido {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("nombreUsuario", usuario));
		criteria.add(Restrictions.eq("password", password));
		
		Usuario cliente = (Usuario) criteria.uniqueResult();
		
		if(cliente == null)
			throw new UsuarioOPasswordInvalido();
		
		return cliente;
	}
	
	public Usuario obtenerUsuarioPorUsername(String usuario) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("nombreUsuario", usuario));
		
		Usuario cliente = (Usuario) criteria.uniqueResult();
		
		return cliente;
	}
	
	public List<Usuario> obtenerUsuariosClientesConPedidosActivos(){
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.createCriteria("Pedido").add(Restrictions.isNotNull("idCliente"));
		criteria.createCriteria("Pedido").add(Restrictions.eq("realizado",true));
		return  criteria.list();
	}
}
