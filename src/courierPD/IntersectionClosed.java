package courierPD;
import java.io.Serializable;
import java.time.LocalDate;

public class IntersectionClosed implements  Serializable{
	private static final long serialVersionUID=1L; 

	/**
	 * it is defines the intersection start date and time.
	 */
	private LocalDate startDateTime;
	/**
	 * it is defines the end date and time of the intersection.
	 */
	private LocalDate endDateTime;

}