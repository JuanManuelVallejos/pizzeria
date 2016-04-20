package services;

import dtos.PromocionDTO;
import model.Promocion;

public class PromocionService extends GenericService<Promocion> {

	private static final long serialVersionUID = 7810311595651598047L;

	public PromocionDTO convertProductoADTO(Promocion promocion){
		PromocionDTO promocionDTO = new PromocionDTO();
		promocionDTO.setIdPromocion(promocion.getId());
		promocionDTO.setNombre(promocion.getNombre());
		promocionDTO.setProductos(promocion.getProductos());

		return promocionDTO;
	}
}
