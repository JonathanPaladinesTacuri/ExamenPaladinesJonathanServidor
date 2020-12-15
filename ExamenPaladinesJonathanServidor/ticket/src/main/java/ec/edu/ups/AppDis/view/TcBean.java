package ec.edu.ups.AppDis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.AppDis.dao.on.LocalTicket;

import ec.edu.ups.AppDis.model.Ticket;


@ManagedBean
@ViewScoped
public class TcBean {
	
	@Inject
	private LocalTicket on;
	
	

	
	private List<Ticket> listat;
	
	
	
	

	public List<Ticket> getListat() {
		return listat;
	}

	public void setListat(List<Ticket> listat) {
		this.listat = listat;
	}

	@PostConstruct
	public void init() {
	
		
		ListarTicket();
	}
	
	public void ListarTicket() {
		listat =on.listaTicket();
	}

	
	
	
}
