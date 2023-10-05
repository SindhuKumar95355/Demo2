package WebServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;

import EntityANDfactory.ENT1;
import EntityANDfactory.sessionfactory;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Session session = sessionfactory.factory().openSession();
		session.beginTransaction();
		
		ENT1 e = session.get(ENT1.class, id);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println(e.getName());
		System.out.println(e.getID());
		
		HttpSession ses = request.getSession();
		
		if(e.getName().equals(name) && e.getID() == id)
		{
			System.out.println("Successfully logined");
			ses.setAttribute("success", e);
			request.setAttribute("success1", "Successfully Logined");
			response.sendRedirect("entityDetail.jsp");
		}
		else
		{
			response.sendRedirect("index.jsp");
			System.out.println("incorrect id");
			ses.setAttribute("fail", "Unsuccessfull to login");
		}	
	}
}
