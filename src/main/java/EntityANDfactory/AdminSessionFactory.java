package EntityANDfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AdminSessionFactory {
	
	static SessionFactory ses;
	
	public static SessionFactory fact()
	{
		ses = new Configuration().configure("Admin.cfg.xml").buildSessionFactory();
		return ses;
	}

}
