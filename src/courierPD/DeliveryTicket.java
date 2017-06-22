package courierPD;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
@Entity(name="DeliveryTicket")
public class DeliveryTicket implements  Serializable{
		private static final long serialVersionUID=1L;
	@Id//signifies the primary key
	@Column(name = "DeliveryTicket_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long DeliveryTicketId;

	@JoinColumn(name="del_pickupCust", referencedColumnName="Customer_id")
	private Customer pickupCustomer;
	@JoinColumn(name="del_assigned_driver", referencedColumnName="Driver_id")
	private Driver assignedDriver;
	@JoinColumn(name="assigned_user",referencedColumnName="User_id")
	private User assignedUser;
	@ManyToOne(optional=false)
	@JoinColumn(name="ACMECourierCompany_ID",referencedColumnName="ACMECourierCompany_ID")
	ACMECourierCompany company;
	@JoinColumn(name="del_deliveryCust", referencedColumnName="Customer_id")
	private Customer deliveryCustomer;
  
	
	
	
	
	public ACMECourierCompany getCompany() {
		return company;
	}

	public void setCompany(ACMECourierCompany company) {
		this.company = company;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	private int min=1000;
	private int max=9999;
	/**
	 * it is defined as the package number.
	 */
	@Column(name="ti_id", nullable=false, length=50)

	private String ti_id;
	/**
	 * it is defined as the date and time of the package.
	 */
	@Column(name="ti_date", nullable=false, length=50)

	private Date ti_date;
	@Column(name="ti_time", nullable=false, length=50)

	private LocalTime ti_time;
	/**
	 * it is defined as the pickup date and time of the package.
	 */
	@Column(name="pick_date", nullable=false, length=50)

	private LocalDate pick_Date;
	@Column(name="pick_time", nullable=false, length=50)

	private LocalTime pick_time;
	/**
	 * it is defined as the estimated delivery date and time of the package.
	 */
	@Column(name="est_dtime", nullable=false, length=50)

	private LocalTime est_dtime;
	/**
	 * it is defines the bill of the package.
	 */
	@Column(name="quoted_price", nullable=false, length=50)

	private int quoted_price;
	/**
	 * it is defined as the estimated departure date and time of the package.
	 */
	@Column(name="est_dDate", nullable=false, length=50)

	private LocalDate est_dDate;
	/**
	 * it is defined as the actual departure date and time of the package.
	 */
	@Column(name="act_dtime", nullable=false, length=50)

	private LocalDate act_dtime;
	/**
	 * it is defined as the actual pickup date and time of the package.
	 */
	@Column(name="act_ptime", nullable=false, length=50)

	private LocalDate act_ptime;
	/**
	 * it is defined as the actual delivery date and time of the package.
	 */
	
	/**
	 * it is defined as the actual return date and time of the driver.
	 */
	@Column(name="del_actDReturn_dateTime", nullable=false, length=50)

	private LocalDate actReturnDateTime;
	@Column(name="del_actDelivery_dateTime", nullable=false, length=50)

	private LocalDate actDeliveryDateTime;
	public Customer getPickupCustomer() {
		return pickupCustomer;
	}

	public void setPickupCustomer(Customer pickupCustomer) {
		this.pickupCustomer = pickupCustomer;
	}

	public Customer getDeliveryCustomer() {
		return deliveryCustomer;
	}

	public void setDeliveryCustomer(Customer deliveryCustomer) {
		deliveryCustomer = deliveryCustomer;
	}

	public Driver getAssignedDriver() {
		return assignedDriver;
	}

	public void setAssignedDriver(Driver assignedDriver) {
		this.assignedDriver = assignedDriver;
	}

	public String getTi_id() {
		return ti_id;
	}

	public void setTi_id(String ti_id) {
		this.ti_id = ti_id;
	}

	public Date getTi_date() {
		return ti_date;
	}

	public void setTi_date(Date ti_date) {
		this.ti_date = ti_date;
	}

	public LocalTime getTi_time() {
		return ti_time;
	}

	public void setTi_time(LocalTime ti_time) {
		this.ti_time = ti_time;
	}

	public LocalDate getPick_Date() {
		return pick_Date;
	}

	public void setPick_Date(LocalDate pick_Date) {
		this.pick_Date = pick_Date;
	}

	public LocalTime getPick_time() {
		return pick_time;
	}

	public void setPick_time(LocalTime pick_time) {
		this.pick_time = pick_time;
	}

	public LocalTime getEst_dtime() {
		return est_dtime;
	}

	public void setEst_dtime(LocalTime est_dtime) {
		this.est_dtime = est_dtime;
	}

	public int getQuoted_price() {
		return quoted_price;
	}

	public void setQuoted_price(int quoted_price) {
		this.quoted_price = quoted_price;
	}

	public LocalDate getEst_dDate() {
		return est_dDate;
	}

	public void setEst_dDate(LocalDate est_dDate) {
		this.est_dDate = est_dDate;
	}

	public LocalDate getAct_dtime() {
		return act_dtime;
	}

	public void setAct_dtime(LocalDate act_dtime) {
		this.act_dtime = act_dtime;
	}

	public LocalDate getAct_ptime() {
		return act_ptime;
	}

	public void setAct_ptime(LocalDate act_ptime) {
		this.act_ptime = act_ptime;
	}

	public LocalDate getActDeliveryDateTime() {
		return actDeliveryDateTime;
	}

	public void setActDeliveryDateTime(LocalDate actDeliveryDateTime) {
		this.actDeliveryDateTime = actDeliveryDateTime;
	}

	public LocalDate getActReturnDateTime() {
		return actReturnDateTime;
	}

	public void setActReturnDateTime(LocalDate actReturnDateTime) {
		this.actReturnDateTime = actReturnDateTime;
	}

	
	/**
	 * it is defines the calculate estimated delivery time.
	 */
	public void calcEstDeliveryTime() {
		// TODO - implement DeliveryTicket.calcEstDeliveryTime
		throw new UnsupportedOperationException();
	}

	/**
	 * it is defines the calculate estimated departure time of the package.
	 */
	public void calcEstDepartureTime() {
		// TODO - implement DeliveryTicket.calcEstDepartureTime
		throw new UnsupportedOperationException();
	}

	/**
	 * it is defines the calculate total bill of the package.
	 */
	public void calcBillAmount() {
		// TODO - implement DeliveryTicket.calcBillAmount
		throw new UnsupportedOperationException();
	}

	public String genPackagenumber() {
		 ti_id= Integer.toString(ThreadLocalRandom.current().nextInt(min, max + 1));
	return ti_id;
	}
	

}