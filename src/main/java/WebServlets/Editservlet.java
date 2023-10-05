package WebServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import EntityANDfactory.ENT1;
import EntityANDfactory.sessionfactory;

/**
 * Servlet implementation class Editservlet
 */
public class Editservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String role = request.getParameter("role");
		String city = request.getParameter("city");
		String status = request.getParameter("status");
		int id = Integer.parseInt(request.getParameter("id"));
		
		
//		System.out.println(name +":"+ role +":"+  city +":"+ status);
		
		Session s = sessionfactory.factory().openSession();
		s.beginTransaction();
		
		ENT1 obj = s.get(ENT1.class,id); 
		obj.setName(name);
		obj.setRole(role);
		obj.setCity(city);
		obj.setWork_Status(status);

		s.getTransaction().commit();		
		s.close();	
		
		HttpSession session = request.getSession();
		
		if(obj != null)
		{
			session.setAttribute("success", "Successfully updated");
			response.sendRedirect("Detailspage.jsp");
			System.out.println("Successfully updated");
		}
		
	}

}
