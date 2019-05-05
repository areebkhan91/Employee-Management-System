package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagerDAO extends DAO{
	
	public ArrayList<String> getSubEmployees(String manager) throws ClassNotFoundException, SQLException{
	Connection con=getConnection();
	PreparedStatement ps = con.prepareStatement("select userID from register where manager=?");
	ps.setString(1, manager);
	ResultSet rs=ps.executeQuery();
	ArrayList<String> al = new ArrayList<String>();
	while(rs.next())
	{
		al.add(rs.getString("userID"));
	}
	System.out.println(al);
	ps.close();
	rs.close();
	con.close();
	return al;
	}

	public void updateBonus(String userID, float bonus) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update payroll SET bonus=? where userID=?");
		ps.setFloat(1, bonus);
		ps.setString(2, userID);
		ps.executeUpdate();
		ps.close();
		con.close();
	}

}
