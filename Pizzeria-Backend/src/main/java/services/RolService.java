package services;

import java.util.ArrayList;
import java.util.List;

import model.Administrador;
import model.Cliente;
import model.Rol;


public class RolService extends GenericService<Rol> {

	private static final long serialVersionUID = 7810311595651598047L;
	
	public List<Rol>  inicializarRoles(){
		
		Administrador admin = new Administrador();
		Cliente cliente = new Cliente();
		List<Rol> roles = new ArrayList<Rol>();
		roles.add(admin);
		roles.add(cliente);
		this.save(cliente);
		this.save(admin);
		return roles;
	}
}
