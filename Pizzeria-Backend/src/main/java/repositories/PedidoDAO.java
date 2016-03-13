package repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Pedido;

public class PedidoDAO extends HibernateGenericDAO<Pedido> implements GenericRepository<Pedido> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<Pedido> getDomainClass() {
		return Pedido.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> obtenerPedidosActivos(String idCliente){
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Pedido.class);
		criteria.add(Restrictions.eq("ID", idCliente));
		criteria.add(Restrictions.eq("REALIZADO", 1));
		return criteria.list();
	}
	
	//agregar tiene pedidos activos
}
