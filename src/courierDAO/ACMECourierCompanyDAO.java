package courierDAO;

import java.util.List;

import javax.persistence.GenerationType;
import javax.persistence.TypedQuery;
import courierPD.ACMECourierCompany;


public class ACMECourierCompanyDAO {
	

	public static void addACMECourierCompany(ACMECourierCompany company)
	{
		EM.getEM().persist(company);
	}
		
	public static void saveACMECourierCompany(ACMECourierCompany company) {
		EM.getEM().persist(company);
	}

	public static List<ACMECourierCompany> listACMECourierCompany()
	{
		TypedQuery<ACMECourierCompany> query = EM.getEM().createQuery(
				"SELECT ACMECourierCompany FROM ACMECourierCompany ACMECourierCompany", ACMECourierCompany.class);
		return query.getResultList();
	}

	public static ACMECourierCompany findACMECourierCompanyById(int id)
	{
		ACMECourierCompany company = EM.getEM().find(ACMECourierCompany.class, new Integer(id));
		return company;
	}
	
	public static void removeACMECourierCompany(ACMECourierCompany company)
	{
		EM.getEM().remove(company);
	}
}