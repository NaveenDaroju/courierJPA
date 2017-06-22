package courierDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import courierPD.Route;
public class RouteDAO {

	public static void addRoute(Route route)
	{
		EM.getEM().persist(route);
	}
		
	public static void saveRoute(Route route) {
		EM.getEM().persist(route);
	}

	public static List<Route> listRoute()
	{
		TypedQuery<Route> query = EM.getEM().createQuery(
				"SELECT route FROM route route", Route.class);
		return query.getResultList();
	}

	public static Route findRouteById(int id)
	{
		Route route = EM.getEM().find(Route.class, new Integer(id));
		return route;
	}
	
	public static void removeRoute(Route route)
	{
		EM.getEM().remove(route);
	}
}