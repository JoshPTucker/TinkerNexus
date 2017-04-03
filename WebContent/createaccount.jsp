<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
<script>
	function validateNewAccount() {
		// http://stackoverflow.com/a/46181/11236
		var email = $('#email').val();
		var name = $('#username').val();
		name = (username != '');

		// check to see if a user name was entered
		if (name) {
			alert("You forgot to enter your name");				
		} 

		// check the email
		var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		var goodemail = re.test(email);
		if (goodemail == false)
			alert("Invalid Email! "+email);

		// check the password and restrict the length to 4 - 15 characters
		// the passsword must be lower case, upper case or a number
		var password = $('#password').val();
		var pword = new RegExp(/^[a-zA-Z0-9]{4,15}$/)
		goodpassword = pword.test(password)
		if (!goodpassword) {
			alert("Invalid Password! "+password);
		}

		return (goodpassword && goodemail);
	}	
</script>
</head>
<body>
	<h4>Create Account</h4>

	<form action="CreateAccount" method="post">		
		<p>Enter your user name</p>
		<input type="text" name="username" id="username" value=""></input> 
			<p>Enter your first name</p>
		<input type="text" name="firstname" id="firstname" value=""></input> 
			<p>Enter your last name</p>
		<input type="text" name="lastname" id="lastname" value=""></input> 
			<p>Enter your address</p>
		<input type="text" name="address" id="address" value=""></input> 
			<p>Enter your zipcode</p>
		<input type="text" name="zipcode" id="zipcode" value=""></input> 
		<p>Enter your email</p>
		<input type="text" name="useremail" id="useremail" value=""></input> 
		<p>Enter your password</p>
		<input type="password" name="password" id="password" value=""></input>
		<input type="hidden" name="action" id="action" value="createaccount"></input>
		<input type="submit" name="submit" id="submit" value="Submit"></input>
	</form>	
</body>
</html>