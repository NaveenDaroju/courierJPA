package courierPD;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity(name="Driver")
public class Driver implements  Serializable{
	private static final long serialVersionUID=1L;
	

	@Id
	@Column(name = "Driver_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long DriverId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="ACMECourierCompany_ID",referencedColumnName="ACMECourierCompany_ID")
	ACMECourierCompany company;
	
	private Collection<DeliveryTicket> DeliveryTicket;
	/**
	 * it is defined as the name of the driver.
	 */
	@Column(name="driver_name", nullable=false, length=50)

	private String name;
	/**
	 * it is defines the number of the driver.
	 */
	@Column(name="driver_num", nullable=false, length=50)

	private String number;
	
	public ACMECourierCompany getCompany() {
		return company;
	}

	public void setCompany(ACMECourierCompany company) {
	this.company = company;
	}

	public Collection<DeliveryTicket> getDeliveryTicket() {
		return DeliveryTicket;
	}

	public void setDeliveryTicket(Collection<DeliveryTicket> deliveryTicket) {
		DeliveryTicket = deliveryTicket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * it is defines the phone number of the driver.
	 */
	private String phone;
	/**
	 * it is defines the email of the driver.
	 */
	private String email;

	private boolean status;
	public Driver()
	{

	}
	
	public Driver(String name, String phone, int number, String email){
		
	}

	/**
	 * it is defines the pickup package.
	 */
	public void pickup() {
		// TODO - implement Driver.pickup
		throw new UnsupportedOperationException();
	}

	/**
	 * it is defines the delivery of package.
	 */
	public void deivery() {
		// TODO - implement Driver.deivery
		throw new UnsupportedOperationException();
	}

	/**
	 * it is defines the driver submit reports to the user.
	 */
	public void submit() {
		// TODO - implement Driver.submit
		throw new UnsupportedOperationException();
	}
	public String toString()
	{
		return getNumber()+" 	"+getName();	
	}

	public boolean getStatus() {
		return false;
	}
	public void setStatus(boolean status){
		this.status=status;
	}
}