package DAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class RegisterDAO extends DAO {

	public void register(POJO.RegistrationPOJO rp) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("insert into register values(?,?,?,?,?,?,?,null,null,null,0)");
		ps.setString(1, rp.getFname());
		ps.setString(2, rp.getLname());
		ps.setString(3, rp.getAddress());
		ps.setString(4, rp.getPhoneNo());
		ps.setString(5, rp.getEmailID());
		ps.setString(6, rp.getUserID());
		ps.setString(7, rp.getPassword());
		ps.executeUpdate();
		
		ps = (PreparedStatement) conn.prepareStatement("insert into payroll values(?,null,null)");
		ps.setString(1, rp.getUserID());
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public void update(POJO.RegistrationPOJO rp) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("update register SET fname=?,lname=?,address=?,phoneNo=?,emailID=?,password=? where userID=?");
		ps.setString(1, rp.getFname());
		ps.setString(2, rp.getLname());
		ps.setString(3, rp.getAddress());
		ps.setString(4, rp.getPhoneNo());
		ps.setString(5, rp.getEmailID());
		ps.setString(6, rp.getPassword());
		ps.setString(7, rp.getUserID());
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
}
