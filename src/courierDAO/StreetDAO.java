package courierDAO;


import java.util.List;
import javax.persistence.TypedQuery;
import courierPD.Street;
public class StreetDAO {

	public static void addStreet(Street street)
	{
		EM.getEM().persist(street);
	}
		
	public static void saveStreet(Street street) {
		EM.getEM().persist(street);
	}

	public static List<Street> listStreet()
	{
		TypedQuery<Street> query = EM.getEM().createQuery(
				"SELECT street FROM street street", Street.class);
		return query.getResultList();
	}

	public static Street findStreetById(int id)
	{
		Street street = EM.getEM().find(Street.class, new Integer(id));
		return street;
	}
	
	public static void removeStreet(Street street)
	{
		EM.getEM().remove(street);
	}
}