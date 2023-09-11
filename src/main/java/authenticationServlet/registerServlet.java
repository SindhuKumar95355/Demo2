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
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String USN = request.getParameter("usn");
		String branch = request.getParameter("branch");
		
		Con_DB con = new Con_DB(name, email, password, USN, branch);
		boolean b = DAO.insert(con);
		HttpSession session = request.getSession();
		if(b)
		{
			System.out.println("inserted successfully");
			session.setAttribute("success", "inserted accomplished");
			response.sendRedirect("page1.jsp");
		}
		else
		{
			System.out.println("Somthing went wrong");
			session.setAttribute("fail", "failed to inserted data");
			response.sendRedirect("page1.jsp");
		}
		
	}

}
