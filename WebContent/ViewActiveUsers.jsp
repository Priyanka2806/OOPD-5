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
<h4> View Withdrawal List</h4>
<br>
<h4> Details of the User, you send Friend Requests that are not yet responded, are:</h4>
<%
String msg = (String)request.getAttribute("userMsg"); 
if(msg!=null){
	out.println(msg); }%>
<br>
<table border="1">
<c:forEach items="${sendRequestList}" var="friend_uname">
<tr>
<td>
<c:out value="${friend_uname}" /><br>
</td>
<td>
<form action = "SendAction" method="get">
<input type="hidden" name="frnd_id" value="${friend_uname}" />
<input type="submit" value="Send Request" name="sendPage">
</form>
</td>
</tr>
    
</c:forEach>
</table>
<br>
<form action = "backAction321" method="get">
<input type="submit" value="Back" name="sendPage">
</form>


</center>
</body>
</html>