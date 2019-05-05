<%@page import="POJO.RegistrationPOJO"%>
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
<title>Profile</title>
</head>
<body>
<a href="/PermissionsGrid/Logout.jsp">Logout</a>
<%	POJO.RegistrationPOJO rp=new POJO.RegistrationPOJO();
	rp=(POJO.RegistrationPOJO)session.getAttribute("details");
%>
<p/>
Name : <%=(rp.getFname())%><p/>
EmailiD :<%=(rp.getEmailID()) %><p/>
Phone No :<%=(rp.getPhoneNo())%><p/>



<form action="/PermissionsGrid/Employee/updateProfile.jsp">
<input type="submit" value="Edit Details">
</form>

<form action="/PermissionsGrid/Manager" method="post">
<input type="submit" value="Sub Employees">
</form>
<a href="/PermissionsGrid/Employee/Leave.jsp">Leave</a><br>
<a href="/PermissionsGrid/Directory.jsp">Directories</a>
</body>
</html>