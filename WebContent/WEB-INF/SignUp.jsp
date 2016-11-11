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
<form action = "FillDetails" method="get">
  <label class="control-label ">
   Select User Type!!
  </label>
  <br>
  <br>
	 <input name="userType" type="radio" value="1">
	 User
	 <br><input name="userType" type="radio" value="4">
	 Moderator
	 
	<br><br>
	<br><button class="btn btn-primary " name="submit1" type="submit" value="proceed">
	Proceed
   </button>
 </form>

</center>
</body>
</html>