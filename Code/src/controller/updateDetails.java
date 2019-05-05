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
import DAO.RegisterDAO;
import POJO.RegistrationPOJO;

/**
 * Servlet implementation class updateDetails
 */
@WebServlet("/updateDetails")
public class updateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session=request.getSession(false);
    	String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String emailID=request.getParameter("emailID");
		String userID=request.getParameter("userID");;
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String phoneNo=request.getParameter("phoneNo");
		
		RegistrationPOJO rp=new RegistrationPOJO();
		rp.setFname(fname);
		rp.setLname(lname);
		rp.setEmailID(emailID);
		rp.setUserID(userID);
		rp.setPassword(password);
		rp.setAddress(address);
		rp.setPhoneNo(phoneNo);
		System.out.print("Check1");
		RegisterDAO dao=new RegisterDAO();
		try {
			System.out.print("Check2");
			dao.update(rp);
			System.out.print("Check3");
			
			session.setAttribute("details", dao.profileDetails(userID));;
			System.out.print("Check4");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("Employee/Profile.jsp");
	//	RequestDispatcher rd=request.getRequestDispatcher("Admin/editEmployeeData.jsp");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.write("Profile Updated");
		rd.include(request, response);
		
	}

}
