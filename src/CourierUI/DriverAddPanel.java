package CourierUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import courierDAO.EM;
import courierPD.ACMECourierCompany;
import courierPD.Driver;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.persistence.EntityTransaction;
import javax.swing.Box;

public class DriverAddPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtCid;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtPno;
	private JTextField txtEmail;

	/**
	 * Create the panel.
	 */
	public DriverAddPanel(JFrame currentFrame,ACMECourierCompany c,Driver driver) {
		//System.out.println("hii add panel");
		EM.getEM().refresh(c);
		setLayout(null);
		
		JLabel lblAddDriver = new JLabel("ADD DRIVER");
		lblAddDriver.setBounds(198, 64, 118, 16);
		add(lblAddDriver);
		
		JLabel lblCourierId = new JLabel("COurier Id:-");
		lblCourierId.setBounds(72, 103, 76, 16);
		add(lblCourierId);
		
		JLabel lblFirstname = new JLabel("FirstName:-");
		lblFirstname.setBounds(87, 141, 61, 16);
		add(lblFirstname);
		
		JLabel lblLastname = new JLabel("LastName:-");
		lblLastname.setBounds(87, 179, 61, 16);
		add(lblLastname);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:-");
		lblPhoneNumber.setBounds(72, 221, 113, 16);
		add(lblPhoneNumber);
		
		JLabel lblEmailId = new JLabel("Email ID:-");
		lblEmailId.setBounds(87, 254, 61, 16);
		add(lblEmailId);
		
		txtCid = new JTextField();
		txtCid.setText(driver.getNumber());
		txtCid.setBounds(192, 93, 130, 26);
		add(txtCid);
		txtCid.setColumns(10);
		
		txtFname = new JTextField();
		txtFname.setText(driver.getName());
		txtFname.setBounds(192, 131, 130, 26);
		add(txtFname);
		txtFname.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setText(driver.getName());
		txtLname.setBounds(192, 169, 130, 26);
		add(txtLname);
		txtLname.setColumns(10);
		
		txtPno = new JTextField();
		txtPno.setText(driver.getPhone());
		txtPno.setBounds(210, 211, 130, 26);
		add(txtPno);
		txtPno.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText(driver.getEmail());
		txtEmail.setBounds(210, 244, 130, 26);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnSave = new JButton("Hire");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if((txtCid.getText()).equals(c.getDrivers().get(txtCid.getText())))
//				{
//					c.removeDriver(driver);
//				}
				EntityTransaction userTransaction = EM.getEM().getTransaction();
				userTransaction.begin();
					driver.setNumber(txtCid.getText());
					driver.setName(txtFname.getText()+txtLname.getText());
					driver.setPhone(txtPno.getText());
					c.addDriver(driver);
					userTransaction.commit();
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new DriverListPanel(currentFrame,c));
					currentFrame.getContentPane().revalidate();
					
			}
		});
		btnSave.setBounds(72, 305, 117, 29);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			currentFrame.getContentPane().removeAll();
			currentFrame.getContentPane().add(new DriverListPanel(currentFrame,c));
			currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(229, 305, 117, 29);
		add(btnCancel);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(53, 46, 1, 1);
		add(verticalBox);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(53, 46, 321, 248);
		add(verticalBox_1);

	}
}
