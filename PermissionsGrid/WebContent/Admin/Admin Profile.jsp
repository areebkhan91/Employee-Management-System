
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%request.getSession(false);
if(session.getAttribute("userID")!="admin")
{
	response.sendRedirect("/PermissionsGrid/Welcome.jsp");
}
%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%request.getSession(false);
if(session.getAttribute("userID")!="admin")
{
	response.sendRedirect("/PermissionsGrid/Welcome.jsp");
}
%>
</head>
<body>
<a href="/PermissionsGrid/Logout.jsp">Logout</a><br/>

<form action="/PermissionsGrid/ActiveEmployees" method="post">
<input type="submit" value="Active Employees">
</form>

<form action="/PermissionsGrid/InactiveEmployees" method="post">
<input type="submit" value="Inactive Employees">
</form>

<form action="/PermissionsGrid/RunPayroll" method="post">
<input type="submit" value="RunPayroll">
</form>

</body>
</html>