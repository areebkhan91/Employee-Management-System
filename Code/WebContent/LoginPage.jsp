<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%request.getSession(false);
if(session.getAttribute("userID")!=null)
{
	response.sendRedirect("/PermissionsGrid/Employee/Profile.jsp");
}
%>
<title>Home</title>
</head>
<body>
<form method="post" action="/PermissionsGrid/Login">
Login<input type="text" name="userID">
Password<input type="password" name="password">
<input type="submit" value="Log In">
</form>
</body>
</html>