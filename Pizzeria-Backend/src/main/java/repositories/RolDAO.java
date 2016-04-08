package repositories;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Rol;

public class RolDAO extends HibernateGenericDAO<Rol> implements GenericRepository<Rol> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5759038387478208307L;

	@Override
	protected Class<Rol> getDomainClass() {
		return Rol.class;
	}
	
	public Rol getRol(int id){
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Rol.class);
		criteria.add(Restrictions.eq("ID", id));
		
		Rol rol = (Rol) criteria.uniqueResult();
		
		return rol;
	}
}
