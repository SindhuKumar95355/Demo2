package authenticationServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Use_ID = request.getParameter("id");
		String password = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		
		if(Use_ID.equals("admin123") && password.equals("sindhu95355"))
		{
			System.out.println("successfully logined into the admin pasge");
			session.setAttribute("success", "Welcome to Student details page");
			response.sendRedirect("displayDetails.jsp");
		}
		else
		{
			System.out.println("Not logined into the admin page");
			session.setAttribute("fail", "Entered incorrect id or password");
			response.sendRedirect("AdminLogin.jsp");
		}
	}

}
