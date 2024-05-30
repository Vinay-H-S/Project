<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<style>
.banner-image {
	background-image: linear-gradient(to right, #aa076b, #610456);
	background-size: cover;
}

.nav-link:hover {
	background-color: black;
	background-size: cover;
	border-radius: 12px;
	text-transform: uppercase;
}

.display {
	font-weight: 600;
	margin-bottom: 0;
}

.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
}
</style>

<body>
	<!-- Navbar -->
	<nav class="navbar fixed-top navbar-expand-lg  navbar-dark p-md-3">
		<a class="navbar-brand" href="#"> <img
			src="https://tse4.mm.bing.net/th?id=OIP.3bKZlDVBAtAh8DitadnD4AHaHa&pid=Api&P=0&h=180"
			width="40" height="40" class="d-inline-block align-top" alt="Logo">
		</a> <a href="#" class="navbar-brand pt-2">Vendor Management</a>
		<button type="button" class="navbar-toggler" data-bs-target="#navbar"
			data-bs-toggle="collapse" aria-controls="navbar"
			aria-expanded="false" aria-label="Toggle Navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="navbar-collapse collapse" id="navbar">
			<div class="mx-auto"></div>
			<ul class="navbar-nav">
				<li class="nav-item"><a href="home.jsp"
					class="nav-link text-white">Home</a></li>
				<li class="nav-item"><a href="signin.jsp"
					class="nav-link text-white">Sign in</a></li>
				<li class="nav-item"><a href="adminlogin.jsp"
					class="nav-link text-white">Admin login</a></li>
				<li class="nav-item"><a href="index.jsp"
					class="nav-link text-white">Register</a></li>
			</ul>
		</div>
	</nav>

	<!-- Banner Image -->
	<div
		class="banner-image w-100 vh-100 justify-content-center align-items-center d-flex">
		<div class="content text-center">
			<h1 class="text-white">VENDOR MANAGEMENT</h1>
		</div>
	</div>

	<footer class="footer">
		<div class="card-footer text-black text-center bg-white">
			<p class="display">VENDOR MANAGEMENT</p>
			<small class="text-black-50 display">&copy; Copyrights by
				X-Workz. All rights reserved</small>
		</div>
	</footer>


</body>

</html>