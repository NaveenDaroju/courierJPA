package CourierUI;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

import courierDAO.EM;
import courierPD.ACMECourierCompany;
import courierPD.Customer;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.persistence.EntityTransaction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;

public class CustomerListPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
public JList<Customer> list;
private DefaultListModel<Customer> dList;

	JButton btnEdit;
	JButton btnDelete ;
	public CustomerListPanel(JFrame currentFrame, ACMECourierCompany company){
		EM.getEM().refresh(company);
		setLayout(null);
		
		JLabel lblCustomersList = new JLabel("Customers List");
		dList= new DefaultListModel<Customer>();

		for(Customer customerEntry : company.getCustomers())
		{
			dList.addElement(customerEntry);
			
		}

		lblCustomersList.setBounds(184, 41, 164, 16);
		add(lblCustomersList);
		
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     Customer customer = new Customer();
	            currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CustomerEditPanel(currentFrame,new Customer(),company));
			     currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(77, 325, 97, 25);
		add(btnAdd);
		
		 btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ACMECourierCompany company=new ACMECourierCompany();
				//CustomerEditPanel customeEditPanel=);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CustomerEditPanel(currentFrame,(Customer)list.getSelectedValue(),company)); 
				currentFrame.revalidate();
			}
		});
		btnEdit.setBounds(412, 325, 97, 25);
		btnEdit.setEnabled(false);
		add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				company.removeCustomer((Customer)list.getSelectedValue());
//				dList.removeElement(list.getSelectedValue());
			EntityTransaction userTransaction = EM.getEM().getTransaction();
			userTransaction.begin();
			company.removeCustomer((Customer)list.getSelectedValue());
			userTransaction.commit();
			
			
			}
		});
		btnDelete.setBounds(235, 325, 97, 25);
		btnDelete.setEnabled(false);
		add(btnDelete);
		list = new JList(dList);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedValue()!=null)
				{
					btnEdit.setEnabled(true);
					btnDelete.setEnabled(true);
				}
			}
		});
	
		list.setBounds(47, 69, 397, 214);
     	add(list);
	}
}
