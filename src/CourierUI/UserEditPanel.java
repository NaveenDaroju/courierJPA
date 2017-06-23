package CourierUI;

import javax.swing.JPanel;
import courierPD.User;
import courierPD.ACMECourierCompany;
import javax.swing.JLabel;
import javax.swing.JTextField;

import courierDAO.EM;

import javax.persistence.EntityTransaction;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UserEditPanel extends JPanel {
	private static final long serialVersionUID=1L;
	private JTextField textName;
	private JTextField textUname;
	private JTextField password;
	private JTextField role;
	private JTextField email;
	private JTextField phoneno;

	/**
	 * Create the panel.
	 */
	public UserEditPanel(JFrame currentFrame,User user,ACMECourierCompany c) {
		EM.getEM().refresh(c);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(16, 76, 61, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setBounds(16, 114, 61, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setBounds(16, 152, 61, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("role");
		lblNewLabel_3.setBounds(16, 190, 61, 16);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("email");
		lblNewLabel_4.setBounds(16, 227, 61, 16);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("phone no");
		lblNewLabel_5.setBounds(16, 255, 61, 16);
		add(lblNewLabel_5);
		
		JLabel lblUsersWindow = new JLabel("USERS WINDOW");
		lblUsersWindow.setBounds(163, 31, 98, 16);
		add(lblUsersWindow);
		
		textName = new JTextField(user.getName());
		textName.setBounds(112, 71, 130, 26);
		add(textName);
		textName.setColumns(10);
		
		textUname = new JTextField(user.getUsername());
		textUname.setBounds(112, 109, 130, 26);
		add(textUname);
		textUname.setColumns(10);
		
		password = new JTextField(user.getPassword());
		password.setBounds(112, 147, 130, 26);
		add(password);
		password.setColumns(10);
		
		role = new JTextField(user.getUserRole());
		role.setBounds(112, 185, 130, 26);
		add(role);
		role.setColumns(10);
		
		email = new JTextField(user.getEmail());
		email.setBounds(112, 223, 130, 26);
		add(email);
		email.setColumns(10);
		
		phoneno = new JTextField(user.getNumber());
		phoneno.setBounds(112, 250, 130, 26);
		add(phoneno);
		phoneno.setColumns(10);
		
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntityTransaction userTransaction=EM.getEM().getTransaction();
				userTransaction.begin();
				user.setName(textName.getText());
				user.setEmail(email.getText());
				user.setUsername(textUname.getText());
				user.setNumber(phoneno.getText());
				user.setPassword(password.getText());
				user.setUserRole(role.getText());
				c.addUser(user);
				userTransaction.commit();
				UserListPanel n=new UserListPanel(currentFrame,c);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(n);
				currentFrame.getContentPane().revalidate();
				
				
			}
		});
		btnNewButton.setBounds(49, 317, 117, 29);
		add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserListPanel n=new UserListPanel(currentFrame,c);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(n);
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(231, 317, 117, 29);
		add(btnCancel);

	}
}
