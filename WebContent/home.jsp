<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<% 
	//Prevent back button on the browser to remove cache with all the older versions as well
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 - earlier versions
	response.setHeader("Expires", "0"); //Proxy servers
	
	if(session.getAttribute("username") == null)
	{
		response.sendRedirect("login.jsp");
	}
%>
	Welcome <b>${username}</b>, to Home page after logging in to the application
	<br />
	<br />
	<iframe width="560" height="315" src="https://www.youtube.com/embed/gQLQ0t9B5yk" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	<br /> <br />
	
	<form action="logout" method="get">
		<input type="submit" value="Logout" >
	</form>
</body>
</html>