package authenticationServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoClass.DAO;
import Entity_and_DB.Con_DB;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		 Con_DB con =  DAO.login_by_details(email, pass);
		 
//		 System.out.println(con.getName() +"," + con.getEmail());
		 
		 HttpSession session = request.getSession();
		
		if(con != null)
		{
			session.setAttribute("object", con);
			System.out.println("successfully logined");
			session.setAttribute("success", "successfully logined");
			response.sendRedirect("Detailspage.jsp");
		}
		else
		{
				System.out.println("successfully not logined");
				session.setAttribute("fail", "failed to  login");
				response.sendRedirect("page1.jsp");
		}
	}

}
