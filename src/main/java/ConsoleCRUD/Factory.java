package ConsoleCRUD;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory {
	
	static SessionFactory fac;
	
	public SessionFactory meth()
	{
		fac = new Configuration().configure("Console.cfg.xml").buildSessionFactory();
		return fac;
	}

}
