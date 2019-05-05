<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%request.getSession(false);
if(session.getAttribute("userID")!=null)
{
	response.sendRedirect("/PermissionsGrid/Employee/Profile.jsp");
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<a href="LoginPage.jsp">Login</a><br>
<a href="Register.jsp">Register</a>

</body>
</html>