package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.AdminList;

/**
 * Servlet implementation class ActiveEmployees
 */
@WebServlet("/ActiveEmployees")
public class ActiveEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiveEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminList alist=new AdminList();
		ArrayList<String> list= alist.getEmployees();
		HttpSession session=request.getSession(false);
		session.setAttribute("activelist", list);
		response.sendRedirect("Admin/showEmployees.jsp");
		
	}

}
