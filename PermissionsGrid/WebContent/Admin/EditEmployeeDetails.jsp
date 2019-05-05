<%@page import="POJO.adminDetailsPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%request.getSession(false);
if(session.getAttribute("userID")!="admin")
{
	response.sendRedirect("/PermissionsGrid/Welcome.jsp");
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Employee Details</title>
</head>
<body>
<a href="/PermissionsGrid/Logout.jsp">Logout</a>
<%	
	POJO.adminDetailsPOJO rp=new POJO.adminDetailsPOJO();
	rp=(POJO.adminDetailsPOJO)session.getAttribute("details");
	String userID=rp.getUserID();
%>
<form action="/PermissionsGrid/AdminEditor2" method="post">
User ID<input type="text" name="userID" value=<%= rp.getUserID() %> ><p/>
Manager<input type="text" name="manager" value=<%= rp.getManager()%> ><p/>
Department<input type="text" name="department" value=<%= rp.getDepartment() %>><p/>
Role<input type="text" name="role" value=<%= rp.getRole() %> ><p/>
Wage<input type="text" name="wage" value=<%= rp.getWage() %> ><p/>
<input type="submit" value="Update">
</form>
</body>
</html>