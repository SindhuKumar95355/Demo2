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
 * Servlet implementation class editServlet
 */
@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String USN = request.getParameter("usn");
		String branch = request.getParameter("branch");
		
		HttpSession session =  request.getSession();
		Con_DB con = new Con_DB(id, name, email, password,USN, branch);
		boolean b = DAO.update(con);
		
		if(b)
		{
			System.out.println("updated successfully");
			session.setAttribute("success", "updated successfully");
			response.sendRedirect("page1.jsp");
		}
		else
		{
			System.out.println("not updated");
			session.setAttribute("fail", "failed to Updated ");
			response.sendRedirect("page1.jsp");
		}
	}

}
