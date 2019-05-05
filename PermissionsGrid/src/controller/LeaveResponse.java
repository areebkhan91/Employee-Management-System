package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LeaveDAO;

/**
 * Servlet implementation class LeaveResponse
 */
@WebServlet("/LeaveResponse")
public class LeaveResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empID=request.getParameter("empID");
		String resp=request.getParameter("response");

	//	String resp="ss";
		boolean res;
		if(resp.equals("grant"))
		{
			res=true;
		}
		else
		{
			res=false;
		}
		System.out.println("Button Value "+resp);
		
		LeaveDAO dao = new LeaveDAO();
		
		if(res)
		{
			try {
				dao.approveLeave(empID);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else
		{
			try {
				dao.denyLeave(empID);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
