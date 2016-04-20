package services;

import dtos.ClienteDTO;
import exceptions.UsuarioOPasswordInvalido;
import model.Cliente;
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
		clientedto.setNumeroDeCliente(cliente.getNumeroDeCliente());
		clientedto.setPassword(cliente.getPassword());
		clientedto.setTelefono(cliente.getTelefono());
		clientedto.setPedidos(cliente.getPedidos());

		return clientedto;
	}
	
	public Cliente buscarPorDni(Integer dni) {
		return ((ClienteDAO) this.getRepository()).buscarPorDni(dni);
	}
	
	public Cliente buscarPorNumeroDeCliente(String numeroDeCliente) {
		return ((ClienteDAO) this.getRepository()).buscarPorNumeroDeCliente(numeroDeCliente);
	}

	public Cliente obtenerClientePorUsuarioYPassword(int usuario, String password) throws UsuarioOPasswordInvalido {
		return ((ClienteDAO) this.getRepository()).obtenerClientePorUsuarioYPassword(usuario, password);
	}
	
	public Cliente obtenerClientePorUsuario(int usuario) {
		return ((ClienteDAO) this.getRepository()).obtenerClientePorUsuario(usuario);
	}
}
