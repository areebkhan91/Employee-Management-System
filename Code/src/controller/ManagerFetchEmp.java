package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LeaveDAO;

/**
 * Servlet implementation class ManagerFetchEmp
 */
@WebServlet("/ManagerFetchEmp")
public class ManagerFetchEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerFetchEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String managerID=(String) session.getAttribute("userID");
		String empID=request.getParameter("userID");
		LeaveDAO dao=new LeaveDAO();
		String leave=null;
		try {
			leave=dao.getLeaves(managerID, empID);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(leave+" in servlet");
		request.setAttribute("leave", leave);
		request.setAttribute("empID", empID);
		RequestDispatcher rd=request.getRequestDispatcher("Manager/SubEmployeeDetails.jsp");
		rd.forward(request, response);
	}

}
