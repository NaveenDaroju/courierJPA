package CourierUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.UIManager.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import courierDAO.ACMECourierCompanyDAO;
import courierDAO.CustomerDAO;
import courierDAO.EM;
import courierPD.ACMECourierCompany;
import courierPD.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.persistence.EntityTransaction;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;

	private JPanel contentPane;
	private JTextField usernametxt;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EM.initEM();
		List<ACMECourierCompany> companies = ACMECourierCompanyDAO.listACMECourierCompany();
//		if( leagues.isEmpty() ) {
//			final League league = new League();
//			league.init();
//			leagues = LeagueDAO.listLeague();
//		}
		if( companies.isEmpty() ) {
			final ACMECourierCompany company= new ACMECourierCompany();
			//company.init();
			//company = ACMECourierCompanyDAO.listACMECourierCompany();
			EntityTransaction userTransaction=EM.getEM().getTransaction();
			userTransaction.begin();
			ACMECourierCompanyDAO.saveACMECourierCompany(company);
			userTransaction.commit();
			companies = ACMECourierCompanyDAO.listACMECourierCompany();
				
		}
		final ACMECourierCompany company = companies.get(0);
		LoginFrame frame = new LoginFrame(company);
		
		
		frame.setVisible(true);
		frame.getContentPane().setLayout(new BorderLayout());
	
		
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
								
					
					
//ui
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
//				//	ui
					
				       
				      
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame(ACMECourierCompany company) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setBounds(45, 97, 84, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(45, 155, 97, 16);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblPassword);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(163, 94, 116, 22);
		contentPane.add(usernametxt);
		usernametxt.setColumns(10);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(166, 213, 97, 25);
		btnLogin.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 
				 
				
				  String uname = usernametxt.getText();
				 String pwd = passwordField.getText();

				 
				 if (uname.equals("admin")&& pwd.equals("123")){
					 JOptionPane.showMessageDialog(frame, "Logged in successfully");
					 HomeFrame home = new HomeFrame(company);
					 home.setVisible(true); 
					 
				 }
				 else
				 JOptionPane.showMessageDialog(frame,"Invalid credentials");
				 }
				
				 
				 //Navigate to Home page
				 
			
		});
		contentPane.add(btnLogin);
		
		JLabel lblAcmeCourierServices = new JLabel("ACME Courier Services");
		lblAcmeCourierServices.setBounds(163, 30, 192, 16);
		lblAcmeCourierServices.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblAcmeCourierServices);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 152, 115, 22);
		contentPane.add(passwordField);
		
	}
}
