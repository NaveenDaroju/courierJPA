package courierPD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="street")

public class Street implements  Serializable{
	private static final long serialVersionUID=1L;
@Id
@Column(name="street_no", nullable=false)
@GeneratedValue(strategy=GenerationType.AUTO)
private long StreetNo;

@ManyToOne(optional=false)
@JoinColumn(name="ACMECourierCompany_ID", referencedColumnName="ACMECourierCompany_ID")
ACMECourierCompany company;
	Intersections intersection;
	/**
	 * it is defined as the name of the street.
	 */
	@Column(name="street_name", nullable=false, length=50)

	private String name;
	/**
	 * it is defined as the distance of the street from pickup location to delivery street.
	 */
	@Column(name="street_dist", nullable=false, length=50)

	private float distance;
	/**
	 * it is defined as the directions of street.
	 */
	@Column(name="street_dir", nullable=false, length=50)

	private String direction;

}