package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
 //	Connection conn=null;
//	PreparedStatement ps =null;
//	ResultSet rs=null;
	static int i=0;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		if(i==0)
		{
			i++;
		Class.forName("com.mysql.jdbc.Driver");
		}
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user" , "password");
		return conn;
	}
	
	public POJO.RegistrationPOJO profileDetails(String userID) throws ClassNotFoundException, SQLException{
		Connection con=getConnection();
		PreparedStatement ps = con.prepareStatement("select fname,lname,address,phoneNo,emailID,userID from register where userID=?");
		ps.setString(1, userID);
		ResultSet rs=ps.executeQuery();
		POJO.RegistrationPOJO rp=new POJO.RegistrationPOJO();
		while(rs.next())
		{
		rp.setFname(rs.getString("fname"));
		rp.setLname(rs.getString("lname"));
		rp.setAddress(rs.getString("address"));
		rp.setPhoneNo(rs.getString("phoneNo"));
		rp.setEmailID(rs.getString("emailID"));
		rp.setUserID(rs.getString("userID"));
		}
		
		ps.close();
		rs.close();
		con.close();
		return rp;
		}

	
	public POJO.adminDetailsPOJO adminProfileDetails(String userID) throws ClassNotFoundException, SQLException{
		Connection con=getConnection();
		PreparedStatement ps = con.prepareStatement("select userID,manager,department,role from register where userID=?");
		ps.setString(1, userID);
		ResultSet rs=ps.executeQuery();
		POJO.adminDetailsPOJO rp=new POJO.adminDetailsPOJO();
		while(rs.next())
		{
		rp.setUserID(rs.getString("userID"));
		rp.setManager(rs.getString("manager"));
		rp.setDepartment(rs.getString("department"));
		rp.setRole(rs.getString("role"));
		}
		
		ps = con.prepareStatement("select wage from payroll where userID=?");
		ps.setString(1, userID);
		rs=ps.executeQuery();
		while(rs.next())
		{
		rp.setWage(rs.getFloat("wage"));
		}
		
		ps.close();
		rs.close();
		con.close();
		return rp;
		}
	
	public String getManagerID(String userID) throws ClassNotFoundException, SQLException
	{
		String managerID=null;
		
		Connection con=getConnection();
		PreparedStatement ps = con.prepareStatement("select manager from register where userID=?");
		ps.setString(1, userID);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
		managerID=rs.getString("manager");
		}
		
		ps.close();
		rs.close();
		con.close();
		System.out.println(managerID);
		return managerID;
		
	}
	
	
}
