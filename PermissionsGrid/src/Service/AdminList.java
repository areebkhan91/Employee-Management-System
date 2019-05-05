package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.AdminDAO;

public class AdminList {

	public ArrayList<String> getEmployees()
	{
		AdminDAO dao=new AdminDAO();
		ArrayList<String> al = null;
		try {
			al=dao.getEmployeeList();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
	
	public ArrayList<String> getInactiveEmployees()
	{
		AdminDAO dao=new AdminDAO();
		ArrayList<String> al = null;
		try {
			al=dao.getInactiveEmployeeList();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
}
