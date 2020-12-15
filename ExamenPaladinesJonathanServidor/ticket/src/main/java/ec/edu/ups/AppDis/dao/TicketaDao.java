package ec.edu.ups.AppDis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.AppDis.model.Ticket;
import ec.edu.ups.AppDis.model.Vehiculo;


@Stateless
public class TicketaDao {


	@PersistenceContext
	private EntityManager em;
	
	public void insterarTicket(Ticket tc) {
		em.persist(tc);
		
	}
	
	
	public void insterarVehiculo(Vehiculo vc) {
		em.persist(vc);
		
	}
	
	
	public List<Ticket> listaTicket(){
		String jpql = "SELECT p FROM Ticket p";
		
		Query q = em.createQuery(jpql, Ticket.class);
		
		return q.getResultList();
	}
	
	
	public Vehiculo buscaVehiculo(String placa) {
		String jpql = "SELECT p FROM Vehiculo p";
		
		return em.find(Vehiculo.class, placa);
	}
	
	
	
	
	
	
}
