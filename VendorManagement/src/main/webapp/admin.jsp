<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Page</title>
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
}

body {
	background-color: #f2f2f2;
	font-family: sans-serif;
}

.slide {
	height: 100vh;
	width: 200px;
	position: absolute;
	background-color: #fff;
	transition: 0.5s ease;
	transform: translateX(-200px);
	top: 0;
}

.slide h1 {
	color: #aa076b;
	font-weight: 800;
	padding-left: 45px;
	pointer-events: none;
}

.slide ul li {
	list-style: none;
}

.slide ul li a {
	color: black;
	font-weight: 500;
	text-decoration: none;
	padding: 5px 0;
	display: block;
	text-transform: capitalize;
	transition: 0.2s ease;
}

.slide ul li a:hover {
	background-color: #aa076b;
	color: white;
}

.slide ul li a i {
	width: 40px;
	text-align: center;
}

.input {
	display: none;
	visibility: hidden;
}

.toggle {
	position: absolute;
	height: 30px;
	width: 30px;
	background-color: white;
	z-index: 1;
	cursor: pointer;
	border-radius: 2px;
	top: 10px;
	left: 13px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}

.toggle .common {
	position: absolute;
	height: 2px;
	width: 20px;
	background-color: #aa076b;
	border-radius: 50px;
	transition: 0.3s ease;
}

.toggle .top_line {
	top: 30%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.toggle .middle-line {
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.toggle .bottom_line {
	top: 70%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.input:checked ~.toggle .top_line {
	left: 2px;
	top: 14px;
	width: 25px;
	transform: rotate(45deg);
}

.input:checked ~.toggle .bottom_line {
	left: 2px;
	top: 14px;
	width: 25px;
	transform: rotate(-45deg);
}

.input:checked ~.toggle .middle-line {
	opacity: 0;
	transform: translateX(20px);
}

.input:checked ~.slide {
	transform: translateX(0);
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);
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

.table-container {
	padding: 0 5%;
	margin: auto;
	margin-top: 40px;
}

.table {
	width: 100%;
	border-collapse: collapse;
}

.table thead {
	background-image: linear-gradient(to right, #aa076b, #610456);
	color: #f1f1f1;
}

.table thead tr th {
	font-size: 15px;
	letter-spacing: 0.35px;
	color: #ffffff;
	opacity: 1;
	font-weight: 600;
	padding: 6px;
	border: 1px solid #dee2e685;
	vertical-align: top;
	text-align: center;
}

.table tbody tr td {
	font-size: 13px;
	letter-spacing: 0.35px;
	font-weight: normal;
	color: black;
	padding: 5px;
	background-color: white;
	text-align: center;
	border: 1px solid #dee2e685;
}

.table tbody tr td:hover {
	background-color: white;
}

.actionBtn {
	display: table-cell;
	padding: 2px;
}

.display {
	font-weight: 600;
	margin-bottom: 0;
}

#approveBtn, #rejectBtn {
	font-size: 16px;
	width: 65px;
	max-height: 35px;
	bottom: 120px;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	text-decoration: none;
	color: black;
}

#approveBtn:hover {
	transition: 0.4s ease;
	background-color: rgba(77, 198, 36, 0.834);
	border-radius: 10px;
	color: white;
	align-items: center;
}

#rejectBtn:hover {
	transition: 0.4s ease;
	background-color: rgb(202, 15, 15);
	border-radius: 10px;
	color: white;
	align-items: right;
}

.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
}

#current-time {
	font-size: 18px;
	left: 78rem;
	color: black;
	position: fixed;
	justify-content: end;
}

#current-time:hover {
	color: #aa076b;
}

#current-time i {
	font-size: 25px;
	margin-top: 10px;
	padding-right: 4px;
}

.form-control {
	width: 280px;
}

