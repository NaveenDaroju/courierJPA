package courierPD;
import java.io.Serializable;
import java.time.LocalDate;

import java.util.*;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity(name="Route")

public class Route implements  Serializable{
	private static final long serialVersionUID=1L;
	
	
	@Id
@Column(name="route_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long RouteId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="Intersections",referencedColumnName="Intersections")
	private Collection<Intersections> intersections;
	/*
	 * it is defines the starting date and time of the route.
	 */@Column(name="start_dateTime", nullable=false, length=50)

	private LocalDate startDateTime;
	 @Column(name="street_name", nullable=false, length=50)

	private String streetName;

}