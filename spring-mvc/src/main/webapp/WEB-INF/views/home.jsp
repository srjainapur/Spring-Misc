<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>JKart</title>
<style>
/* table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 0px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
} */

.button {
  background-color: orange;
  border: none;
  color: white;
  padding: 15px 135px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.signupbutton {
  background-color: orange;
  border: none;
  color: white;
  padding: 15px 73px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.forgotbutton {
  background-color: orange;
  border: none;
  color: white;
  padding: 15px 125px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>

<script>
function showLoginOrSignup() {
  var x = document.getElementById("loginOrSignup");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
</script>

</head>
<body>
	<%-- <h1>Hello world!</h1>
	<P>The time on the server is ${serverTime}.</P> --%>
	<form action="loginController" method="POST">
		<table width="100%">
			<tr bgcolor="#33a5ff" height="50px">
				<td>
					<table align="center">
						<tr>
							<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
							<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>						
							<td>JKart</td>
							<td>&nbsp;<input type="text" name="search" size="70"/></td>
							<td><a href="#" onclick="showLoginOrSignup()">Login</a>&nbsp;Welcome :- ${message}</td>
							<td><a href="">Signup</a> </td>
							<td><a href="">More</a> </td>
							<td><a href="">Cart</a> </td>
						</tr>
					</table>
				</td>
			</tr>
			<tr bgcolor="white" height="50px" >
				<td>
					<table border="1" width="100%">
						<tr>							
							<td><a href="">Electronics</a></td>
							<td><a href="">TVs & Appliances</a></td>
							<td><a href="">Men</a></td>
							<td><a href="">Women</a></td>
							<td><a href="">Baby & Kids</a></td>
							<td><a href="">Home & Furniture</a></td>
							<td><a href="">Sports, Books & More</a></td>
							<td><a href="">Grocery</a></td>
							<td><a href="">Offer Zone</a></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table width="300" height="300" style="border: 0px solid black;display:none" id="loginOrSignup">
			<tr >
				<td>
					<table width="50" height="300" bgcolor="#33a5ff">
						<tr>
							<td>Login</td>							
						</tr>
						<tr>
							<td>&nbsp;</td>							
						</tr>
						<tr>
							<td>Get access to your</td>
						</tr>
						<tr>
							<td>Orders, Wishlist</td>
						</tr>
						<tr>
							<td>and Recommendations</td>
						</tr>
					</table>
				</td>
				<td>
					<table width="250" height="300" bgcolor="white">
						<tr><td>Enter Email / Mobile Number</td></tr>
						<tr><td><input type="text" size="40" name="username"/></td></tr>
						<tr><td>Password</td></tr>
						<tr><td><input type="password" size="40" name="password"/></td></tr>
						<tr><td align="center"><input type="submit" class="button" value="Login"/></td></tr>
						<tr><td align="center"><input type="submit" class="forgotbutton" value="Forgot ?"/></td></tr>
						<tr><td align="center"><input type="submit" class="signupbutton" value="New to JKart ? Sign up"/></td></tr>
					</table>
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>