@media ( max-width :768px) {
	.table thead {
		display: none;
	}
	.table, .table tbody, .table tr, .table td {
		display: block;
		width: 100%;
	}
	.table tr {
		margin-bottom: 15px;
	}
	.table tbody tr td {
		text-align: right;
		padding-left: 50%;
		position: relative;
	}
	.table td:before {
		content: attr(data-label);
		position: absolute;
		left: 0;
		width: 50%;
		font-weight: 600;
		font-size: 13px;
		text-align: left;
	}
}
</style>
</head>

<body>
	<label> <input type="checkbox" class="input">
		<div class="toggle">
			<span class="top_line common"></span> <span
				class="middle-line common"></span> <span class="bottom_line common"></span>
		</div>
		<div class="slide">
			<h1>MENU</h1>
			<ul>
				<li><a href="#"><i class="fa fa-tv"></i>Dashboard</a></li>
				<li><a href="getProductsDetails"><i class="fa fa-folder"></i>Products</a></li>
				<li><a href="#"><i class="fa fa-heart"></i>Saved</a></li>
				<li><a href="#"><i class="fa fa-cogs"></i>Settings</a></li>
				<li><a href="adminlogin.jsp"><i
						class="fa fa-right-from-bracket"></i>Log-out</a></li>
			</ul>
		</div>
	</label>
	<div class="table-container">

		<span> <i class="fa fa-clock mt-3 " id="current-time">LOGED
				TIME</i></span> <label> <input type="text" class="form-control"
			id="vendorInput" onkeyup="search()" placeholder="Please search here">
		</label>




		<table class="table" id="vendorTable">
			<thead>
				<tr>
					<th>Id</th>
					<th>Vendor Name</th>
					<th>Location</th>
					<th>GST Number</th>
					<th>Company Start Date</th>
					<th>Owner Name</th>
					<th>Service Type</th>
					<th>Contact Number</th>
					<th>Alternative Number</th>
					<th>Email</th>
					<th>Website</th>
					<th>Profile Status</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ent}" var="entites">
					<tr>
						<td data-label="Id">${entites.vendorId}</td>
						<td data-label="Vendor Name">${entites.vendorName}</td>
						<td data-label="Location">${entites.location}</td>
						<td data-label="GST Number">${entites.gstNo}</td>
						<td data-label="Company Start Date">${entites.companyStartDate}</td>
						<td data-label="Owner Name">${entites.ownerName}</td>
						<td data-label="Service Type">${entites.serviceType}</td>
						<td data-label="Contact Number">${entites.contactNo}</td>
						<td data-label="Alternative Number">${entites.alternativeNo}</td>
						<td data-label="Email" id="approve">${entites.email}</td>
						<td data-label="Website">${entites.website}</td>
						<td data-label="Profile Status">${entites.accountLockStatus}</td>
						<td data-label="Status">${entites.status}</td>
						<td><a href="approveStatus/${entites.vendorId}"
							class="actionBtn" id="approveBtn">Approve</a> <a
							href="rejectStatus/${entites.vendorId}" class="actionBtn"
							id="rejectBtn">Reject</a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>


	<script>
        function search() {
            let filter = document.getElementById("vendorInput").value.toUpperCase();

            let table = document.getElementById("vendorTable");

            let tr = table.getElementsByTagName("tr");

            for (var i = 0; i < tr.length; i++) {
                let td = tr[i].getElementsByTagName("td")[1];

                if (td) {
                    let textValue = td.textContenet || td.innerHTML;

                    if (textValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }

        let time = document.getElementById("current-time");

        setInterval(()=>{
            let d=new Date();
            time.innerHTML=d.toLocaleTimeString();
        },1000)

    </script>


	<footer class="footer">
		<div class="card-footer text-black text-center">
			<p class="display">VENDOR MANAGEMENT</p>
			<small class="text-black-50 display">&copy; Copyrights by
				X-Workz. All rights reserved</small>
		</div>
	</footer>
</body>

</html>