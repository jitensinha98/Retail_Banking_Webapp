<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<script type="text/javascript">
function validateForm() {
  var First_Name = document.forms["myForm"]["fname"].value;
  var Last_Name = document.forms["myForm"]["lname"].value;
  var accno = document.forms["myForm"]["accno"].value;
  var ifsc = document.forms["myForm"]["ifsc"].value;
  var pass = document.forms["myForm"]["pass"].value;
  var dob = document.forms["myForm"]["dob"].value;
  var Gender = document.forms["myForm"]["gender"].value;
  var City = document.forms["myForm"]["city"].value;
  var Country = document.forms["myForm"]["country"].value;
  var phone = document.forms["myForm"]["phone"].value;
  var email = document.forms["myForm"]["email"].value;
  
  if (First_Name == "" || pass == "" || Last_Name == "" || accno == "" || ifsc == "" ||  dob == "" || Gender == "" || City == "" || Country == "" || phone == "" || email == "" ) 
	{
    alert("Field(s) missing");
    return false;
	}
  else
	  {
	  alert("Press OK to Submit");
	  return true;
	  }
	}
</script>
</head>
<body align="center" bgcolor = "lightblue">
	<h1 style = "font-size:50px;">REGISTRATION FORM</h1>
	<hr width = "50%" align="center">
	<br><br>
	<form name = "myForm" action = "RegistrationServlet" method ="POST" onsubmit="return validateForm()">
	<input type = "hidden" name ="source" value ="addcustomer">
	 First Name    :  <input type ="text" name="fname"/>
	<br><br><br>
	 Last Name     :  <input type ="text" name ="lname"/>	 
	<br><br><br>
	 Account Number      :  <input type ="text" name = "accno">
	 <br><br><br>
	 IFSC Code      :  <input type ="password" name = "ifsc">
	 <br><br><br>
	 Password      :  <input type ="password" name = "pass">
	 <br><br><br>
	 Date Of Birth(dd/mm/yyyy) : <input type= "text" name ="dob"/> 
	<br><br><br>
	 Gender        : <input type = "radio" name ="gender" value ="male"> Male
		<input type ="radio" name = "gender" value="female">Female
	<br><br><br>
	 City          : <input type ="text" name ="city"/>
	<br><br><br>
	 Country       : <input type ="text" name = "country"/>
	<br><br><br>
	 Phone No.     :<input type ="text" name ="phone"/>
	<br><br><br>
	 Email         : <input type ="text" name ="email"/>
	<br><br><br>
	
	<input type ="submit" value ="Submit" >
	<input type = "reset" value = "Reset" >
	<br><br><br>
		
	</form>
</body>
</html>