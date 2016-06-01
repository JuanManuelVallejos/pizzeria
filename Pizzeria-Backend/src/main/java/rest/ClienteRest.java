package rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import exceptions.UsuarioConDNIExistenteException;
import exceptions.UsuarioOPasswordInvalido;
import model.Cliente;
import model.Pedido;
import services.ClienteService;
import services.PedidoService;

@Path("/clientes")
public class ClienteRest {
	
	private ClienteService clienteService;
	private PedidoService pedidoService;
	
	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	public PedidoService getPedidoService() {
		return pedidoService;
	}

	public void setPedidoService(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Cliente> obtenerTodosLosClientes() {
		List<Cliente> clientes = getClienteService().retriveAll();
        return clientes;
	}

	@POST
	@Path("/crear/{nombre}/{apellido}/{direccion}/{dni}/{nroDeCliente}/{password}")
	@Produces("application/json")
	public Response crearCliente(@PathParam("nombre") String nombre, @PathParam("apellido") String apellido,@PathParam("direccion") String direccion,
			@PathParam("dni") Integer dni, @PathParam("nroDeCliente") Integer nroDeCliente, @PathParam("password") String password) throws UsuarioConDNIExistenteException{
		
		Cliente cliente = this.getClienteService().darDeAltaNuevoCliente(nombre, apellido,direccion, dni, nroDeCliente,password);
		this.getClienteService().save(cliente);
		return Response.ok(cliente).build();
	}

	@GET
	@Path("/pedidosActivos/{idCliente}")
	@Produces("application/json")
	public List<Pedido> obtenerPedidosActivos(@PathParam("idCliente") int idCliente) {
		List<Pedido> pedidos = getPedidoService().obtenerPedidosActivos(idCliente);
        return pedidos;
	}
	
	@POST
	@Path("/ingresar/")
	@Produces("application/json")
	public Response ingresar(@FormParam("usuario") Integer usuario, @FormParam("password") String password) {
		Cliente cliente;
		try {
			cliente = getClienteService().obtenerClientePorUsuarioYPassword(usuario, password);
			
			ClassPathResource resource = new ClassPathResource("/META-INF/spring-persistence-context.xml");
			XmlBeanFactory factory = new XmlBeanFactory(resource);
	        PropertyPlaceholderConfigurer ppc = (PropertyPlaceholderConfigurer) factory
	                .getBean("persistence.propertyConfigurer");
	        ppc.postProcessBeanFactory(factory);
	        
	        SessionFactory sessionFactory = (SessionFactory) factory.getBean("persistence.sessionFactory");
	        sessionFactory.getCurrentSession().save(cliente);
	        
		} catch (UsuarioOPasswordInvalido e) {
			return Response.ok(-1).build();
		}
        return Response.ok(cliente).build();
	}
}
