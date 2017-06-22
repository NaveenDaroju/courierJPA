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

@Entity(name="Map")

public class Map implements  Serializable{
	private static final long serialVersionUID=1L;
	
	@Id //ignifies the primary key
	@Column(name="map_id", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long MapId;

	//ACMECourierCompany Company;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="ACMECourierCompany_ID",referencedColumnName="ACMECourierCompany_ID")
	private ACMECourierCompany company;
	
	private Collection<Intersections> intersections;
	/**
	 * it is defines the name of the street or avenue.
	 */
	@Column(name="name", nullable=false, length=50)

	private String name;
	/**
	 * it is defines the courier average speed.
	 */
	@Column(name="courier_avg_speed", nullable=false, length=50)

	private float courierAvgSpeed;
	/**
	 * it is defines the blocks per mile.
	 */
	@Column(name="blocks_to_mile", nullable=false, length=50)

	private float blocksToMile;

	/**
	 * it is defines the directions or route.
	 */
	public void direct() {
		// TODO - implement Map.direct
		throw new UnsupportedOperationException();
	}

}