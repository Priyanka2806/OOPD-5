<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Smart Health</title>
<style>
.show {}
.hide {display:none}
</style>
</head> 
<body>
<center>
<h3> Sign Up Page!!</h3>
<br><br>
<%
int uType = (int)session.getAttribute("uType"); 
if(uType!=0)%>
	
<br><br>
 <form action = "ProfileCreated" method="get">
<table border="1">
<tr>
<td>Username : 
<input type="text" name="username">
<br>
</td>
<td>
Password : 
<input type="text" name="pwd">
<br>
</td>
</tr>
<tr>
<td>
Primary Email Id : 
<input type="text" name="email1">
<br>
</td>
<td>
Secondary Email Id : 
<input type="text" name="email2">
<br>
</td>
</tr>

<tr>
<td>
First Name : 
<input type="text" name="firstName">
<br>
</td>
<td>
Last Name : 
<input type="text" name="lastName">
<br>
</td>
</tr>
<tr><td>
About Me : 
<input type="text" name="aboutMe">
<br>
</td>
<td>
Postal Address : 
<input type="text" name="address">
<br>
</td>
</tr>
<tr>
<td>
Photo URL 1 : 
<input type="text" name="photo1">
<br></td>
<td>Photo URL 2 : 
<input type="text" name="photo2">
<br>
</td>
</tr>
</table>

 <% if (uType == 4) %>
<table border="1" class="control-label" for="userType_Mod">
<tr>
<td>Contact No : 
<input type="text" name="phone">
<br>
</td>
<td>
Qualification : 
<input type="text" name="qualify">
<br>
</td>
</tr>
</table>

<input type="submit" value="Create Profile" name="done">
</form>

</center>
</body>
</html>