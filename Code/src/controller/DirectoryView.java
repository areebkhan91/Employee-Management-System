package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DirectoryDAO;
import DAO.DirectoryDAO2;

/**
 * Servlet implementation class DirectoryView
 */
@WebServlet("/DirectoryView")
public class DirectoryView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DirectoryView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("www");
		HttpSession session=request.getSession(false);
		ArrayList<String> directories=new ArrayList<String>();
		DirectoryDAO2 dao=new DirectoryDAO2();
		try {
			directories=dao.getList((String) session.getAttribute("userID"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("directories", directories);
	//	RequestDispatcher rd=request.getRequestDispatcher("DirectoryViewer.jsp");
	//	rd.forward(request, response);
		response.sendRedirect("DirectoryViewer.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		String userID=(String) session.getAttribute("userID");
		
	//	System.out.println("sss");
		String directory_id=request.getParameter("directory");
		System.out.println(directory_id+"directoryView");
		DirectoryDAO2 dao=new DirectoryDAO2();
		
		ArrayList<String> directories = null;
		try {
			directories=dao.getContents(directory_id, userID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("sss");
		System.out.println("Directory View.java "+directories);	
			
			session.removeAttribute("directories");
			session.setAttribute("directories", directories);
			response.sendRedirect("DirectoryViewer.jsp");	
			System.out.println("end");
		}
	}

