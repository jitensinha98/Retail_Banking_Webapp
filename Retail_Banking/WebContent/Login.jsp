<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script>
function validateForm() {
  var x = document.forms["myForm"]["accno"].value;
  var y = document.forms["myForm"]["ifsc"].value;
  var z = document.forms["myForm"]["pass"].value;
  if (x == "" || y == "" || z == "") {
    alert("Field(s) Missing");
    return false;
  }
  else
	  {
	  return true;
	  }
}
</script>
</head>
<body align = "center" bgcolor = "orange">
	<form name="myForm" action ="LoginServlet" method = "post" onsubmit="return validateForm()">
	<h1 style = "font-size:80px;">LOGIN DETAILS</h1>
	<hr width = "70%" align="center">
	<h2>Please enter your login credentials</h2>
		Account Number      :  <input type ="text" name = "accno">
	 	<br><br><br>
	 	IFSC Code     :  <input type ="password" name = "ifsc">
	 	<br><br><br>
	 	Password     :  <input type ="password" name = "pass">
	 	<br><br><br>
	 	<input type = "submit" value = "Login" style = "background-color:blue ; color:white ; width: 120px; height: 60px; font-size:30px">
	 </form>
</body>
</html>