package CourierUI;

import javax.swing.JPanel;
import java.awt.List;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;

public class driverStatusPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public driverStatusPanel() {
		setLayout(null);
		
		JLabel lblDriversAvailability = new JLabel("Drivers Availability");
		lblDriversAvailability.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDriversAvailability.setBounds(162, 20, 160, 16);
		add(lblDriversAvailability);
		
		JLabel label = new JLabel("");
		label.setBounds(93, 69, 61, 23);
		add(label);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Not Available");
		rdbtnNewRadioButton.setBounds(197, 69, 141, 23);
		add(rdbtnNewRadioButton);

	}
}
