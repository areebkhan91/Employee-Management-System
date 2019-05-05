package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDAO;
import POJO.adminDetailsPOJO;

/**
 * Servlet implementation class AdminEditor2
 */
@WebServlet("/AdminEditor2")
public class AdminEditor2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditor2() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		String userID=request.getParameter("userID");
    	String manager=request.getParameter("manager");
		String department=request.getParameter("department");
		String role=request.getParameter("role");
		Float wage=Float.parseFloat(request.getParameter("wage"));
		
		adminDetailsPOJO rp=new adminDetailsPOJO();
		rp.setUserID(userID);
		rp.setManager(manager);
		rp.setDepartment(department);
		rp.setRole(role);
		rp.setWage(wage);
		AdminDAO dao=new AdminDAO();// dao initializes
		try {
			dao.updateEmployeeDetails(rp);			
			session.setAttribute("details", dao.adminProfileDetails(userID));;
			System.out.print("AdminEditor2 "+rp.getUserID());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("Admin/Admin Profile.jsp");
	//	RequestDispatcher rd=request.getRequestDispatcher("Admin/editEmployeeData.jsp");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.write("Profile Updated");
		rd.include(request, response);
	}

}
