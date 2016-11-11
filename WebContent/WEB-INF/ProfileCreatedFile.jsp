
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Smart Health</title>
</head> 
<body>
<center>
<h3> PROFILE CREATED SUCCESSFULLY !!</h3>
<br><br>
<form action = "Login" method="get" target="_self">
<h4> Your profile has been created successfully. Please Login to continue or click Later to exit.</h4>
<br><br>
<input type="submit" value="Login" name="button">
</form>
<form action = "Later" method="get">
<br><br>
<input type="submit" value="Later" name="button">
</form>
<form>
<br><br>
<%
String msg = (String)request.getAttribute("msg"); 
if(msg!=null){
	out.println(msg); }%>
<br><br>
</form>
<br>
</center>
</body>
</html>