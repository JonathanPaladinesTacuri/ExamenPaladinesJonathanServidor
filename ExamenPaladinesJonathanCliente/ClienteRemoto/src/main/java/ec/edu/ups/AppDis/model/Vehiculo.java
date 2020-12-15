package ec.edu.ups.AppDis.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



public class Vehiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8723469368323074996L;


	private String placa;
	
	
	private int idauto;
	
	private String marca;
	private String modelo;
	
	
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
