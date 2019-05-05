package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO extends DAO {


	public boolean checkLogin(POJO.LoginPOJO login) throws ClassNotFoundException, SQLException{
	Connection con=getConnection();
	PreparedStatement ps = con.prepareStatement("select * from register where userID=? and password=?");
	ps.setString(1, login.getUserID());
	ps.setString(2, login.getPassword());
	ResultSet rs=ps.executeQuery();
	boolean flag = false;
	flag=rs.next();
	ps.close();
	rs.close();
	con.close();
	return flag;
	}
}
