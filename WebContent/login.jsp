<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/png" sizes="16x16" href="./images/favicon-16x16.png">

<title>GDPR - Data Deletion Request 1.0 - Login Page</title>
<style>

	body {
		background-image: url("./images/background_3.jpg");
		background-color: #cccccc;
		font-size: 15px;
	}
	table {
	  border-collapse: collapse;
	  border: 1px solid gray;	  
	} 
	
	th,td {
	  border: 1px solid black;
	  padding: 10px;
	}
	
	table.a {
	  table-layout: auto;
	  width: 180px;  
	}
	
	table.b {
	  table-layout: fixed;
	  width: 180px;  
	}
	
	table.c {
	  table-layout: auto;
	  width: 100%;  
	}
	
	table.d {
	  table-layout: fixed;
	  width: 50%;  
	  background: ghostwhite;
	  __background-image: url("./images/paper.gif");
	  border-radius: 2%;
	}
	
	input[type=text], input[type=password] {
	  	width: 80%;
	    margin: 3px 0;
	    box-sizing: border-box;
	    outline: none;
		border: 1px solid #ccc;
		border-radius: 4px;
		font-size: 16px;
		background-color: white;
		__background-image: url('searchicon.png');
		background-position: 10px 10px; 
		background-repeat: no-repeat;
		padding: 5px 5px 8px 8px;
	}
	
	.cls-lf-width{
		width: 50%;
	}
</style>
<script>  
	function validateform(){  
		var username = document.loginForm.username.value;  
		var password = document.loginForm.password.value;  
	  	
		username = username.trim();
		password = password.trim();
		
		if (username == null || username == ""){
	  		document.getElementById("result").innerHTML = "Username field can't be blank";
	  		return false;  
		}
		else if(password == null || password == ""){
			document.getElementById("result").innerHTML = "Password field can't be blank";
	  		return false;  
		}
		/*else if(password.length < 4){  
	  		alert("Password must be at least 4 characters long.");  
	  		return false;
	  	}*/
	}  
</script> 
</head>
<body>
	
	<form action="login" method="POST" name="loginForm" onsubmit="return validateform()">
	    <table align="center" class="d">
	    <tr>
	        <td colspan="2" style="font-style: italic; font-size:20px; color: blue; text-align:center;">GDPR - Data Deletion Request 1.0</td>
	      </tr>
	    
	      <tr>
	        <td class="cls-lf-width">Username:</td>
	        <td><input type="text" name="username" value=""></td>
	      </tr>
	      <tr>
	        <td class="cls-lf-width">Password:</td>
	        <td><input type="password" name="password"></td>
	      </tr>
	      <tr>
	        <td class="cls-lf-width"></td>
	        <td align="left"><input type="submit" value="Login" ></td>
	      </tr>
	      <tr>
	      <td  class="cls-lf-width" id="result" colspan="2" style="font-style: italic; color: red;">${message}</td>
	    </tr>
	    </table>
  </form>
	
</body>
</html>