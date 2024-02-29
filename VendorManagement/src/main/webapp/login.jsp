<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Success Page</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.navbar {
	background-image: linear-gradient(to right, #aa076b, #610456);
	background-size: cover;
}

.nav-link:hover {
	background-image: linear-gradient(to right, #610456, #be0678);
	background-size: cover;
	border-radius: 8px;
	text-transform: uppercase;
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
				<li class="nav-item"><a href="index.jsp"
					class="nav-link text-white">Register</a></li>
			</ul>
		</div>

	</nav>

	<h1
		style="color: green; font-weight: 400; margin: auto; margin-top: 6rem; margin-left: 11rem;">WELCOME
		TO VENDOR MANAGEMENT</h1>
	<hr>
	<h2
		style="color: green; font-weight: 600; margin: auto; margin-top: 2rem; margin-left: 25rem;">${ent.ownerName}</h2>


	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>

</html>