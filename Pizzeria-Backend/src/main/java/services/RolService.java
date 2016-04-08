package services;

import repositories.RolDAO;
import model.Rol;

public class RolService extends GenericService<Rol> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Rol obtenerClientePorUsuario(int id) {
		return ((RolDAO) this.getRepository()).getRol(id);
	}
	
}
