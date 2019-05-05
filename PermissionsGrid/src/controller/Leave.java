package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.time.temporal.ChronoUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;

import DAO.LeaveDAO;


/**
 * Servlet implementation class Leave
 */
@WebServlet("/Leave")
public class Leave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Leave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		String userID=(String) session.getAttribute("userID");
		
		String start=request.getParameter("start_date");
		String end=request.getParameter("end_date");
		DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate start_date = LocalDate.parse(start, df);
		LocalDate end_date =LocalDate.parse(end, df); 
	//	int a =end_date.compareTo(start_date);	
		int b = (int) Duration.between(start_date.atTime(0, 0), end_date.atTime(0, 0)).toDays() +1;
		System.out.println(" "+start+" "+end+" "+b);
		
		PrintWriter out=response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("Employee/Leave.jsp");
		
		LeaveDAO dao=new LeaveDAO();
		boolean check = false;
		try {
			check=dao.checkLeaveCount(b, userID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!check)
		{	
			out.write("Wrong Input,Try Again");
			rd.include(request, response);
		}
		else
		{
			rd = request.getRequestDispatcher("Employee/Leave.jsp");
			out.write("Leave Applied");
			rd.include(request, response);
		}
		
		try {
			dao.insertLeave(b, userID, start, end);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
