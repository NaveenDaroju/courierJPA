package CourierUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import courierPD.ACMECourierCompany;
import courierPD.Customer;
import courierPD.DeliveryTicket;
import courierPD.User;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map.Entry;
import java.util.Date;
import java.time.LocalTime;

import javax.swing.JRadioButton;

public class DeliveryTicketEditPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField t_pick_c_no;
	private JTextField t_pick_c_name;
	private JTextField t_pickTime;
	private JTextField t_id;
	private JTextField t_est_dtime;
	private JTextField t_blocks;
	private JTextField t_quoted_price;
	private JTextField t_delivery_c_no;
	private JTextField t_deliver_c_name;
	private JTextField t_assign_time;
	private JTextField t_actual_pick_time;
	private JTextField t_actual_dtime;
	private JTextField t_bonus;

	/**
	 * Create the panel.
	 */
	public DeliveryTicketEditPanel(JFrame f,ACMECourierCompany c) {
		
		setLayout(null);
		DeliveryTicket o=new DeliveryTicket();
		JLabel lblDelievryTicket = new JLabel("Delievry Ticket");
		lblDelievryTicket.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDelievryTicket.setBounds(384, 0, 184, 29);
		add(lblDelievryTicket);
		
		JLabel lblOrderTakenBy = new JLabel("Order taken by:");
		lblOrderTakenBy.setBounds(30, 81, 102, 16);
		add(lblOrderTakenBy);
		
		JLabel lblDate = new JLabel("Date:");
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date k=new Date();
		SimpleDateFormat h=new SimpleDateFormat("yyyy.MM.dd");
		String C_dateStamp = h.format(k);
		o.setTi_date(k);
		
		//LocalDate de = LocalDate.now();
		//String n=dateFormat.format(de);
		//System.out.println(n);
		lblDate.setText(C_dateStamp);
		
		
		//o.setTi_date(de);
		lblDate.setBounds(326, 81, 114, 16);
		add(lblDate);
		
		JLabel lblTime = new JLabel("Time:");
		String C_timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		
		//LocalTime time = LocalTime.now();
		//String tim=timeFormat.format(time);
		lblTime.setText(C_timeStamp);
		//o.setTi_time(C_timeStamp);
		//System.out.println(time);
		lblTime.setBounds(615, 81, 56, 16);
		add(lblTime);
		
		JLabel lblPickUpInfo = new JLabel("Pick up info:");
		lblPickUpInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPickUpInfo.setBounds(95, 133, 116, 16);
		add(lblPickUpInfo);
		
		JLabel lblDelievryInfo = new JLabel("Delievry Info:");
		lblDelievryInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDelievryInfo.setBounds(406, 133, 147, 16);
		add(lblDelievryInfo);
		
		JLabel lblPickupCustomerNumebr = new JLabel("Pickup Customer Number:");
		lblPickupCustomerNumebr.setBounds(12, 176, 161, 16);
		add(lblPickupCustomerNumebr);
		
		t_pick_c_no = new JTextField();
//		t_pick_c_no.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Customer pickcus=(c.getCustomers());
//				t_pick_c_no.setText(pickcus.getName());	
//				o.setPickupCustomer(pickcus);
//				
//			}
//		});
		t_pick_c_no.setBounds(193, 173, 116, 22);
		add(t_pick_c_no);
		t_pick_c_no.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setBounds(59, 222, 107, 16);
		add(lblCustomerName);
		
		t_pick_c_name = new JTextField();
//		t_pick_c_name.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
		t_pick_c_name.setBounds(193, 219, 116, 22);
		add(t_pick_c_name);
		t_pick_c_name.setColumns(10);
		
		JLabel lblPickupTime = new JLabel("Pickup Time:");
		lblPickupTime.setBounds(87, 257, 86, 16);
		add(lblPickupTime);
		
		t_pickTime = new JTextField();
		t_pickTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pickTime=t_pickTime.getText();
				DateFormat df=new SimpleDateFormat("hh:mm:ss");
				Date d;
				try {
					d = df.parse(pickTime);
					df.format(d);
					System.out.println(df.format(d));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		t_pickTime.setBounds(193, 254, 116, 22);
		add(t_pickTime);
		t_pickTime.setColumns(10);
		
		JLabel lblTicketInfo = new JLabel("Ticket Info:");
		lblTicketInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTicketInfo.setBounds(84, 325, 102, 16);
		add(lblTicketInfo);
		
		JLabel lblPackageId = new JLabel("Ticket ID/Package ID");
		lblPackageId.setBounds(77, 371, 96, 16);
		add(lblPackageId);
		
		t_id = new JTextField();
		t_id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			t_id.setText(new DeliveryTicket().genPackagenumber());
			}
		});
		t_id.setBounds(193, 368, 116, 22);
		add(t_id);
		t_id.setColumns(10);
		
		JLabel lblEstimatedDelivery = new JLabel("Estimated Delivery Time:");
		lblEstimatedDelivery.setBounds(23, 412, 150, 16);
		add(lblEstimatedDelivery);
		
		t_est_dtime = new JTextField();
		t_est_dtime.setBounds(193, 409, 116, 22);
		add(t_est_dtime);
		t_est_dtime.setColumns(10);
		
		JLabel lblEstimatedBlocks = new JLabel("Estimated Blocks:");
		lblEstimatedBlocks.setBounds(53, 444, 120, 16);
		add(lblEstimatedBlocks);
		
		t_blocks = new JTextField();
		t_blocks.setBounds(193, 441, 116, 22);
		add(t_blocks);
		t_blocks.setColumns(10);
		
		JLabel lblQuotedPrice = new JLabel("Quoted Price:");
		lblQuotedPrice.setBounds(84, 491, 78, 16);
		add(lblQuotedPrice);
		
		t_quoted_price = new JTextField();
		t_quoted_price.setBounds(193, 488, 116, 22);
		add(t_quoted_price);
		t_quoted_price.setColumns(10);
		
		JLabel lblDeliveryCustomerNumber = new JLabel("Delivery Customer Number:");
		lblDeliveryCustomerNumber.setBounds(392, 176, 161, 16);
		add(lblDeliveryCustomerNumber);
		
		t_delivery_c_no = new JTextField();
		t_delivery_c_no.setBounds(580, 173, 116, 22);
		add(t_delivery_c_no);
		t_delivery_c_no.setColumns(10);
		
		JLabel lblCustomerName_1 = new JLabel("Customer Name:");
		lblCustomerName_1.setBounds(450, 223, 103, 16);
		add(lblCustomerName_1);
		
		t_deliver_c_name = new JTextField();
		t_deliver_c_name.setBounds(580, 217, 116, 22);
		add(t_deliver_c_name);
		t_deliver_c_name.setColumns(10);
		
		JLabel lblDeliveryInfo = new JLabel("Delivery Info:");
		lblDeliveryInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDeliveryInfo.setBounds(505, 308, 131, 16);
		add(lblDeliveryInfo);
		
		JLabel lblCourierNo = new JLabel("Courier No:");
		lblCourierNo.setBounds(466, 354, 102, 16);
		add(lblCourierNo);
		
		JLabel lblAssignedTime = new JLabel("Assigned Time:");
		lblAssignedTime.setBounds(446, 389, 92, 16);
		add(lblAssignedTime);
		
		t_assign_time = new JTextField();
		t_assign_time.setBounds(580, 386, 116, 22);
		add(t_assign_time);
		t_assign_time.setColumns(10);
		
		JLabel lblPickedupTime = new JLabel("Pickedup Time:");
		lblPickedupTime.setBounds(450, 444, 92, 16);
		add(lblPickedupTime);
		
		JLabel lblDeliverdTime = new JLabel("Deliverd Time:");
		lblDeliverdTime.setBounds(450, 491, 103, 16);
		add(lblDeliverdTime);
		
		t_actual_pick_time = new JTextField();
		t_actual_pick_time.setBounds(580, 441, 116, 22);
		add(t_actual_pick_time);
		t_actual_pick_time.setColumns(10);
		
		t_actual_dtime = new JTextField();
		t_actual_dtime.setBounds(580, 476, 116, 22);
		add(t_actual_dtime);
		t_actual_dtime.setColumns(10);
		
		JLabel lblBonus = new JLabel("Bonus:");
		lblBonus.setBounds(497, 532, 56, 16);
		add(lblBonus);
		
		t_bonus = new JTextField();
		t_bonus.setBounds(580, 529, 116, 22);
		add(t_bonus);
		t_bonus.setColumns(10);
		
		JComboBox t_user = new JComboBox();
		
		for(User userEntry:c.getUsers())
		{
			t_user.addItem(userEntry);
		}
		t_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o.setAssignedUser((User)t_user.getSelectedItem());
			}
		});
		t_user.setBounds(135, 78, 122, 22);
		add(t_user);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(361, 635, 97, 25);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(595, 635, 97, 25);
		add(btnCancel);
		
		JButton btnGeneraeteDirections = new JButton("Generaete Directions");
		btnGeneraeteDirections.setBounds(40, 635, 181, 25);
		add(btnGeneraeteDirections);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(580, 351, 116, 22);
		add(comboBox_1);
		
		JLabel t_date = new JLabel("");
		t_date.setBounds(384, 81, 56, 16);
		add(t_date);
		
		JLabel t_time = new JLabel("");
		t_time.setBounds(685, 81, 56, 16);
		add(t_time);
		
		JRadioButton rdbtnBillToCustomer = new JRadioButton("bill to pickup customer");
		rdbtnBillToCustomer.setBounds(140, 291, 127, 25);
		add(rdbtnBillToCustomer);
		
		JRadioButton rdbtnBillToDelivery = new JRadioButton("bill to delivery customer");
		rdbtnBillToDelivery.setBounds(344, 291, 127, 25);
		add(rdbtnBillToDelivery);

	}
}
