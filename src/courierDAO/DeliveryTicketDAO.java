package courierDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import courierPD.DeliveryTicket;
public class DeliveryTicketDAO {

	public static void addDeliveryTicket(DeliveryTicket deliveryTicket)
	{
		EM.getEM().persist(deliveryTicket);
	}
		
	public static void saveDeliveryTicket(DeliveryTicket deliveryTicket) {
		EM.getEM().persist(deliveryTicket);
	}

	public static List<DeliveryTicket> listDeliveryTicket()
	{
		TypedQuery<DeliveryTicket> query = EM.getEM().createQuery(
				"SELECT deliveryTicket FROM deliveryTicket deliveryTicket", DeliveryTicket.class);
		return query.getResultList();
	}

	public static DeliveryTicket findDeliveryTicketById(int id)
	{
		DeliveryTicket deliveryTicket = EM.getEM().find(DeliveryTicket.class, new Integer(id));
		return deliveryTicket;
	}
	
	public static void removeDeliveryTicket(DeliveryTicket deliveryTicket)
	{
		EM.getEM().remove(deliveryTicket);
	}
}