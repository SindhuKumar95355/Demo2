package EntityANDfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class sessionfactory {
	
	static SessionFactory fac;
	
	public static SessionFactory factory()
	{
		fac = new Configuration().configure("WebCRUD.cfg.xml").buildSessionFactory();
		
		return fac;
	}

}
