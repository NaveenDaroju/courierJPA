package courierDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import courierPD.Intersections;
public class IntersectionsDAO {

	public static void addIntersections(Intersections intersections)
	{
		EM.getEM().persist(intersections);
	}
		
	public static void saveIntersections(Intersections intersections) {
		EM.getEM().persist(intersections);
	}

	public static List<Intersections> listIntersections()
	{
		TypedQuery<Intersections> query = EM.getEM().createQuery(
				"SELECT intersections FROM intersections intersections", Intersections.class);
		return query.getResultList();
	}

	public static Intersections findIntersectionsById(int id)
	{
		Intersections intersections = EM.getEM().find(Intersections.class, new Integer(id));
		return intersections;
	}
	
	public static void removeIntersections(Intersections intersections)
	{
		EM.getEM().remove(intersections);
	}
}