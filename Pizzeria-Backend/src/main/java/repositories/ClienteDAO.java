package repositories;

import java.util.List;

import org.hibernate.Session;

import model.Cliente;

public class ClienteDAO extends HibernateGenericDAO<Cliente> implements GenericRepository<Cliente> {

	private static final long serialVersionUID = -3252599980258592660L;

	@Override
	protected Class<Cliente> getDomainClass() {
		return Cliente.class;
	}
	
public Cliente buscarPorDni(String dni) {
		
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        try {
        	 String queryStr = " SELECT e FROM " + this.persistentClass.getName() + " AS e WHERE e.dni like :dni";

             @SuppressWarnings("unchecked")
			List<Cliente> clientes = session.createQuery(queryStr).setParameter("dni", dni).list();
             
             if(clientes.size() == 0){
            	 return null;
             }else{
            	 return clientes.get(0);
             }

        } finally {
            session.close();
        }
	}

public Cliente buscarPorNumeroDeCliente(String numeroDeCliente) {
	
	Session session = this.getHibernateTemplate().getSessionFactory().openSession();
    try {
    	 String queryStr = " SELECT e FROM " + this.persistentClass.getName() + " AS e WHERE e.dni like :numeroDeCliente";

         @SuppressWarnings("unchecked")
		List<Cliente> clientes = session.createQuery(queryStr).setParameter("numeroDeCliente", numeroDeCliente).list();
         
         if(clientes.size() == 0){
        	 return null;
         }else{
        	 return clientes.get(0);
         }

    } finally {
        session.close();
    }
}
	
}
