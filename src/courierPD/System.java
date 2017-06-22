package courierPD;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;

public class System implements  Serializable{
	private static final long serialVersionUID=1L;

	Collection<User> user;
	/**
	 * it is defines the name of the owner.
	 */
	@Column(name="name", nullable=false, length=50)

	private String name;
	/**
	 * it is defines the users list length.
	 */
	@Column(name="list_length", nullable=false, length=50)

	private long listLength;

}