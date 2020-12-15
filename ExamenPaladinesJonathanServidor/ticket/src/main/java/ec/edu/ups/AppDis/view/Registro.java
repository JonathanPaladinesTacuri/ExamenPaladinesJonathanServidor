package ec.edu.ups.AppDis.view;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpRetryException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.AppDis.dao.on.GestionTicketON;
import ec.edu.ups.AppDis.dao.on.LocalTicket;
import ec.edu.ups.AppDis.model.Ticket;
import ec.edu.ups.AppDis.model.Vehiculo;



@WebServlet("/producto")
public class Registro extends HttpServlet {

	@Inject
	private LocalTicket on;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().println("<h1>Tickets Insertados</h1>");

		Vehiculo vh =new Vehiculo();
		vh.setPlaca("prl734");
		vh.setMarca("Ferrari");
		vh.setModelo("Gtx");
		
		
		Vehiculo vh2 =new Vehiculo();
		vh2.setPlaca("arl555");
		vh2.setMarca("Chevrolet");
		vh2.setModelo("Camaro");

		on.crearVehiculo(vh);
		on.crearVehiculo(vh2);
		
		
		Ticket tc = new Ticket();
		tc.setFechaingreso("12/12/20");
		tc.setAuto(vh);
		
		on.crearTicket(tc);
		
		
		List<Ticket> listaTicket= on.listaTicket();
		for (Ticket ticket : listaTicket) {
			System.out.println("Fecha"+ticket.getFechaingreso());
			System.out.println("Placa"+ticket.getAuto().getPlaca());
			System.out.println("Modelo"+ticket.getAuto().getModelo());
	}
     	Vehiculo vh3 =new Vehiculo();
		vh3.setPlaca("arl555");
		vh3.setMarca("Chevrolet");
		vh3.setModelo("Camaro");

		on.crearVehiculo(vh3);
		
		
	}
}
