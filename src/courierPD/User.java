package courierPD;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;





@Entity(name="User")
public class User implements  Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@Column(name = "User_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
     private long UserId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="ACMECourierCompany_ID",referencedColumnName="ACMECourierCompany_ID")
	ACMECourierCompany company;
public ACMECourierCompany getCompany() {
		return company;
	}

	public void setCompany(ACMECourierCompany company) {
		this.company = company;
	}
	//	System System;
//	private Collection<DeliveryTicket> User;
	/*
	 * it is defined as the name of the user.
	 */
	@Column(name="user_name", nullable=false, length=50)

	private String name;
	/*
	 * it is defined as the username of the user.
	 */
	@Column(name="user_userName", nullable=false, length=50)

	private String username;
	/**
	 * it is defined as the password of the user.
	 */
	@Column(name="user_pass", nullable=false, length=48)

	private String password;
	/**
	 * it is defined as the email of the user.
	 */
	@Column(name="user_email", nullable=false, length=50)

	private String email;
	/**
	 * it is defines the role of the user.
	 */
	@Column(name="user_userRole", nullable=false, length=50)
	private String userRole;
	
	@Column(name="user_num", nullable=false, length=50)
private String number;

//	public System getSystem() {
//		return System;
//	}
//
//	public void setSystem(System system) {
//		System = system;
//	}
//
//	public DeliveryTicket getUser() {
//		return User;
//	}
//
//	public void setUser(DeliveryTicket user) {
//		user = user;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public String toString()
	{
		return getUsername();
	}
}