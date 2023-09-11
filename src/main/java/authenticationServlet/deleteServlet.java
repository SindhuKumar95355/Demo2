package authenticationServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoClass.DAO;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id =Integer.parseInt(request.getParameter("id"));
		
		boolean b = DAO.delete(id);
		HttpSession session = request.getSession();
		
		
		if(b)
		{
			System.out.println("successfully deleted");
			session.setAttribute("success", "Deleted successfully");
			response.sendRedirect("displayDetails.jsp");
		}
		else
		{
			System.out.println("failed to delete");
			session.setAttribute("fail", "Deleted unsuccessfully");
			response.sendRedirect("displayDetails.jsp");

		}
		
		
	}

}
