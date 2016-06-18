package services;

import org.apache.commons.codec.digest.DigestUtils;

import exceptions.NombreUsuarioExistenteException;
import exceptions.UsuarioConDNIExistenteException;
import exceptions.UsuarioOPasswordInvalido;
import model.Rol;
import model.Usuario;
import repositories.UsuarioDAO;

public class UsuarioService extends GenericService<Usuario> {

	private static final long serialVersionUID = 7810311595651598047L;
	
	public void verificarDNIExistente(Integer dni) throws UsuarioConDNIExistenteException{
		if(this.buscarPorDni(dni)!= null){
			throw new UsuarioConDNIExistenteException();
		}
	}
	
	public void verificarNombreUsuarioExistente(String numeroDeCliente) throws NombreUsuarioExistenteException{
		if(this.buscarPorNombreUsuario(numeroDeCliente)!= null){
			throw new NombreUsuarioExistenteException();
		}
	}
	
	public Usuario darDeAltaNuevoCliente(String nombre,String apellido,String nombreUsuario,Integer dni, Integer telefono,String direccion,String password, Rol rol) throws UsuarioConDNIExistenteException, NombreUsuarioExistenteException{
		this.verificarDNIExistente(dni);

		String encryptPassword = this.encriptarPassword(password);
		Usuario cliente = new Usuario(nombre, apellido,nombreUsuario,dni,telefono,direccion,encryptPassword,rol);
		return cliente;
	}
	
	public String encriptarPassword(String password){
		return DigestUtils.md5Hex(password);
	}
	
	public Usuario buscarPorDni(Integer dni) {
		return ((UsuarioDAO) this.getRepository()).buscarPorDni(dni);
	}
	
	public Usuario buscarPorNombreUsuario(String nombreUsuario) {
		return ((UsuarioDAO) this.getRepository()).buscarPorNombreDeUsuario(nombreUsuario);
	}

	public Usuario obtenerClientePorUsuarioYPassword(String usuario, String password) throws UsuarioOPasswordInvalido {
		return ((UsuarioDAO) this.getRepository()).obtenerUsuarioPorUserYPassword(usuario, password);
	}
	
	public Usuario obtenerClientePorUsuario(String usuario) {
		return ((UsuarioDAO) this.getRepository()).obtenerUsuarioPorUsername(usuario);
	}
}
