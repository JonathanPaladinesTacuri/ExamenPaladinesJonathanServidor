package ec.edu.ups.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.AppDis.dao.on.RemoteTicket;
import ec.edu.ups.AppDis.model.Ticket;
import ec.edu.ups.AppDis.model.Vehiculo;
import ec.edu.ups.main.Main;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;

public class MainT extends JFrame {

	private JPanel contentPane;
	private JTextField txtfecha;
	private JTextField txtplaca;
	private JButton btnNewButton;
	
	public static  Main mn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainT frame = new MainT();
					frame.setVisible(true);
					 mn = new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
public RemoteTicket demoEJB;
	
	public void intanciarRemoto() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb01");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejb01");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/ticket/GestionTicketON!ec.edu.ups.AppDis.dao.on.RemoteTicket";  
              
            this.demoEJB = (RemoteTicket) context.lookup(lookupName);  
              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}

	/**
	 * Create the frame.
	 */
	public MainT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fecha de Ingreso");
		lblNewLabel.setBounds(10, 11, 86, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vehiculo_Placa");
		lblNewLabel_1.setBounds(10, 44, 86, 27);
		contentPane.add(lblNewLabel_1);
		
		txtfecha = new JTextField();
		txtfecha.setBounds(172, 12, 143, 21);
		contentPane.add(txtfecha);
		txtfecha.setColumns(10);
		
		txtplaca = new JTextField();
		txtplaca.setBounds(172, 47, 143, 24);
		contentPane.add(txtplaca);
		txtplaca.setColumns(10);
		
		btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(txtplaca.getText());
				Vehiculo vh=mn.remoto.buscarVehiculo(txtplaca.getText());
				
			//	System.out.println(vh.getModelo());
				Vehiculo vv= new Vehiculo();
				
//				vv.setMarca(vh.getMarca());
//				vv.setModelo(vh.getModelo());
				vv.setPlaca(txtplaca.getText());
//				
				Ticket tc= new Ticket();
				tc.setFechaingreso(txtfecha.getText());
				tc.setAuto(vh);
					
				demoEJB.crearTicket(tc);
					System.out.println("Se ingreso el ticket");
				
				
							}
		});
		btnNewButton.setBounds(121, 149, 121, 38);
		contentPane.add(btnNewButton);
	}
}
