<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">


<title>Registration Form</title>
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
	max-height: 92vh;
}

h2 {
	font-size: 26px;
	font-weight: 600;
	text-align: left;
	color: #2f4f33;
	border-bottom: 1px solid silver;
}

.content {
	display: flex;
	flex-wrap: wrap;
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
	margin-right: 70px;
}

.button-container button {
	margin-right: 40px;
	margin-bottom: 25px;
	padding: 5px;
	display: block;
	font-size: 20px;
	color: #fff;
	border: none;
	width: 100%;
	border-radius: 5px;
	background-image: linear-gradient(to right, #53983f, #08e708);
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

#ent {
	margin-top: 48px;
	margin-left: -72px;
}

.wrapper {
	font-family: fantasy;
}
</style>

</head>

<body>


	<div class="container">
				<!-- Navbar -->
		<form action="${pageContext.request.contextPath}/placeitem/${entites.productId}"
			method="post">
			<h2>ORDER</h2>
			<div class="content">
				<div class="input-box">
					<label>Order Quantity</label> <input type="text"
						placeholder="enter required quantity" name="orderQuantity"
						required />
				</div>
				<div class="input-box">
					<label>Order Date</label> <input type="date"
						placeholder="order date" name="orderDate" required />
				</div>
				<div class="input-box">
					<label>Delivery Address</label> <input type="text"
						placeholder="enter delivery charge" name="deliveryAddress"
						required />
				</div>
				<div class="input-box">
					<label>Message</label> <input type="text"
						placeholder="enter delivery charge" name="message" required />
				</div>
				<div class="button-container">
					<div>
						<button type="submit" style="font-weight: 500; color: black;">Place
							Your Order</button>
					</div>
				</div>
		</form>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>

</html>