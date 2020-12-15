package ec.edu.ups.AppDis.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idticket;
	
	private String fechaingreso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "placa")
	private Vehiculo auto;

	public int getIdticket() {
		return idticket;
	}

	public void setIdticket(int idticket) {
		this.idticket = idticket;
	}

	public String getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(String fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Vehiculo getAuto() {
		return auto;
	}

	public void setAuto(Vehiculo auto) {
		this.auto = auto;
	}
	
	
	
}
