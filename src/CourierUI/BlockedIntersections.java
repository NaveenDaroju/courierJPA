package CourierUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BlockedIntersections extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public BlockedIntersections() {
		setLayout(null);
		
		JLabel lblBlockedIntersections = new JLabel("Blocked Intersections");
		lblBlockedIntersections.setBounds(117, 31, 56, 16);
		add(lblBlockedIntersections);
		
		JLabel lblSource = new JLabel("Source:");
		lblSource.setBounds(33, 74, 56, 16);
		add(lblSource);
		
		textField = new JTextField();
		textField.setBounds(127, 71, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setBounds(33, 130, 56, 16);
		add(lblDestination);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 127, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(76, 201, 97, 25);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(217, 201, 97, 25);
		add(btnCancel);

	}
}
