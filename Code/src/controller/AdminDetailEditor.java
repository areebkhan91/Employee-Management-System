package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;
import POJO.adminDetailsPOJO;

/**
 * Servlet implementation class AdminDetailEditor
 */
@WebServlet("/AdminDetailEditor")
public class AdminDetailEditor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDetailEditor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID=(String)request.getParameter("userID");
		HttpSession session=request.getSession(false);
		adminDetailsPOJO rp=new adminDetailsPOJO();
		DAO dao=new DAO();
		try {
			rp=dao.adminProfileDetails(userID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("details", rp);
	//	RequestDispatcher rd=request.getRequestDispatcher("EditEmployeeDetails.jsp");
		response.sendRedirect("Admin/EditEmployeeDetails.jsp");
	}

}
