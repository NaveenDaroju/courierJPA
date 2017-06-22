package courierDAO;

import java.util.List;
import javax.persistence.TypedQuery;

import courierPD.Driver;
public class DriverDAO {

	public static void addDriver(Driver driver)
	{
		EM.getEM().persist(driver);
	}
		
	public static void saveDriver(Driver driver) {
		EM.getEM().persist(driver);
	}

	public static List<Driver> listDriver()
	{
		TypedQuery<Driver> query = EM.getEM().createQuery(
				"SELECT driver FROM driver driver", Driver.class);
		return query.getResultList();
	}

	public static Driver findDriverById(int id)
	{
		Driver driver = EM.getEM().find(Driver.class, new Integer(id));
		return driver;
	}
	
	public static void removeDriver(Driver driver)
	{
		EM.getEM().remove(driver);
	}
}

