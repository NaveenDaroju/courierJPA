package courierPD;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Entity(name="Intersections")

public class Intersections implements  Serializable{
	private static final long serialVersionUID=1L;

	@Id //signifies the primary key
	@Column(name="intersection_id, nullable=false")
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long IntersectionId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="ACMECourierCompany_ID",referencedColumnName="ACMECourierCompany_ID")
	ACMECourierCompany company;
	
	private Collection<IntersectionClosed> closure;
	/**
	 * it is defined as the street.
	 */
	@Column(name="street_no",nullable=false, length=50)
	private String street;
	/**
	 * it is defined as the avenue.
	 */
	@Column(name="avenue", nullable=false, length=50)

	private String avenue;
	/**
	 * it is defined as the status of the driver.
	 */
	@Column(name="status", nullable=false, length=50)

	private String status;

}