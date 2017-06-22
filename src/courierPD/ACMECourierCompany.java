package courierPD;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import courierDAO.ACMECourierCompanyDAO;
import courierDAO.CustomerDAO;
import courierDAO.DriverDAO;
import courierDAO.UserDAO;
@Entity(name = "ACMECourierCompany")
public class ACMECourierCompany implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id //signifies the primary key
    @Column(name = "ACMECourierCompany_ID", nullable = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long compID;

	@OneToMany(mappedBy="company",targetEntity=Customer.class,fetch=FetchType.EAGER)
	private  Collection<Customer> customers;
	
	@OneToMany(mappedBy="company",targetEntity=User.class,fetch=FetchType.EAGER)
	private  Collection<User> users;
	
	@OneToMany(mappedBy="company",targetEntity=DeliveryTicket.class,fetch=FetchType.EAGER)
	private Collection<DeliveryTicket> deliveryTickets;
	
	@OneToMany(mappedBy="company",targetEntity=Driver.class,fetch=FetchType.EAGER)
	private  Collection<Driver> drivers;
	
	@OneToMany(mappedBy="company",targetEntity=Map.class,fetch=FetchType.EAGER)
	private Collection<Map> Map;
	
	/**
	 * it is defines the name of the company
	 */
	@Column(name="name",length=50)
	private String name;
	/**
	 * it defines street of the company
	 */
	@Column(name="street",nullable=true,length=50)
	private String street;
	/**
	 * it is defines the minimum price of the package or order.
	 */
	@Column(name="minPrice",nullable=true,length=50)
	private int minPrice;
	/**
	 * it is defines avenue of the company
	 */
	@Column(name="avenue",nullable=true,length=50)
	private String avenue;
	/**
	 * it is defines the amount or bill of the package
	 */
	@Column(name="fixedBillAmount",nullable=true,length=50)
	private int fixedBillAmount;
	/**
	 * it is defines the price per each block.
	 */
	@Column(name="pricePerBlock",nullable=true,length=50)
	private int pricePerBlock;
	/**
	 * it is defines  the bill per mileage.
	 */
	@Column(name="mileageBillAmount",nullable=true,length=50)
	private int mileageBillAmount;
	/**
	 * it is defines the bonus amount for driver
	 */
	@Column(name="bonusAmount",nullable=true,length=50)
	private int bonusAmount;
	@Column(name="bonusMinmount",nullable=true,length=50)
	private int bonusMinTol;
	
	public Collection<User> getUsers()
	{
		return this.users;
	}
	
	public void addUser(User user)
	{
		user.setCompany(this);
		UserDAO.addUser(user);
	}
	public void removeUser(User user)
	{
		users.remove(user);
	}

	public Collection<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Collection< Customer> customers) {
		this.customers = customers;
	}
	
	/**
	 * Aadd Customer to Company
	 * @param customer
	 */
	
	public void addCustomer(Customer customer) {
//		if (customer != null) {
//			//System.out.println(""+getNumber());
//			getCustomers().put(customer.getNumber(), customer);
		CustomerDAO.addCustomer(customer);
//		}
	}

	/**
	 * remove customer from the company
	 * 
	 * @param cashier
	 */
	public void removeCustomer(Customer customer) {
//		if (customer != null) {
//			getCustomers().remove(customer.getNumber());
//		}
		CustomerDAO.removeCustomer(customer);
	}
	/**
	 * Aadd Driver to Company
	 * @param customer
	 */
	
	public void addDriver(Driver driver) {
//		if (driver != null) {
//			getDrivers().put(driver.getNumber(), driver);
//		}
		DriverDAO.addDriver(driver);
	}
	


	/**
	 * remove driver from the company
	 * 
	 * @param cashier
	 */
	public void removeDriver(Driver driver) {
		DriverDAO.removeDriver(driver);
		
	}

	public Collection<Driver> getDrivers() {
		return this.drivers;
	}
	 
	

	public void setDrivers(Collection<Driver> drivers) {
		this.drivers = drivers;
	}

     
	/**
	 * it is defined as the calculate total bill of the package.
	 */
	public void calTotalBill() {
		// TODO - implement ACMECourierCompany.calTotalBill
		throw new UnsupportedOperationException();
	}

	/**
	 * it is defined as the calculate quoted price.
	 */
	public void calcQuotedPrice() {
		// TODO - implement ACMECourierCompany.calcQuotedPrice
		throw new UnsupportedOperationException();
	}

	/**
	 * it defines the calculate the blocks.
	 */
	public void calcBlocks() {
		// TODO - implement ACMECourierCompany.calcBlocks
		throw new UnsupportedOperationException();
	}
	public ACMECourierCompany()
	{
//		drivers = new TreeMap <String ,Driver>();
//		customers = new TreeMap<String ,Customer>();
//		users= new TreeMap<String ,User>();
	}

	

}