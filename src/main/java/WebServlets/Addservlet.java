package WebServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import EntityANDfactory.ENT1;
import EntityANDfactory.sessionfactory;

/**
 * Servlet implementation class Addservlet
 */
public class Addservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		String city = request.getParameter("city");
		String status = request.getParameter("status");
		
		ENT1 e1 = new ENT1(name, role, city, status);
		
		Session s1 = sessionfactory.factory().openSession();
		s1.beginTransaction();
		
		s1.save(e1);
		
		s1.getTransaction().commit();
		s1.close();
		
		try
		{
		
		if(e1 != null)
		{
			request.setAttribute("success", "Inserted successfully");
			response.sendRedirect("Detailspage.jsp");
			System.out.println("Successfully inserted");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
