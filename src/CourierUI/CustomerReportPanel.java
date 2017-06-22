package CourierUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerReportPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public CustomerReportPanel() {
		setLayout(null);
		
		JLabel lblCustomerInvoiceReport = new JLabel("Customer Invoice Report");
		lblCustomerInvoiceReport.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblCustomerInvoiceReport.setBounds(119, 31, 234, 24);
		add(lblCustomerInvoiceReport);
		
		JLabel lblFromDate = new JLabel("From Date:");
		lblFromDate.setBounds(26, 88, 65, 16);
		add(lblFromDate);
		
		textField = new JTextField();
		textField.setBounds(96, 85, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblToDate = new JLabel("To Date:");
		lblToDate.setBounds(224, 88, 56, 16);
		add(lblToDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(292, 85, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		JList list = new JList();
		list.setBounds(96, 138, 244, 91);
		add(list);
		
		JButton btnSendEmail = new JButton("Send Email");
		btnSendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSendEmail.setBounds(84, 262, 97, 25);
		add(btnSendEmail);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrint.setBounds(243, 262, 97, 25);
		add(btnPrint);

	}

}