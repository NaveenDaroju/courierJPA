package courierDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import courierPD.System;
public class SystemDAO {

	public static void addSystem(System system)
	{
		EM.getEM().persist(system);
	}
		
	public static void saveSystem(System system) {
		EM.getEM().persist(system);
	}

	public static List<System> listSystem()
	{
		TypedQuery<System> query = EM.getEM().createQuery(
				"SELECT system FROM system system", System.class);
		return query.getResultList();
	}

	public static System findSystemById(int id)
	{
		System system = EM.getEM().find(System.class, new Integer(id));
		return system;
	}
	
	public static void removeSystem(System system)
	{
		EM.getEM().remove(system);
	}
}