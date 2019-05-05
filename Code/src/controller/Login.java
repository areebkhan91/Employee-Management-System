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

import DAO.LoginDAO;
import POJO.LoginPOJO;
import POJO.RegistrationPOJO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userID=request.getParameter("userID");
		String password=request.getParameter("password");
		LoginPOJO login=new LoginPOJO();
		login.setUserID(userID);
		login.setPassword(password); 
		
		LoginDAO dao=new LoginDAO();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp");
		
		Boolean check=false;
		try {
				check=dao.checkLogin(login);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		if(userID==""||password=="")
		{
			out.write("Blank fields");
			rd.include(request, response);
		}
		else if(userID.equals("000")&password.equals("000"))
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("userID", "admin");
			response.sendRedirect("Admin/Admin Profile.jsp");
		}
		else if(check)
		{	POJO.RegistrationPOJO details=new RegistrationPOJO();
			try {
				details=dao.profileDetails(userID);//Retrieve details
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			HttpSession session=request.getSession(true);
			session.setAttribute("userID", userID);
			session.setAttribute("details", details);
		//	System.out.print(details.getFname()+"Inside Login Servlet");
			response.sendRedirect("Employee/Profile.jsp");		
		}

		else 
		{
			out.write("Wrong Credentials,Try Again");
			rd.include(request, response);
		}
		
	}

}
