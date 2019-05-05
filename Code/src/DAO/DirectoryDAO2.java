package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DirectoryDAO2 extends DAO {

	public ArrayList<String> getList(String userID) throws ClassNotFoundException, SQLException
	{
		Connection con=(Connection) getConnection();

		PreparedStatement ps=(PreparedStatement) con.prepareStatement("select name from directories where manager=1");

		ResultSet rs=ps.executeQuery();	
		ArrayList<String> directories=new ArrayList<String>();
		
		while(rs.next())
		{
			directories.add(rs.getString("name"));
			
		}
		 
		ps.close();
		rs.close();
		con.close();
		
			return directories;
	}

	public ArrayList<String> getContents(String directory_id, String userID) throws ClassNotFoundException, SQLException {
		ArrayList<String> contents=new ArrayList<String>();
		Connection con=(Connection) getConnection();
		String query = null;
		String manager=null;
		String owner=getDirectoryOwner(directory_id);
		manager=getManagerID(userID);
		boolean activate=true;
		System.out.println(owner+" "+manager);
		if(userID.equals("1"))//i am root
		{
			query="select name from directories where parent=?";
		//	System.out.println("ceo");
		}

		else if(checkSuperManagers(userID, directory_id))//if i am the supermanager
		{
			//show everything
			System.out.println("superowner");
			query="select name from directories where parent=?";
		}
		
		else if(getManagerID(manager).equals(owner)) //if i am the immediate employee
		{
			activate=false;
			System.out.println("show something");
			query="select name from directories where restriction=0 and manager=?";
		}
		
		else if(owner.equals(userID))//if i am the owner
		{
			System.out.println("owner");
			//show everything
			query="select name from directories where parent=?";
		}
		else if(manager.equals(owner))// immediate manager is the owner
		{
			query="select name from directories where parent=?";
		}
		else 
		{	System.out.println("show nothing");
			//show nothing, only public
			query="select name from directories where permission='"+"public'"+" and parent=?";
		}
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);
		
		if(activate)
		{
			ps.setString(1, directory_id);	
		}
		else //different query for immediate sub-employee
		{
			ps.setString(1, manager);
		}
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			contents.add(rs.getString("name"));
		}
		System.out.println("Contents: "+contents);
		return contents;
	}
	
	public String getDirectoryOwner(String directory_id) throws ClassNotFoundException, SQLException
	{
		String owner=null;
		Connection con=(Connection) getConnection();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("select manager from directories where name=?");
		ps.setString(1, directory_id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			owner=rs.getString("manager");
		}
		return owner;
		
	}
	
	public boolean checkSuperManagers(String userID,String directory_id) throws ClassNotFoundException, SQLException
	{
		String owner=getDirectoryOwner(directory_id);
		ArrayList<String> supers=new ArrayList<String>();
		Connection con=(Connection) getConnection();
		String query="SELECT t1.manager AS lev1, t2.manager as lev2, t3.manager as lev3, t4.manager as lev4, t5.manager as lev5, t6.manager as lev6 FROM register AS t1 LEFT JOIN register AS t2 ON t1.manager = t2.userID LEFT JOIN register AS t3 ON t2.manager = t3.userID LEFT JOIN register AS t4 ON t3.manager = t4.userID LEFT JOIN register AS t5 ON t4.manager = t5.userID LEFT JOIN register AS t6 ON t5.manager = t6.userID where t1.userID=?";
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);
		ps.setString(1, owner);//get superiors of owner
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			for(int i=1;i<=6;i++)
			{
				if(rs.getString("lev"+i)!=null)
				{
				supers.add(rs.getString("lev"+i));
				}
			}

		}
		System.out.println(supers);
		boolean check=supers.contains(userID);//check if i am the superior
		return check;
	}
	
}
