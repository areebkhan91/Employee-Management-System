<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%request.getSession(false);
if(session.getAttribute("userID")!=null)
{
	response.sendRedirect("/PermissionsGrid/Employee/Profile.jsp");
}
%>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

<form action="Register" method="post">
First Name<input type="text" name="fname"><p/>
Last Name<input type="text" name="lname"><p/>
EmailID<input type="text" name="emailID"><p/>
Phone No<input type="text" name="phoneNo"><p/>
Address<input type="text" name="address"><p/>
UserID<input type="text" name="userID" required><p/>
Password<input type="password" name="password"><p/>
<input type="submit" value="Register">
</form>
</body>
</html>