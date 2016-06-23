package services;

import org.apache.commons.codec.digest.DigestUtils;

import exceptions.NombreUsuarioExistenteException;
import exceptions.UsuarioConDNIExistenteException;
import exceptions.UsuarioOPasswordInvalido;
import model.Cliente;
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
	
	public Cliente darDeAltaNuevoCliente(String nombre,String apellido,String direccion,Integer dni,String nombreUsuario,String password, Integer nroDeTelefono) throws UsuarioConDNIExistenteException, NombreUsuarioExistenteException{
		this.verificarDNIExistente(dni);

		String encryptPassword = this.encriptarPassword(password);
		Cliente cliente = new Cliente(nombre, apellido,direccion, dni, nombreUsuario,encryptPassword,nroDeTelefono);
		return cliente;
	}
	
	public String encriptarPassword(String password){
		return DigestUtils.md5Hex(password);
	}
	
	public Cliente buscarPorDni(Integer dni) {
		return ((UsuarioDAO) this.getRepository()).buscarPorDni(dni);
	}
	
	public Cliente buscarPorNombreUsuario(String numeroDeCliente) {
		return ((UsuarioDAO) this.getRepository()).obtenerClientePorUsuario(numeroDeCliente);
	}
	
	public Cliente buscarPorNumeroDeCliente(String numeroDeCliente) {
		return ((UsuarioDAO) this.getRepository()).buscarPorNumeroDeCliente(numeroDeCliente);
	}

	public Cliente obtenerClientePorUsuarioYPassword(Integer usuario, String password) throws UsuarioOPasswordInvalido {
		return ((UsuarioDAO) this.getRepository()).obtenerClientePorUsuarioYPassword(usuario, password);
	}
	
	public Cliente obtenerClientePorUsuario(String usuario) {
		return ((UsuarioDAO) this.getRepository()).obtenerClientePorUsuario(usuario);
	}
}
