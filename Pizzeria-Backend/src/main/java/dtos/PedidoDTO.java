package dtos;

public class PedidoDTO {

	private int idPedido;
	private String realizado;
	private int importe = 0;
	private String direccion;
	private int idCliente;
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String isRealizado() {
		return realizado;
	}
	public void setRealizado(String realizado) {
		this.realizado = realizado;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getImporte() {
		return importe;
	}
	public void setImporte(int importe) {
		this.importe = importe;
	}
	public void seatearRealizado(boolean seRealizo) {
		
		if(seRealizo){
			this.setRealizado("Si");
		}else{
			this.setRealizado("No");
		}
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
