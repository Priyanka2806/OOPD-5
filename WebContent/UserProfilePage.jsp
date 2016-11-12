
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
<h3> USER PROFILE PAGE</h3>
<br><br>
<%= session.getAttribute("message") %>
<br>
<form action = "UserPage" method="get">
<table border="1">
<tr>
<td>Username : </td>
<td> 
<%= session.getAttribute("NAME") %>
<br>
</td>
</tr>
<tr>
<td>
Password : </td>
<td>
<%= session.getAttribute("PASSWORD") %>
<br>
</td>
</tr>
<tr>
<td>
Primary Email Id : 
</td>
<td><%= session.getAttribute("PRIMARY ID") %>
<br>
</td>
</tr>
<tr>
<td>
Secondary Email Id : </td>
<td>
<%= session.getAttribute("SECONDARY ID") %>
<br>
</td>
</tr>

<tr>
<td>
First Name : </td>
<td>
<%= session.getAttribute("FIRST NAME") %>
<br>
</td>
</tr>
<tr>
<td>
Last Name : </td>
<td>
<%= session.getAttribute("LAST NAME") %>
<br>
</td>
</tr>
<tr><td>
About Me : </td>
<td> 
<%= session.getAttribute("ABOUT ME") %>
<br>
</td>
</tr>
<tr>
<td>
Postal Address : </td>
<td>
<%= session.getAttribute("POSTAL AREA") %>
<br>
</td>
</tr>
</table>
<br><br>
</form>
<table>
<tr>
<td>
<form action = "updateAction" method="get" >
<input type="submit" value="Update Profile" name="UserOptions">
</form>
</td>
<td>
<form action = "deleteAction" method="get" >
<input type="submit" value="Delete Profile" name="UserOptions">
</form>
</td>
</tr>
</table>
<br>

<table>
<tr>
<td>
<form action = "viewFriendsAction" method="get" >
<input type="submit" value="View Friends" name="UserOptions">
</form>
</td>
<td>
<form action = "viewPendingRequestsAction" method="get" >
<input type="submit" value="View Pending Friend Requests" name="UserOptions">
</form>
</td>
</tr>
<tr>
<td>
<form action = "viewActiveUsersAction" method="get" >
<input type="submit" value="Send Friend Request" name="UserOptions">
</form>
</td>
<td>
<form action = "withdrawlistAction" method="get" >
<input type="submit" value="Withdraw Friend Requests" name="UserOptions">
</form>
</td>
</tr></table>

<br>
<form action = "logoutAction" method="get" >
<input type="submit" value="Logout" name="UserOptions">
</form>
</center>
</body>
</html>