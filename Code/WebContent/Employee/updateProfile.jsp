<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%request.getSession(false);
if(session.getAttribute("userID")==null)
{
	response.sendRedirect("/PermissionsGrid/Welcome.jsp");
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
</head>
<body>
<a href="/PermissionsGrid/Logout.jsp">Logout</a>
<%	
	POJO.RegistrationPOJO rp=new POJO.RegistrationPOJO();
	rp=(POJO.RegistrationPOJO)session.getAttribute("details");
	String userID=(String) session.getAttribute("userID");
%>
<form action="/PermissionsGrid/updateDetails" method="post">
First Name<input type="text" name="fname" value=<%= rp.getFname() %>><p/>
Last Name<input type="text" name="lname" value=<%= rp.getLname() %>><p/>
EmailID<input type="text" name="emailID" value=<%= rp.getEmailID() %>><p/>
Phone No<input type="text" name="phoneNo" value=<%= rp.getPhoneNo() %>><p/>
Address<input type="text" name="address" value=<%= rp.getAddress() %>><p/>
UserID<input type="text" name="userID" value=<%= userID %>><p/>
Password<input type="password" name="password"><p/>
<input type="submit" value="Update">
</form>
</body>
</html>