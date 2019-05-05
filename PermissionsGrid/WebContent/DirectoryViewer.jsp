<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
request.getSession(false);
ArrayList<String> directories=(ArrayList<String>)session.getAttribute("directories");
out.print(directories);
Iterator<String> iterator = directories.iterator();
request.getAttribute("userID");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%


response.setContentType("text/html");

while (iterator.hasNext()) 
{
%>
<form action="DirectoryView" method="post">
<input type="text" name="directory" value=<%out.println(iterator.next());%> >
<input type="submit" value="View">
</form>

<%
}
%>
</body>
</html>