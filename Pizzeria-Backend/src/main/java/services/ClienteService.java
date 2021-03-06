package services;

import org.apache.commons.codec.digest.DigestUtils;

import dtos.ClienteDTO;
import exceptions.NombreUsuarioExistenteException;
import exceptions.UsuarioConDNIExistenteException;
import exceptions.UsuarioOPasswordInvalido;
import model.Cliente;
import model.Usuario;
import repositories.ClienteDAO;


public class ClienteService extends GenericService<Cliente> {

	private static final long serialVersionUID = 7810311595651598047L;

	public ClienteDTO convertClienteADTO(Cliente cliente){
		ClienteDTO clientedto = new ClienteDTO();
		clientedto.setIdCliente(cliente.getId());
		clientedto.setNombre(cliente.getNombre());
		clientedto.setApellido(cliente.getApellido());
		clientedto.setDni(cliente.getDni());
		clientedto.setDireccion(cliente.getDireccion());
//		clientedto.setNumeroDeCliente(cliente.getNumeroDeCliente());
		clientedto.setPassword(cliente.getPassword());
		clientedto.setTelefono(cliente.getTelefono());
		clientedto.setPedidos(cliente.getPedidos());

		return clientedto;
	}
	
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
		return ((ClienteDAO) this.getRepository()).buscarPorDni(dni);
	}
	
	public Cliente buscarPorNombreUsuario(String numeroDeCliente) {
		return ((ClienteDAO) this.getRepository()).obtenerClientePorUsuario(numeroDeCliente);
	}
	
	public Cliente buscarPorNumeroDeCliente(String numeroDeCliente) {
		return ((ClienteDAO) this.getRepository()).buscarPorNumeroDeCliente(numeroDeCliente);
	}

	public Cliente obtenerClientePorUsuarioYPassword(String usuario, String password) throws UsuarioOPasswordInvalido {
		String encryptPassword = this.encriptarPassword(password);
		return ((ClienteDAO) this.getRepository()).obtenerClientePorUsuarioYPassword(usuario, encryptPassword);
	}
	
	public Cliente obtenerClientePorUsuario(String usuario) {
		return ((ClienteDAO) this.getRepository()).obtenerClientePorUsuario(usuario);
	}
}
