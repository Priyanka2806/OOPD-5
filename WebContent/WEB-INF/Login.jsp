
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
<h3> LOGIN PAGE!!</h3>
<br><br>
<form action = "UserProfilePage" method="get" target="_self">
Login ID : 
<input type="text" name="emailId">
<br><br>
Password : 
<input type="text" name="password">
<br><br>
<input type="submit" value="Login" name="button">
</form>
<br>
<form >
<br>
<%
String msg = (String)request.getAttribute("message"); 
if(msg!=null){
	out.println(msg); }%>
<br><br>
<%
String delMsg = (String)request.getAttribute("deleteMsg"); 
if(delMsg!=null){
	out.println(delMsg); }%>
<br>
</form>
<form action = "SignUp" method="get">
New User??
<br><br>
<input type="submit" value="Sign Up" name="button">
</form>
</center>
</body>
</html>