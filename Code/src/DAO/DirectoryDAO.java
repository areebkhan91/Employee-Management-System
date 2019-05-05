package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class DirectoryDAO extends DAO {

	public ArrayList<String> getList(String userID) throws ClassNotFoundException, SQLException
	{
		
		Connection con=getConnection();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("select name from directories where permission='"+"public'");
		ResultSet rs=ps.executeQuery();
		ArrayList<String> permissionlist= new ArrayList<String>();
		ArrayList<String> managerlist= new ArrayList<String>();
		while(rs.next())//add all public directories
		{
			permissionlist.add(rs.getString("name"));
		}
		
	//	while(userID != null)
	//Inferiors:	
		String query="SELECT distinct t1.userID AS lev1, t2.userID as lev2, t3.userID as lev3, t4.userID as lev4, t5.userID as lev5, t5.userID as lev6 FROM register AS t1 LEFT JOIN register AS t2 ON t2.manager = t1.userID LEFT JOIN register AS t3 ON t3.manager = t2.userID LEFT JOIN register AS t4 ON t4.manager = t3.userID LEFT JOIN register AS t5 ON t4.manager = t5.userID LEFT JOIN register AS t6 ON t5.manager = t6.userID where t1.manager=?";
		ps=(PreparedStatement) con.prepareStatement(query);
		ps.setString(1, userID);
		rs=ps.executeQuery();
		String subemp=null;
		while(rs.next())
		{
			for(int i=1;i<=6;i++)
			{
				if(rs.getString("lev"+i)!=null)
				{
	//			permissionlist.add(rs.getString("lev"+i));
				subemp=subemp+",'"+rs.getString("lev"+i)+"'";
				}
			}
		}
		
		
		//Superiors
		query="SELECT t1.manager AS lev1, t2.manager as lev2, t3.manager as lev3, t4.manager as lev4, t5.manager as lev5, t6.manager as lev6 FROM register AS t1 LEFT JOIN register AS t2 ON t1.manager = t2.userID LEFT JOIN register AS t3 ON t2.manager = t3.userID LEFT JOIN register AS t4 ON t3.manager = t4.userID LEFT JOIN register AS t5 ON t4.manager = t5.userID LEFT JOIN register AS t6 ON t5.manager = t6.userID where t1.userID=?";
		ps=(PreparedStatement) con.prepareStatement(query);
		ps.setString(1, userID);
		rs=ps.executeQuery();
		String supemp=null;
		
		while(rs.next())
		{
			for(int i=1;i<=6;i++)
			{
				if(rs.getString("lev"+i)!=null)
				{
		//		managerlist.add(rs.getString("lev"+i));
				supemp=supemp+",'"+rs.getString("lev"+i)+"'";
				}
			}
		}

		 System.out.println(subemp+"\n"+supemp);
		 
		 
		ps=(PreparedStatement) con.prepareStatement("select name from directories where manager in("+subemp+"+?)");
		ps.setString(1, userID);	
		rs=ps.executeQuery();
			while(rs.next())
			{
				managerlist.add(rs.getString("name"));
				
			}
			
		String manager=getManagerID(userID);	
		ps=(PreparedStatement) con.prepareStatement("select name from directories where manager in(?) and restriction=0");
		ps.setString(1, manager);	
		rs=ps.executeQuery();	
		 
		while(rs.next())
		{
			managerlist.add(rs.getString("name"));
			
		}
		 
			return managerlist;
	}
	
	
}
