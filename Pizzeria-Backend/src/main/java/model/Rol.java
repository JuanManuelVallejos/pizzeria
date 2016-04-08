package model;

import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")
public class Rol extends Entity{

	private String rol;
    private Set<Cliente> clientes;
 
 
    public String getRol() {
        return rol;
    }
 
    public void setRol(String rol) {
        this.rol = rol;
    }
 
    public Set<Cliente> getClientes() {
        return clientes;
    }
 
    public void setUserRoles(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
	
}
