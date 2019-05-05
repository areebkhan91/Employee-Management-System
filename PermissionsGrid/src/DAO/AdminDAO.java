package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import POJO.RegistrationPOJO;

public class AdminDAO extends DAO {

	

	public ArrayList<String> getEmployeeList() throws ClassNotFoundException, SQLException{
	Connection con=getConnection();
	PreparedStatement ps = con.prepareStatement("select userID,fname,lname from register where status=1");
	ResultSet rs=ps.executeQuery();
	ArrayList<String> al = new ArrayList<String>();
//	ArrayList<String> al1 = new ArrayList<String>();
	while(rs.next())
	{
		al.add(rs.getString("userID"));
		al.add(rs.getString("fname"));
		al.add(rs.getString("lname"));
		
	}
	System.out.println(al);
//	System.out.println(al1);
	ps.close();
	rs.close();
	con.close();
	return al;
	}
	
	public ArrayList<String> getInactiveEmployeeList() throws ClassNotFoundException, SQLException{
		Connection con=getConnection();
		PreparedStatement ps = con.prepareStatement("select userID,fname,lname from register where status=0");
		ResultSet rs=ps.executeQuery();
		ArrayList<String> al = new ArrayList<String>();
//		ArrayList<String> al1 = new ArrayList<String>();
		while(rs.next())
		{
			al.add(rs.getString("userID"));
			al.add(rs.getString("fname"));
			al.add(rs.getString("lname"));
			
		}
		System.out.println(al);
//		System.out.println(al1);
		ps.close();
		rs.close();
		con.close();
		return al;
		}
	
	public RegistrationPOJO getDetails(String userID) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement ps = con.prepareStatement("select fname,lname,address,phoneNo,emailID from register where userID=?");
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
		}
		
		ps.close();
		rs.close();
		con.close();
		return rp;
	}
	
	public void updateEmployeeDetails(POJO.adminDetailsPOJO rp) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("update register SET manager=?,department=?,role=?,status=1 where userID=?");
		ps.setString(1, rp.getManager());
		ps.setString(2, rp.getDepartment());
		ps.setString(3, rp.getRole());
		ps.setString(4, rp.getUserID());
		ps.executeUpdate();
			
		
		ps = (PreparedStatement) conn.prepareStatement("update payroll SET wage=? where userID=?");
		ps.setFloat(1, rp.getWage());
		ps.setString(2, rp.getUserID());
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}

	public void runPayroll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from monthly");
		ps.executeUpdate();
		ps=con.prepareStatement("SELECT userID,(wage+bonus) as salary FROM db.payroll");
		ResultSet rs=ps.executeQuery();
		ArrayList<String> al=new ArrayList();
//		ArrayList<Float> a2=new ArrayList <Float>();
		
		while(rs.next())
		{
			al.add("("+rs.getString("userID")+", "+rs.getFloat("salary")+")");

		}
		
		String query="";
		
		Iterator iterator=al.iterator();
		while(iterator.hasNext())
		{
			query=query+iterator.next()+",";
		}
		
		System.out.println(query);
		
		ps=con.prepareStatement("insert into monthly values "+query+"(0,0)");
		ps.executeUpdate();
		ps.close();
		rs.close();
		con.close();
		
	}
	
	
}
