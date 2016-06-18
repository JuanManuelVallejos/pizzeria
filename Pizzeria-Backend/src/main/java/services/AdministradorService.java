package services;

import dtos.AdministradorDTO;
import model.Administrador;

public class AdministradorService extends GenericService<Administrador> {

	private static final long serialVersionUID = 7810311595651598047L;

	public AdministradorDTO convertAdministradorADTO(Administrador admin){
		AdministradorDTO admindto = new AdministradorDTO();
		admindto.setIdAdministrador(admin.getId());
		admindto.setNombre(admin.getNombreRol());
		return admindto;
	}
	
	public void init(){
		this.save(new Administrador());
	}
	
}
