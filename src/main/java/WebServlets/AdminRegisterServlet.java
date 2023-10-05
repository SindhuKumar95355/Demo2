package WebServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import EntityANDfactory.AdminEntity;
import EntityANDfactory.AdminSessionFactory;

/**
 * Servlet implementation class AdminRegisterServlet
 */
public class AdminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		AdminEntity ad = new AdminEntity(name, email, pass);
		
		Session ses = AdminSessionFactory.fact().openSession();
		ses.beginTransaction();
		
		ses.save(ad);
		
		ses.getTransaction().commit();
		ses.close();
		
		HttpSession session = request.getSession();
		
		if(ad != null)
		{
			session.setAttribute("obj", "Successfully Registered ");
			System.out.println("Successfully registered ");
			response.sendRedirect("AdminLogin.jsp");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
