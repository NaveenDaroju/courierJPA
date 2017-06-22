package courierDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import courierPD.Map;
public class MapDAO {

	public static void addMap(Map map)
	{
		EM.getEM().persist(map);
	}
		
	public static void saveMap(Map map) {
		EM.getEM().persist(map);
	}

	public static List<Map> listMap()
	{
		TypedQuery<Map> query = EM.getEM().createQuery(
				"SELECT map FROM map map", Map.class);
		return query.getResultList();
	}

	public static Map findMapById(int id)
	{
		Map map = EM.getEM().find(Map.class, new Integer(id));
		return map;
	}
	
	public static void removeMap(Map map)
	{
		EM.getEM().remove(map);
	}
}