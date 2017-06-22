package CourierUI;

import javax.swing.JPanel;

import courierPD.ACMECourierCompany;
import courierPD.Driver;
import courierPD.User;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.persistence.EntityTransaction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;

import courierDAO.EM;

import javax.swing.event.ListSelectionEvent;

public class UserListPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	JButton button;
	JButton btnNewButton;
	JButton btnDelete;
	private DefaultListModel<User> dList;
	public UserListPanel(JFrame currentFrame,ACMECourierCompany company) {
		EM.getEM().refresh(company);
		setLayout(null);
		
		JLabel lblUsersWindow = new JLabel("Users Window");
		lblUsersWindow.setBounds(179, 30, 88, 16);
		add(lblUsersWindow);
		
		dList=new DefaultListModel<User>();
		Collection userList = company.getUsers();
		if (userList != null) 
			for(User userEntry : company.getUsers())
				dList.addElement(userEntry);
				
		JList<User> list = new JList<User>(dList);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedValue()!=null)
				{
					button.setEnabled(true);
					btnNewButton.setEnabled(true);
				}
			}
		});
		list.setBounds(58, 67, 367, 259);
		add(list);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User n=new User();
				UserEditPanel ne=new UserEditPanel(currentFrame,n,company);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(ne);
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(437, 76, 117, 29);
		add(btnNewButton);
		
		button = new JButton("Edit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserEditPanel n=new UserEditPanel(currentFrame,(User)list.getSelectedValue(),company);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(n);
				currentFrame.getContentPane().revalidate();
			}
		});
		button.setBounds(437, 159, 117, 29);
		button.setEnabled(false);
		add(button);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//			c.removeUser((User)list.getSelectedValue());
//			dList.removeElement(list.getSelectedValue());
				EntityTransaction userTransaction=EM.getEM().getTransaction();
				userTransaction.begin();
				company.removeUser((User)list.getSelectedValue());
				userTransaction.commit();
			}
		});
		btnDelete.setBounds(437, 238, 117, 29);
		btnDelete.setEnabled(false);
		add(btnDelete);

	}
}
