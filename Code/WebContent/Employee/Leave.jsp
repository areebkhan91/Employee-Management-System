<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leave</title>
<%request.getSession(false);
if(session.getAttribute("userID")==null)
{
	response.sendRedirect("/PermissionsGrid/Welcome.jsp");
}
%>
</head>
<body>
<a href="/PermissionsGrid/Logout.jsp">Logout</a>
<form action="/PermissionsGrid/Leave" method="post">
  Start Date
  <input type="date" name="start_date">
  End date
   <input type="date" name="end_date"><p/>
  <input type="submit" value="Apply">
</form>

<form action="/PermissionsGrid/LeaveFetcher" method="post">
<input type="submit" value="Show approved leaves">
</form>
</body>
</html>