package courierPD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Customer")
public class Customer implements  Serializable{
	private static final long serialVersionUID=1L;
	
	@Id
	@Column(name = "Customer_id",nullable=false)
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long cuID;
	public long getCuID() {
		return cuID;
	}



	public void setCuID(long cuID) {
		this.cuID = cuID;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@ManyToOne(optional=false)
	@JoinColumn(name="ACMECourierCompany_ID",referencedColumnName="ACMECourierCompany_ID")
	private ACMECourierCompany company;
	/**
	 * it is defined as the name of the customer.
	 */
	@Column(name="c_name",nullable=false,length=50)
	private String name;
	/**
	 * it is defined as the street and avenue of the customer.
	 */
	@Column(name="c_address",nullable=false,length=50)
	private String address;
	/**
	 * it is defined as the number of the customer.
	 */
	@Column(name="c_number",nullable=false,length=50)
	private String number;
	/**
	 * it is defined as the email of the customer.
	 */
	@Column(name="c_email",nullable=false,length=50)
	private String email;
	private Customer customer;
	
	public Customer(){
		
	}
	
	

	public ACMECourierCompany getCompany() {
		return company;
	}
	public void setCompany(ACMECourierCompany company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer getCustomer()
	{
		return customer;
	}
	public String toString()
	{
		return getNumber()+" 	"+getName();
	}
	

}