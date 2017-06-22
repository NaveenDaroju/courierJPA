package courierDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import courierPD.IntersectionClosed;
public class IntersectionClosedDAO {

	public static void addIntersectionClosed(IntersectionClosed intersectionClosed)
	{
		EM.getEM().persist(intersectionClosed);
	}
		
	public static void saveIntersectionClosed(IntersectionClosed intersectionClosed) {
		EM.getEM().persist(intersectionClosed);
	}

	public static List<IntersectionClosed> listIntersectionClosed()
	{
		TypedQuery<IntersectionClosed> query = EM.getEM().createQuery(
				"SELECT intersectionClosed FROM intersectionClosed intersectionClosed", IntersectionClosed.class);
		return query.getResultList();
	}

	public static IntersectionClosed findIntersectionClosedById(int id)
	{
		IntersectionClosed intersectionClosed = EM.getEM().find(IntersectionClosed.class, new Integer(id));
		return intersectionClosed;
	}
	
	public static void removeIntersectionClosed(IntersectionClosed intersectionClosed)
	{
		EM.getEM().remove(intersectionClosed);
	}
}
