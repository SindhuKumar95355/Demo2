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
 * Servlet implementation class Deletepage
 */
public class Deletepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("ID"));
		
		Session s = sessionfactory.factory().openSession();
		s.beginTransaction();
		
		ENT1 en = s.get(ENT1.class, id);
		s.delete(en);
		
		s.getTransaction().commit();
		s.close();
		
		if(id > 1)
		{
			response.sendRedirect("Detailspage.jsp");
			System.out.println("Deleted ");
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
