package courierDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import courierPD.Customer;
public class CustomerDAO {

	public static void addCustomer(Customer le)
	{
		EM.getEM().persist(le);
	}
		
	public static void saveCustomer(Customer le) {
		EM.getEM().persist(le);
	}

	public static List<Customer> listCustomer()
	{
		TypedQuery<Customer> query = EM.getEM().createQuery(
				"SELECT customer FROM customer customer", Customer.class);
		return query.getResultList();
	}

	public static Customer findCustomerById(int id)
	{
		Customer le = EM.getEM().find(Customer.class, new Integer(id));
		return le;
	}
	
	public static void removeCustomer(Customer le)
	{
		EM.getEM().remove(le);
	}
}


