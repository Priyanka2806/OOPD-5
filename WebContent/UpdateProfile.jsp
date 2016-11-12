
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
<h3> UPDATE PROFILE PAGE</h3>
<br>
<h4> Profile Details:</h4>
<br>
<form action = "UpdatePage" method="get">

<table border="1">
<tr>
<td> 
<input type="radio" name="updateSelection" value="1">Username : 
<%= session.getAttribute("NAME") %>
<br>
</td>
</tr>
<tr>
<td>
<input type="radio" name="updateSelection" value="2">Password : 
<%= session.getAttribute("PASSWORD") %>
<br>
</td>
</tr>
<tr>
<td>
<input type="radio" name="updateSelection" value="3">Primary Email Id : 
<%= session.getAttribute("PRIMARY ID") %>
<br>
</td>
</tr>
<tr>
<td>
<input type="radio" name="updateSelection" value="4">Secondary Email Id : 
<%= session.getAttribute("SECONDARY ID") %>
<br>
</td>
</tr>
<tr>
<td>
<input type="radio" name="updateSelection" value="5">First Name : 
<%= session.getAttribute("FIRST NAME") %>
<br>
</td>
</tr>
<tr>
<td>
<input type="radio" name="updateSelection" value="6">Last Name : 
<%= session.getAttribute("LAST NAME") %>
<br>
</td>
</tr>
<tr><td>
<input type="radio" name="updateSelection" value="7">About Me : 
<%= session.getAttribute("ABOUT ME") %>
<br>
</td>
</tr>
<tr>
<td>
<input type="radio" name="updateSelection" value="9">Postal Address : 
<%= session.getAttribute("POSTAL AREA") %>
<br>
</td>
</tr>
</table>
<br>
Enter New Value :
<input type="text" name="new_value">
<br><br>
<input type="submit" value="Update" name="UpdateOption">
</form>
<br>
<%
String updMsg = (String)request.getAttribute("updateMsg"); 
if(updMsg!=null){
	out.println(updMsg); }%>
	
<br>
<form action = "backAction1" method="get">
<input type="submit" value="Back" name="UpdateOption">
</form>
</center>
</body>
</html>