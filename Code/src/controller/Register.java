package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegisterDAO;
import POJO.RegistrationPOJO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		RegisterDAO dao=new RegisterDAO();
		try {
			dao.register(rp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/PermissionsGrid/Logout.jsp");
	}
	
	

}
