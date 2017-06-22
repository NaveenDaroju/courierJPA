package CourierUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import CourierUI.CustomerListPanel;
import courierPD.ACMECourierCompany;
import courierPD.Customer;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class HomeFrame extends JFrame {
	//private static final long serialVersionUID = 1L;
	
	private JFrame currentFrame;

	/**
	 * Launch the application.
	 */
	public void run(ACMECourierCompany company) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					try {
//					    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//					        if ("Nimbus".equals(info.getName())) {
//					            UIManager.setLookAndFeel(info.getClassName());
//					            break;
//					        }
//					    }
//					} catch (Exception e) {
//					    // If Nimbus is not available, you can set the GUI to another look and feel.
//					}
					
					HomeFrame frame = new HomeFrame(company);
					
					frame.setVisible(true);
					  frame.setSize(600,600);
					
				        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        frame.setTitle("ACME COURIER SERVICES LOGIN");
				        
				        frame.getContentPane().setLayout(new BorderLayout());

				        //frame.setContentPane(new Paneel());
				        frame.pack(); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public HomeFrame(ACMECourierCompany company) {
	
		
		currentFrame=this;
		System.out.println("in frame home frame");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 672);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDeliveryTicket = new JMenu("Delivery Ticket Management");
		menuBar.add(mnDeliveryTicket);
		
		JMenuItem mntmDeliveryTicket = new JMenuItem("New Delivery Ticket");
		mntmDeliveryTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliveryTicketEditPanel ticket=new DeliveryTicketEditPanel(currentFrame,company);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(ticket);
				currentFrame.getContentPane().revalidate();
			}
		});
		
		JMenuItem mntmDeliveryTickets = new JMenuItem("Delivery Tickets");
		mnDeliveryTicket.add(mntmDeliveryTickets);
		mnDeliveryTicket.add(mntmDeliveryTicket);
		
		JMenu mnNewMenu = new JMenu("City Map");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Manage Users");
	menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmManageUsers = new JMenuItem("Manage Users");
		mntmManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserListPanel ul=new UserListPanel(currentFrame,company);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(ul);
				currentFrame.getContentPane().revalidate();
			}
		});
		mnNewMenu_1.add(mntmManageUsers);
		
		JMenu mnDriverDetails = new JMenu("Driver Details");
		menuBar.add(mnDriverDetails);
		
		JMenuItem mntmDriversList = new JMenuItem("Driv List");
		mntmDriversList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverListPanel dlp=new DriverListPanel(currentFrame,company);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(dlp);
				currentFrame.getContentPane().revalidate();
		
			}
		});
		mnDriverDetails.add(mntmDriversList);
		
		JMenuItem mntmDriversAvailability = new JMenuItem("Driver's Availability");
		mnDriverDetails.add(mntmDriversAvailability);
		
		JMenu mnNewMenu_2 = new JMenu("Customer Details");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmCustomerList = new JMenuItem("Customer List");
		mntmCustomerList.addActionListener(new ActionListener() {
			
			//CustomerListPanel customerlist = ;
			public void actionPerformed(ActionEvent arg0) {
				
//				currentFrame.setContentPane(customerlist);
//				customerlist.setBorder(new EmptyBorder(5,5,5,5));
//				customerlist.setLayout(new BorderLayout(0,0));
//				currentFrame.pack();
//				currentFrame.setLocationRelativeTo(null);
//				currentFrame.setVisible(true);
				
				
				getContentPane().removeAll();
				getContentPane().add(new CustomerListPanel(currentFrame, company));
				getContentPane().revalidate();
				
			}
		});
		
		
		mnNewMenu_2.add(mntmCustomerList);
		
		JMenu mnReports = new JMenu("Reports");
		menuBar.add(mnReports);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Reports Selection");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				CustomerReportPanel crp=new CustomerReportPanel();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(crp);
				currentFrame.getContentPane().revalidate();
				
			}
		});
		mnReports.add(mntmNewMenuItem);
		
		JMenu mnLogout = new JMenu("Logout");
		menuBar.add(mnLogout);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JOptionPane.showMessageDialog(currentFrame,"Logged out");
			}
		});
		mnLogout.add(mntmLogOut);
		//getContentPane().setLayout(null);
		//getContentPane().setLayout(null);
		
		JLabel lblWelcomeToAcme = new JLabel("Welcome to ACME Courier Service");
		lblWelcomeToAcme.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcomeToAcme.setBounds(0, 0, 767, 339);
		getContentPane().add(lblWelcomeToAcme);
		//currentFrame.pack();
	}
}
