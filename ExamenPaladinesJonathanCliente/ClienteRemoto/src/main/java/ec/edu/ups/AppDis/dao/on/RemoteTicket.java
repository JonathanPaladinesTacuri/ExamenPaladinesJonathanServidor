package ec.edu.ups.AppDis.dao.on;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.AppDis.model.Ticket;
import ec.edu.ups.AppDis.model.Vehiculo;


public interface RemoteTicket {

public void crearTicket(Ticket tc);
	
	public void crearVehiculo(Vehiculo vh) ;
	
	public List<Ticket> listaTicket();
	
	public Vehiculo buscarVehiculo(String placa) ;
}
