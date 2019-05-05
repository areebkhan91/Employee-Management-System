package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class LeaveDAO extends DAO {

	
	
	public boolean checkLeaveCount(int b,String userID) throws ClassNotFoundException, SQLException{
		Connection con=getConnection();
		PreparedStatement ps = con.prepareStatement("select leave_count from leave_tracker where empID=?");
		ps.setString(1, userID);
		ResultSet rs=ps.executeQuery();
		int leave_count = 0;
		
		while(rs.next())
		{
			leave_count=Integer.parseInt(rs.getString("leave_count"));
		}
		
		ps.close();
		rs.close();
		con.close();
		
		if(b>leave_count)
		{
			return false;
		}
		else
			return true;
		
	}
	
	public void insertLeave(int lc, String userID, String start_date,String end_date) throws ClassNotFoundException, SQLException
	{
		
		Connection con=getConnection();
		String managerID=getManagerID(userID);
		System.out.println(managerID);
		PreparedStatement ps = con.prepareStatement("insert into  emp_leave values(?,?,?,?,?,null,null,null)");
		ps.setString(1, managerID);
		ps.setString(2, userID);
		ps.setString(3,start_date);
		ps.setString(4, end_date);
		ps.setInt(5, lc);
		ps.executeUpdate();
		
		ps.close();
		con.close();
				
	}
	
	
	public String getLeaves(String managerID, String empID) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from emp_leave where empID=? and managerID=? and manager_response is null");
		ps.setString(1, empID);
		ps.setString(2, managerID);
		ResultSet rs=ps.executeQuery();
		String leave=null;
		while(rs.next())
		{
			leave=rs.getString("start_date")+"to"+rs.getString("end_date");
		}
		
		ps.close();
		rs.close();
		con.close();
		
		System.out.println(leave+ "leave");

		return leave;
	}
	
	public void approveLeave(String userID) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select leave_count from leave_tracker where empID=?");
		ps.setString(1, userID);
		ResultSet rs=ps.executeQuery();
		int leave_count = 0;
		
		while(rs.next())
		{
			leave_count=rs.getInt("leave_count");
		}
		System.out.println("leave_count : "+leave_count);
		int applied_count=0;
		
		ps=con.prepareStatement("select leave_count from leave_tracker where empID=? and manager_response is null");
		
		while(rs.next())
		{
			applied_count=rs.getInt("leave_count");
		}
		
		System.out.println("applied_count: "+applied_count);
		
		leave_count=leave_count-applied_count;
		ps=con.prepareStatement("UPDATE leave_tracker SET leave_count=? WHERE empID=?");
		ps.setInt(1, leave_count);
		ps.setString(2, userID);
		ps.executeUpdate();
		
		System.out.println("Update Leave Count");
		
		
		ps=con.prepareStatement("UPDATE emp_leave SET leave_status=true,manager_response=true where empID=? and manager_response is null");
		ps.setString(1, userID);
		ps.executeUpdate();
		System.out.println("Update emp_leave");
		ps.close();
		rs.close();
		con.close();
	}
	
	public void denyLeave(String userID) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE emp_leave SET leave_status=false,manager_response=true where empID=? and manager_response is null");
		ps.setString(1, userID);
		ps.executeUpdate();
		
		ps.close();

		con.close();
	}
	
	public ArrayList<String> fetchLeaveResponse(String userID) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select start_date,end_date,leave_count from emp_leave where empID=? and manager_response= 1 and leave_status=1");
		ps.setString(1, userID);
		ResultSet rs=ps.executeQuery();
		ArrayList<String> list=new ArrayList<String>();
		
		
		while(rs.next())
		{
			list.add(rs.getString("start_date")+" to "+rs.getString("end_date")+" :"+rs.getInt("leave_count"));
		}
		
		System.out.println(list);
		
		ps.close();
		rs.close();
		con.close();
		
		return list;
	}
}
