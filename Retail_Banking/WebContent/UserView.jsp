<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Retail Banking</title>
<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
  color: white;
}

.header-right {
  float: right;
}
.card {
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  width: 40%;
  margin-left:30%;
  margin-top:6%;
  background-color:white;
  border-radius: 15px;
}
* {
  box-sizing: border-box;
}


.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}
.card1 {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  padding: 16px;
  text-align: center;
  background-color: #f1f1f1;
}
.column {
  float: left;
  width: 30%;
  padding: 0 10px;
}

.row {margin: 0 -5px;}

.row:after {
  content: "";
  display: table;
  clear: both;
}



</style>
<script>
function validateBalance() {
    alert("Displaying Balance ");
    return true;
}
function validateWithdraw() {
    alert("Withdrawing Money ");
    return true;
}
function validateDeposit() {
    alert("Depositing Money ");
    return true;
}
</script>
</head>
<body style="background-color:#DECCCC">
<div class="header">
  <b><a href="#default" >Retail Banking</a></b>
  <div class="header-right">
    <a href="LogoutServlet">Logout&nbsp;<i class="fa fa-sign-out"></i></a>
     </div>
</div>

<div style="background-color: yellow;"><marquee>Welcome to our Retail Banking.We give 24x7 hrs support to our customer.</marquee></div>
<div style="background-color: black;margin-top:60px;">

<h2 style="margin-left:70px;color:white;">Personal Details :</h2>
</div>
<div class="card">
<br>
  <h5 style="margin-top:5px;">&nbsp;&nbsp;Account Holder Name: ${full_name}</h5>
  <h5>&nbsp;&nbsp;Country: ${Country}</h5>
    <h5>&nbsp;&nbsp;City: ${City}</h5>
  <h5>&nbsp;&nbsp;Phone Number: ${Phone_Number}</h5>
  <h5>&nbsp;&nbsp;Account Number: ${Account_no}</h5>
  <h5>&nbsp;&nbsp;IFSC Code: ${IFSC}</h5>
  <br>
</div>

<div style="background-color: black;margin-top:70px;">

<h2 style="margin-left:70px;color:white;">Our Services :</h2>
</div>

<div class="row" style="margin-left:8%;margin-top:5%;">
  <div class="column">
    <div class="card1">
    <form action ="DepositServlet" method = "post" onsubmit="return validateDeposit()">
      <h3>Deposit Amount</h3> <br> 
      	<input type ="text" name = "deposit_amount"> <br> <br>
          <input type = "submit" value = "Deposit">
    </form>
    </div>
  </div>

  <div class="column">
    <div class="card1">
    <form action ="WithdrawServlet" method = "post" onsubmit="return validateWithdraw()">
      <h3>Withdraw Amount</h3>
      <br> 
      <input type ="text" name = "withdraw_amount"> <br> <br>
      <input type = "submit" value = "Withdraw">
      </form>
    </div>
  </div>
  
  <div class="column">
    <div class="card1">
    <form action ="BalanceServlet" method = "post" onsubmit="return validateBalance()">
      <h3>View Balance</h3>
       <br> 
       <% Object ob = request.getAttribute("Balance_Amount");
       if(ob == null)
       {
    	out.println("Your Balance will appear here.");
       }
       else
       {	   
       out.println(ob);
       }%>
       <br> <br>
       <input type = "submit" value = "View Balance">
       </form>
    </div>
  </div>
</div>
<br>
<br>
<br>
<br>
<div style="background-color:gray;"><br><br><br>
<center><b style=""> ©Copyright from 2020-21</b></center>
<br>
<center><b style="">All rights reserved.</b></center>

<br><br>
</div>

</body>
</html>