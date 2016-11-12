
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Smart Health</title>
</head>
<body>
<center>
<h4> VIEW PENDING FRIEND REQUESTS</h4>
<br>
<h4> Your Pending Friend Requests are:</h4>
<%
String msg = (String)request.getAttribute("pfrMsg"); 
if(msg!=null){
	out.println(msg); }%>
<br>
<c:forEach items="${pendingFriends}" var="friend_uname">
<table border="1">
<tr>
<td>
<c:out value="${friend_uname}" />
</td>
<td>
<form action = "acceptAction" method="get" target="_self">
<input type="hidden" name="uid" value="${friend_uname}" />
<input type="submit" value="Accept Friend Request" name="AcceptRejectRequest">
</form>
</td>
<td>
<form action = "rejectAction" method="get">
<input type="hidden" name="uid" value="${friend_uname}" />
<input type="submit" value="Reject Friend Request" name="AcceptRejectRequest">
</form>
</td>
</tr>
</table>    
</c:forEach>

<br>
<form action = "backAction4" method="get">
<input type="submit" value="Back" name="AcceptRejectRequest">
</form>


</center>
</body>
</html>