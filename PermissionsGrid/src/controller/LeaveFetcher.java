package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDAO;
import DAO.LeaveDAO;

/**
 * Servlet implementation class LeaveFetcher
 */
@WebServlet("/LeaveFetcher")
public class LeaveFetcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveFetcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaveDAO dao=new LeaveDAO();
		HttpSession session=request.getSession(false);
		String userID=(String) session.getAttribute("userID");
		ArrayList<String> list=new ArrayList<String>();
		try {
			list=dao.fetchLeaveResponse(userID);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("/Employee/Leave.jsp");
		PrintWriter out=response.getWriter();
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) 
		{
			out.println(iterator.next()+" day<br/>");
		}
		
		rd.include(request, response);
		
	}

}
