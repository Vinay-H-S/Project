<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">


<title>Add Products</title>
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
	height: 92vh;
	background-color: #fffe;
}

.container {
	max-width: 550px;
	padding: 28px;
	margin: 0 28px;
	box-shadow: 0 25px 30px #ABB2B9;
	height: 55vh;
}

h2 {
	font-size: 26px;
	font-weight: 600;
	text-align: left;
	color: #2f4f4f;
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
	margin: 15px 0;
}

.button-container button {
	margin-left: 25px;
	margin-top: 13px;
	padding: 5px;
	font-size: 20px;
	color: #fff;
	width: 100%;
	border-radius: 5px;
	background-color: #2f4f4f;
}

.popup {
	width: 250px;
	background: #fff;
	border-radius: 6px;
	position: absolute;
	top: 0;
	text-align: center;
	height: 150px;
	left: 41%;
	transform: scale(0.1);
	visibility: hidden;
}

.popup button {
	width: 50%;
	background-image: linear-gradient(to right, #aa076b, #610456);
	border-radius: 18px;
	color: #fff;
}

.popup h2 {
	font-size: 28px;
	font-weight: 500;
	text-align: center;
	justify-content: center;
}

.popup p {
	font-size: 20px;
	text-decoration: solid;
}

.open-popup {
	visibility: visible;
	top: 40%;
	transform: scale(1);
}

.err {
	color: red;
	font-family: monospace;
	margin-left: 25px;
}

#locationErrorMsg, #VendorNameErrorMsg, #contactNoErrorMsg,
	#websiteErrorMsg, #emailMsg, #gstErrorMsg, #ownerNameErrorMsg,
	#alternativeNoErrorMsg {
	font-size: 14px;
	font-weight: 600;
}

.display {
	font-weight: 600;
	margin-bottom: 0;
	padding: 0;
}

.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
}
</style>

</head>

<body>

	<div class="container">
		<!-- Navbar -->

		<form
			action="${pageContext.request.contextPath}/products/${entites.vendorId}"
			method="post">
			<input type="hidden" name="email" value="${entites.email}">
			<h2>ADD PRODUCT</h2>
			<div class="content">
				<div class="input-box">
					<label>Product Name</label> <input type="text"
						placeholder="enter product name" name="productName" required /> <span
						id="VendorNameErrorMsg" style="color: red;"></span>

				</div>

				<div class="input-box">
					<label>Category</label> <select class="input-select"
						name="category" required>
						<option>Electronics</option>
						<option>Cloth's</option>
						<option>Books</option>
						<option>Food</option>
						<option>Appliances</option>
						<option>Furniture</option>
						<option>Grocery</option>
						<option>Home</option>
					</select>
				</div>

				<div class="input-box">
					<label>Product Price</label> <input type="text"
						placeholder="enter price here" name="productPrice" required />
				</div>
				<div class="input-box">
					<label>Delivery Charge</label> <input type="text"
						placeholder="enter delivery charge" name="deliveryCharge" required />
				</div>
				<div class="input-box">
					<label>Available</label> <select class="input-select"
						name="available" required>
						<option value="">Choose...</option>
						<option>Yes</option>
						<option>No</option>
						<option>Out of stock</option>
					</select>
				</div>
				<div class="input-box">
					<label>Description</label>
					<textarea rows="2" placeholder="Please enter the description here"
						cols="40" name="description"></textarea>
				</div>

				<div class="button-container m-auto pe-5 ">
					<div>
						<button type="submit">Submit</button>
					</div>
				</div>
			</div>
		</form>
	</div>


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