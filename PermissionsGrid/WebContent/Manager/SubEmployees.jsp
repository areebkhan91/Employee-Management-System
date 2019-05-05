<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>     
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
<title>Insert title here</title>
</head>
<body>
<a href="/PermissionsGrid/Logout.jsp">Logout</a>
<%
ArrayList<String> list= (ArrayList<String>) session.getAttribute("employeelist");
response.setContentType("text/html");
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) 
{
%>
<form action="/PermissionsGrid/ManagerFetchEmp" method="post">
<input type="text" name="userID" value=<%out.println(iterator.next());%> >
<input type="submit" value="Edit">
</form>

<%
}
%>
</body>
</html>