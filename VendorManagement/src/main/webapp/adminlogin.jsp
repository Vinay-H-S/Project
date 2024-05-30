<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
	font-family: sans-serif;
}

body {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	background-color: #fffe;
}

.container {
	max-width: 550px;
	padding: 28px;
	margin: 0 28px;
	box-shadow: 0 25px 30px #ABB2B9;
	margin-top: 55px;
}

h2 {
	font-size: 26px;
	font-weight: 600;
	text-align: left;
	color: #2f4f4f;
	border-bottom: 1px solid silver;
}

.content {
	justify-content: space-between;
	padding: 20px 0;
}

.input-box {
	display: flex;
	flex-wrap: wrap;
	width: 50%;
	padding-bottom: 15px;
}

.input-box input {
	height: 40px;
	width: 95%;
	padding: 0 10px;
	border-radius: 5px;
	outline: none;
}

.input-select {
	height: 40px;
	width: 95%;
	padding: 0 10px;
	border-radius: 5px;
	outline: none;
}

.input-box input:is(focus, :valid) {
	box-shadow: 0 3px 6px rgba(0, 0, 0, 0.2);
}

.button-container {
	margin: 15px 0;
}

.button-container button {
	margin-left: 25px;
	margin-top: 50px;
	padding: 10px;
	display: block;
	font-size: 20px;
	color: #fff;
	border: none;
	width: 100%;
	border-radius: 5px;
	background-image: linear-gradient(to right, #aa076b, #610456);
}

.err {
	color: red;
	font-family: monospace;
	margin-left: 25px;
}

.navbar {
	background-image: linear-gradient(to right, #aa076b, #610456);
	background-size: cover;
}

.nav-link:hover {
	background-color: black;
	background-size: cover;
	border-radius: 12px;
	text-transform: uppercase;
}

#userErrMsg, #passErrMsg {
	font-size: 14px;
	font-weight: 550;
}

.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
}

.display {
	font-weight: 600;
	margin-bottom: 0;
}
</style>
</head>

<body>
	<nav class="navbar fixed-top navbar-expand-lg  navbar-dark p-md-3">

		<a href="#" class="navbar-brand pt-2">Vendor Management</a>
		<button type="button" class="navbar-toggler" data-bs-target="#navbar"
			data-bs-toggle="collapse" aria-controls="navbar" aria-expanded="true"
			aria-label="Toggle Navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbar">
			<div class="mx-auto"></div>
			<ul class="navbar-nav">
				<li class="nav-item"><a href="home.jsp"
					class="nav-link text-white">Home</a></li>
			</ul>
		</div>

	</nav>

	<div class="container">
		<!-- Navbar -->

		<form action="admincontrol" method="post">
			<h2>ADMIN LOG-IN</h2>
			<div class="content">

				<!--  USER NAME FOR LOGIN -->

				<div class="input-box">
					<label>User Name</label> <input type="text" name="userName"
						onblur="uniqueUserName()" id="userName" /> <Span id="userErrMsg"
						style="color: red"></Span>

				</div>

				<!-- PASSWORD FOR LOGIN -->

				<div class="input-box">
					<label>Password</label> <input type="password" name="password"
						onblur="correctPassword()" id="password" /> <Span id="passErrMsg"
						style="color: red"></Span>

				</div>


				<button type="submit" class="btn btn-primary" id="button"
					disabled="disabled">Log in</button>

			</div>

		</form>

	</div>
	<script type="text/javascript">
	
	//USERNAME AJAX
	function uniqueUserName() {
    const userName = document.getElementById("userName").value;
    const loginBtn = document.getElementById("button");

    if (userName == "") {
        document.getElementById("userErrMsg").innerHTML = "*UserName cant't be empty";
        console.log("*UserName cant't be empty");
        loginBtn.setAttribute("disabled", "");

    } else if (userName.length < 6 || userName.length > 15) {
        document.getElementById("userErrMsg").innerHTML = "*UserName Should be in character";
        console.log("*UserName Should be in min-4 & max-15");
        loginBtn.setAttribute("disabled", "");
    } else if (userName != "") {
        const xhttp = new XMLHttpRequest();
        xhttp.open("GET",
            "http://localhost:8080/VendorManagement/userAjax/"
            + userName);
        xhttp.send();

        xhttp.onload = function () {
            const response = document.getElementById("userErrMsg").innerHTML = this.responseText;
            loginBtn.setAttribute("disabled", "");
        }

    }

}

	//PASSWORD AJAX

	function correctPassword() {
	    const password = document.getElementById("password").value;
	    const loginBtn = document.getElementById("button");

	    if (password == "") {
	        document.getElementById("passErrMsg").innerHTML = "*Password can't be empty";
	        console.log("*UserName cant't be empty");
	        loginBtn.setAttribute("disabled", "");
	    } else if (password.length < 5 || password.length > 15) {
	        document.getElementById("passErrMsg").innerHTML = "*Password should be in character";
	        loginBtn.setAttribute("disabled", "");
	        console.log("*UserName cant't be empty");
	    } else if (password != "") {

	        const xhttp = new XMLHttpRequest();

	        xhttp.open("GET", "http://localhost:8080/VendorManagement/passwordAjax/" + password);
	        xhttp.send();

	        xhttp.onload = function () {
	            const response = document.getElementById("passErrMsg").innerHTML = this.responseText;
	            console.log("*Response Text");
	            if (response == "") {
	                loginBtn.removeAttribute("disabled");
	            } else {
	                loginBtn.setAttribute("disabled", "");
	            }

	        }
	    }
	}
	
	
    
	
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>

	<footer class="footer">
		<div class="card-footer text-black text-center">
			<p class="display">VENDOR MANAGEMENT</p>
			<small class="text-black-50 display">&copy; Copyrights by
				X-Workz. All rights reserved</small>
		</div>
	</footer>
</body>


</html>