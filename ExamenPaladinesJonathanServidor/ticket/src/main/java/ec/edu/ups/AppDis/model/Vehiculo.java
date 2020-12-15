package ec.edu.ups.AppDis.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Vehiculo {

	@Id
	private String placa;
	
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idauto;
	
	private String marca;
	private String modelo;
	
	
	@OneToMany(mappedBy = "auto",fetch = FetchType.EAGER)
	private List<Ticket>ticket;


	public int getIdauto() {
		return idauto;
	}


	public void setIdauto(int idauto) {
		this.idauto = idauto;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public List<Ticket> getTicket() {
		return ticket;
	}


	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}
	
	
}
