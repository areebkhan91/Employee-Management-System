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
<title>Info</title>
</head>
<body>
<a href="/PermissionsGrid/Logout.jsp">Logout</a>
<%
String empID=(String)request.getAttribute("empID");
if(empID.equals("null"))
{%>
	
No leaves
<%
}
else
{%>
<form action="/PermissionsGrid/LeaveResponse" method="post">
<input type="text" value=<%=request.getAttribute("leave")%> readonly="readonly"> 
<input type="text" name="empID" value=<%=empID%> readonly="readonly"> 
<input type="submit" id="response" name="response" value=grant >
<input type="submit" id="response" name="response" value=deny>
</form>
<%
}
%>

<form action="/PermissionsGrid/AssignBonus" method="post">
<input type="text" name="userID" value=<%=empID%> readonly="readonly">
<input type="text" name="bonus">
<input type="submit" value="Assign">
</form>
</body>
</html>