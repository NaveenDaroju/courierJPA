package courierDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import courierPD.User;;
public class UserDAO {

	public static void addUser(User user)
	{
		EM.getEM().persist(user);
	}
		
	public static void saveUser(User user) {
		EM.getEM().persist(user);
	}

	public static List<User> listUser()
	{
		TypedQuery<User> query = EM.getEM().createQuery(
				"SELECT user FROM user user", User.class);
		return query.getResultList();
	}

	public static User findUserById(int id)
	{
		User user = EM.getEM().find(User.class, new Integer(id));
		return user;
	}
	
	public static void removeUser(User user)
	{
		EM.getEM().remove(user);
	}
}