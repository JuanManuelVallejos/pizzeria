package repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Producto;

public class ProductoDAO extends HibernateGenericDAO<Producto> implements GenericRepository<Producto> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<Producto> getDomainClass() {
		return Producto.class;
	}
	
	public List<Producto> buscarProductosPorNombreSimilar(String nombreProducto) {	
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Producto.class);
		criteria.add(Restrictions.eq("nombre", nombreProducto));
		return (List<Producto>) criteria.list();
	}
	
}
