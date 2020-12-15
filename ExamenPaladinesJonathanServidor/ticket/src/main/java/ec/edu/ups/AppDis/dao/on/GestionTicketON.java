package ec.edu.ups.AppDis.dao.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.AppDis.dao.TicketaDao;
import ec.edu.ups.AppDis.model.Ticket;
import ec.edu.ups.AppDis.model.Vehiculo;

@Stateless
public class GestionTicketON implements LocalTicket,RemoteTicket{

	@Inject
	private TicketaDao tdao;
	
	
	public void crearTicket(Ticket tc) {
		tdao.insterarTicket(tc);
	}
	
	public void crearVehiculo(Vehiculo vh) {
		
		Vehiculo vv =tdao.buscaVehiculo(vh.getPlaca());
		
		if (vv==null) {
			tdao.insterarVehiculo(vh);
		} else {
			System.out.println("Vehiculo ya existente");
		}
	}
	
	public List<Ticket> listaTicket(){
		return tdao.listaTicket();
	}
	
	public Vehiculo buscarVehiculo(String placa) {
		return tdao.buscaVehiculo(placa);
	}
	
}
