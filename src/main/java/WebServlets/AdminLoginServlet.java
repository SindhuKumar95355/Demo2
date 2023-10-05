package WebServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;

import EntityANDfactory.AdminEntity;
import EntityANDfactory.AdminSessionFactory;
import EntityANDfactory.sessionfactory;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		
		System.out.println(email);
		System.out.println(pass);
		
		AdminEntity ad = new AdminEntity();
		
//		System.out.println(email);
//		System.out.println(pass);
//		
//		System.out.println(ad.getEmail());
//		System.out.println( ad.getPassword());
		
		
		
		Session session = AdminSessionFactory.fact().openSession();
		session.beginTransaction();
		
		HttpSession session1 = request.getSession();
		
		Query q =  session.createQuery("from AdminEntity as a where a.email=:x and a.password=:y");
		q.setParameter("x", email);
		q.setParameter("y", pass);
		
		List<AdminEntity> list =  q.list();
		
	RequestDispatcher rd = request.getRequestDispatcher("Detailspage.jsp");
		
		for(AdminEntity li : list)
		{
			if(li.getEmail().equals(email) && li.getPassword().equals(pass))
			{
				System.out.println("Loggined successfully");
				session1.setAttribute("success", "Successfully logined");
//				response.sendRedirect("Detailspage.jsp");
				rd.forward(request, response);
			}
			
//			System.out.println(li.getEmail());
//			System.out.println(li.getPassword());

		}		
		
//		AdminEntity obj =  session.get(AdminEntity.class, id);
		
//		System.out.println(obj.getPassword());
//		System.out.println(obj.getEmail());
		
		
//		if(email.equals(obj.getEmail()) && id ==  obj.getAid())
//		{
//			System.out.println("Successfully loggined");
//			response.sendRedirect("Detailspage.jsp");
//		}
//		else
//		{
//			System.out.println("Somthing went wrong");
//		}
	
		
		session.getTransaction().commit();
		session.close();
	
		System.out.println("login Failed");
		session1.setAttribute("obj", "failed to login enter valid email and password");
		response.sendRedirect("AdminLogin.jsp");
	}

}
