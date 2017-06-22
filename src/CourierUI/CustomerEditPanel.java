package CourierUI;

import javax.swing.JPanel;

import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JTextField;

import courierDAO.EM;
import courierPD.ACMECourierCompany;
import courierPD.Customer;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.persistence.EntityTransaction;
import javax.swing.Box; 

public class CustomerEditPanel extends JPanel
{
	private static final long serialVersionUID=1L;
	private JTextField txtCustomerno;
	private JTextField txtName;
	private JTextField textEmailID;
	private JTextField textLocation;

	/**
	 * Create the panel.
	 */
	public CustomerEditPanel(JFrame currentFrame, Customer customer,ACMECourierCompany company) {
		EM.getEM().refresh(company);
		
		setLayout(null);
		System.out.println("hello na");
		
		JLabel lblCustomerEdit = new JLabel("Customer Edit");
		lblCustomerEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerEdit.setBounds(206, 38, 138, 16);
		add(lblCustomerEdit);
		
		JLabel lblCustomerNo = new JLabel("Customer No:");
		lblCustomerNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCustomerNo.setBounds(85, 108, 105, 16);
		add(lblCustomerNo);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(85, 150, 56, 16);
		add(lblName);
		
		JLabel lblEmailId = new JLabel("Email ID:");
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmailId.setBounds(85, 192, 56, 16);
		add(lblEmailId);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLocation.setBounds(85, 236, 56, 16);
		add(lblLocation);
		
		txtCustomerno = new JTextField(customer.getNumber());
		txtCustomerno.setBounds(215, 105, 116, 22);
		add(txtCustomerno);
		txtCustomerno.setColumns(10);
		
		txtName = new JTextField(customer.getName());
		txtName.setBounds(215, 147, 116, 22);
		add(txtName);
		txtName.setColumns(10);
		
		textEmailID = new JTextField(customer.getEmail());
		textEmailID.setBounds(215, 189, 116, 22);
		add(textEmailID);
		textEmailID.setColumns(10);
		
		textLocation = new JTextField(customer.getAddress());
		textLocation.setBounds(215, 233, 116, 22);
		add(textLocation);
		textLocation.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntityTransaction userTransaction=EM.getEM().getTransaction();
				userTransaction.begin();
				
				customer.setNumber(txtCustomerno.getText());
		        
		        
		        //On Save- get values from the text fields and save
		        customer.setName(txtName.getText());
		        customer.setAddress(textLocation.getText());
		        customer.setEmail(textEmailID.getText());
		        company.addCustomer(customer);
		        userTransaction.commit();
		        
		        currentFrame.getContentPane().removeAll();
		        currentFrame.getContentPane().add(new CustomerListPanel(currentFrame,company));
		        currentFrame.getContentPane().revalidate();	      
			}
		});
		btnSave.setBounds(117, 303, 97, 25);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerListPanel customerListPanel = new CustomerListPanel(currentFrame,company);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(customerListPanel);
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(267, 303, 97, 25);
		add(btnCancel);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(35, 27, 371, 267);
		add(verticalBox);

	}
}
