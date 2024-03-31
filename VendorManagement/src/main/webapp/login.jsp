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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
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
	height: 90vh;
}

.container {
	max-width: 850x;
	margin: 0 28px;
	box-shadow: 0 40px 40px #ABB2B9;
	margin-top: 55px;

}

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

.wrapper {
	font-size: 22px;
	font-weight: 600;
}
.userLogo{
    height: 432px;
    color: black;
}
.userName{
    position: fixed;
    top: 21.5rem;
    left: 14.5rem;
    font-weight: 600;
}
.name:hover{
    color: black;
}
.name{
    position: fixed;
    top: 24.5rem;
    left: 15.8rem; 
    font-size: 25px;
    font-weight: 600;
}
.editLogo{
position: fixed;
    top: 27.5rem;
    left: 17.8rem;
    color: black;
}
.editLogo:hover{
    font-weight: 900;
}
#uploadImg{
  margin-top: 20px;
  background-color: #610456;
  color: white;
  border-radius: 10px;
}
.form-control{
margin-top: 70px;
}
.img{
    width: 80%;
   height: 280px;
   border-radius: 50%;
   margin-top: 20px;
}
</style>
</head>

<body class="bg-light">
	<nav class="navbar fixed-top navbar-expand-lg  navbar-dark p-md-3">

		<a href="#" class="navbar-brand pt-2">Welcome <span>${ent.ownerName}</span></a>
		<button type="button" class="navbar-toggler" data-bs-target="#navbar"
			data-bs-toggle="collapse" aria-controls="navbar" aria-expanded="false"
			aria-label="Toggle Navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbar">
			<div class="mx-auto"></div>
			<ul class="navbar-nav">
				<li class="nav-item"><a href="home.jsp"
					class="nav-link text-white">Home</a></li>
				<li class="nav-item"><a href="signin.jsp"
					class="nav-link text-white">Back</a></li>
			</ul>
		</div>

	</nav>
	<div class="container">

		<div class="row d-flex justify-content-center">
			<div class="col-md-12 ">
				<div class="row z-depth-3">
					<div class="col-sm-4 bg-light rounded-left p-0 pb-0">
						<div class="card-block text-center text-light">
                            <img src="background.jpg" class="img">
                            <div class="card-block">
                                <form action="uploadImg" enctype="multipart/form-data" method="post">
                                    <div>
                                        <input type="file" class="form-control" name="profileImage" >
                                    </div>
                                    <div>
                                        <button class="btn" id="uploadImg">Upload</button>
                                    </div>  
                                </form>
                            </div>
							<a href="editvendor/${entites.id}"><i class="far fa-edit fa-2x mb-5 editLogo"></i></a>
						</div>
					</div>
					<div class="col-sm-8 bg-white rounded-right">
						<h5 class="mt-3 text-center wrapper">PROFILE INFORMATION</h5>
						<hr class="badge-primary w-50 m-auto">
						<div class="row">
							<div class="col-sm-6">
								<p class="font-weight-bold mt-2 wrapper">User Name</p>
								<h5 class="text-muted">${entites.vendorName}</h5>
							</div>
							<div class="col-sm-6">
								<p class="font-weight-bold mt-2 wrapper">Email :</p>
								<h5 class="text-muted">${entites.email}</h5>
							</div>
						</div>
						<hr class="badge-primary w-100 m-auto">
						<div class="row">
							<div class="col-sm-6">
								<p class="font-weight-bold mt-2 wrapper">Contact No :</p>
								<h5 class="text-muted">${entites.contactNo}</h5>
							</div>
							<div class="col-sm-6">
								<p class="font-weight-bold mt-2 wrapper">Location:</p>
								<h5 class="text-muted">${entites.location}</h5>
							</div>
						</div>
                        <hr class="badge-primary w-100 m-auto">
						<div class="row">
							<div class="col-sm-6">
								<p class="font-weight-bold mt-2 wrapper">Service Type :</p>
								<h5 class="text-muted">${entites.serviceType}</h5>
							</div>
							<div class="col-sm-6">
								<p class="font-weight-bold mt-2 wrapper">Website:</p>
								<h5 class="text-muted">${entites.website}</h5>
							</div>
						</div>
						<hr class="badge-primary w-100 m-auto">
						<div class="row">
							<div class="col-sm-6">
								<p class="font-weight-bold mt-2 wrapper">Profile Status :</p>
								<h5 class="text-muted">${entites.accountLockStatus}</h5>
							</div>
							<div class="col-sm-6">
								<p class="font-weight-bold mt-2 wrapper">Status :</p>
								<h5 class="text-muted">${entites.status}</h5>
							</div>
							<hr class="bg-primary">
							<ul class="list-unstyled d-flex justify-content-center">
								<i class="fab fa-facebook-f px-4 h3 text-black"></i>
								<i class="fab fa-youtube px-4 h3 text-black "></i>
								<i class="fab fa-twitter px-4 h3 text-black"></i>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<script
			src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>

</html>