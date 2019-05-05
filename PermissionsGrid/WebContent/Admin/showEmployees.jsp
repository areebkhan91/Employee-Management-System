<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>    
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
<title>Show Details</title>
</head>
<body>
<a href="/PermissionsGrid/Logout.jsp">Logout</a>
<%
ArrayList<String> list = (ArrayList<String>) session.getAttribute("activelist");

Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) 
{
%>
<form action="/PermissionsGrid/AdminDetailEditor" method="post">
<input type="text" name="userID" value=<%out.println(iterator.next());%> readonly="readonly">
<input type="text" name="fname" value=<%out.println(iterator.next());%>  readonly="readonly">
<input type="text" name="lname" value=<%out.println(iterator.next());%>  readonly="readonly">
<input type="submit" value="Edit">
</form>

<%
}
%>
</body>
</html>