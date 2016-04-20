package repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.ItemPedido;

public class ItemPedidoDAO extends HibernateGenericDAO<ItemPedido> implements GenericRepository<ItemPedido> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<ItemPedido> getDomainClass() {
		return ItemPedido.class;
	}
	
	public List<ItemPedido> obtenerItemsDeUnPedido(int idPedido){
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(ItemPedido.class);
		criteria.createCriteria("Pedido").add(Restrictions.eq("id",idPedido));
		return  criteria.list();
	}
	
}
