
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Smart Health</title>
</head> 
<body>
<center>
<h4> VIEW FRIENDS</h4>
<br>
<h4> Your Friend list is :-</h4>
<%
String msg = (String)request.getAttribute("frndMsg"); 
if(msg!=null){
	out.println(msg); }%>
<br>
<table border="1">
<c:forEach items="${activeFriends}" var="friend_uname">
<tr>
<td>
<c:out value="${friend_uname}" /><br>
</td>
<td>
<form action = "UnfriendAction" method="get">
<input type="hidden" name="userid" value="${friend_uname}" />
<input type="submit" value="Unfriend" name="Unfriend">
</form>
</td>
</tr>
    
</c:forEach>
</table>
<br>
<form action = "backAction3" method="get">
<input type="submit" value="Back" name="Unfriend">
</form>

</center>
</body>
</html>