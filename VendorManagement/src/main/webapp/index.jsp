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

.popup  button {
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

#locationErrorMsg, #VendorNameErrorMsg, #contactNoErrorMsg,
	#websiteErrorMsg, #emailMsg, #gstErrorMsg, #ownerNameErrorMsg,
	#alternativeNoErrorMsg {
	font-size: 14px;
	font-weight: 600;
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
				<li class="nav-item"><a href="signin.jsp"
					class="nav-link text-white">Sign in</a></li>
				<li class="nav-item"><a href="index.jsp"
					class="nav-link text-white">Register</a></li>
			</ul>
		</div>

	</nav>

	<div class="container">
		<!-- Navbar -->

		<form action="vendor" method="post">
			<h2>
				REGISTRATION <span class="err">${error}</span>
			</h2>
			<div class="content">
				<div class="input-box">
					<label>Vendor Name</label> <input type="text"
						placeholder="enter your name" name="vendorName" id="vendorName"
						onblur="validateName()" required /> <span id="VendorNameErrorMsg"
						style="color: red;"></span>

				</div>

				<div class="input-box">
					<label>Location</label> <input type="text"
						placeholder="current location" name="location" id="location"
						onblur="validateLocation()" required /> <span
						id="locationErrorMsg" style="color: red"></span>
				</div>
				<div class="input-box">
					<label>Gst number</label> <input type="text"
						placeholder="enter gst number" name="gstNo" onblur="uniqueGst()"
						id="gstNo" required /> <span id="gstErrorMsg" style="color: red"></span>
				</div>
				<div class="input-box">
					<label>Company Start Date</label> <input type="date"
						placeholder="start date" name="companyStartDate" required />
				</div>
				<div class="popup" id="popup">
					<h2>Thank You!</h2>
					<p>Registration Saved Successfully</p>
					<button type="submit" onclick="closePopup()">OK</button>
				</div>
				<div class="input-box">
					<label>Service type</label> <select class="input-select"
						name="serviceType" id="serviceType" required>
						<option value="">Choose...</option>
						<option>Water</option>
						<option>Milk</option>
						<option>Coffee</option>
						<option>Laptop</option>
						<option>Internet</option>
						<option>Food</option>
					</select> <span id="serviceTypeErrorMsg" style="color: red"></span>
				</div>
				<div class="input-box">
					<label>Contact number</label> <input type="tel"
						placeholder="contact number" name="contactNo"
						onblur="uniqueConatctNo()" id="contactNo" required /> <span
						id="contactNoErrorMsg" style="color: red"></span>
				</div>
				<div class="input-box">
					<label>Alternative number</label> <input type="tel"
						placeholder="alternative number" name="alternativeNo"
						onblur="validateAlternativeNo()" id="alternativeNumber" required />
					<span id="alternativeNoErrorMsg" style="color: red"></span>
				</div>
				<div class="input-box">
					<label>Owner Name</label> <input type="text"
						placeholder="enter real name" name="ownerName" id="ownerName"
						onblur="validateOwnerName()" required /> <span
						id="ownerNameErrorMsg" style="color: red"></span>
				</div>
				<div class="input-box">
					<label>Email</label> <input type="email"
						placeholder="enter your email" name="email" id="email"
						onblur="uniqueMail()" required /> <span id="emailMsg"
						style="color: red;"></span>
				</div>

				<div class="input-box">
					<label>Website</label> <input type="text"
						placeholder="website address" name="website" id="website"
						onblur="uniqueWebsite()" required /> <span id="websiteErrorMsg"
						style="color: red"></span>
				</div>
				<div class="button-container m-auto pe-5 ">
					<div>
						<p>
							By clicking register, you agree to our<a href="#"> Terms</a> and
							<a href="#">Privacy Policy</a>
						</p>
					</div>
					<div>
						<button type="submit" onclick="openPopup()" id="registerButton"
							disabled="disabled">Register</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	
		//EMailAjax
function uniqueMail() {
    var email = document.getElementById("email").value;
    const button = document.getElementById("registerButton");
  
    if (email == null || email == "") {
        document.getElementById("emailMsg").innerHTML = "*Email can't be blank";
        console.log("Email can't be blank");
        button.setAttribute("disabled", "");
    } else if (!email.match(/^([a-zA-Z0-9\.]+@+[a-zA-Z]+(\.)+[a-zA-Z]{2,})$/))  {
        document.getElementById("emailMsg").innerHTML = "*Email should be in format";
        button.setAttribute("disabled", "");
        console.log("Email should be character");
    } else if (email != null && email != "") {
        console.log("email is valid");
        document.getElementById("emailMsg").innerHTML = "";

        const xhttp = new XMLHttpRequest();
        xhttp.open("GET",
            "http://localhost:8080/VendorManagement/emailAjax/"
            + email);
        xhttp.send();

        xhttp.onload = function () {
            document.getElementById("emailMsg").innerHTML = this.responseText;

        }
    }
}


		//GstAjax
		function uniqueGst() {
    const gstNo = document.getElementById("gstNo").value;
    const button = document.getElementById("registerButton");
    const gstRegex=/^(\d{2})([A-Z]{5})(\d{4})([A-Z]{1})([A-Z\d]{1})([A-Z\d]{1})$/;
    const result=gstRegex.test(gstNo);

    if (gstNo == null || gstNo == "") {
        document.getElementById("gstErrorMsg").innerHTML = "*Gst Number can't be blank";
        console.log("Gst can't be blank");
        button.setAttribute("disabled", "");
    }else if(gstNo.length <15 || gstNo.length >15){
        document.getElementById("gstErrorMsg").innerHTML = "*Gst number should be format";
        button.setAttribute("disabled", "");
    }else if(gstNo !="" ){
            const xhttp = new XMLHttpRequest();
            xhttp.open("GET",
                "http://localhost:8080/VendorManagement/gstAjax/"
                + gstNo);
            xhttp.send();
            xhttp.onload = function () {
                document.getElementById("gstErrorMsg").innerHTML = this.responseText;
            }
    }
       
}

		//Contact Number Ajax

		function uniqueConatctNo() {
    const contactNumber = document.getElementById("contactNo").value;
    const button = document.getElementById("registerButton");
    
    if (contactNumber == 0) {
        document.getElementById("contactNoErrorMsg").innerHTML = "*Contact number can't be blank";
        console.log("Contact Number not valid");
        button.setAttribute("disabled", "");
    } else if (!contactNumber.match(/^[6-9]{1}[0-9]{9}$/)){
        document.getElementById("contactNoErrorMsg").innerHTML = "*Contact should be 10 Digits";
        console.log("Contact Number not valid");
        button.setAttribute("disabled", "");
    } else if (contactNumber != 0) {
        const xhttp = new XMLHttpRequest();
        xhttp.open("GET",
            "http://localhost:8080/VendorManagement/contactNoAjax/"
            + contactNumber);
        xhttp.send();
        xhttp.onload = function () {
            document.getElementById("contactNoErrorMsg").innerHTML = this.responseText;
        }
    }

}
		//Alternative Number
		
				function validateAlternativeNo() {
    const alternativeNo = document.getElementById("alternativeNumber").value;
    const button = document.getElementById("registerButton");

    if (alternativeNo == 0) {
        document.getElementById("alternativeNoErrorMsg").innerHTML = "*Alternative number can't be blank";
        console.log("Contact Number not valid");
        button.setAttribute("disabled", "");
    } else if (!alternativeNo.match(/^[6-9]{1}[0-9]{9}$/)){
        document.getElementById("alternativeNoErrorMsg").innerHTML = "*Alternative should be 10 Digits";
        console.log("Contact Number not valid");
        button.setAttribute("disabled", "");
    } else {
    	document.getElementById("alternativeNoErrorMsg").innerHTML = "";
    	button.removeAttribute("disabled");
    }
      

}
		
		
		//Website Ajax

		function uniqueWebsite() {
    const website = document.getElementById("website").value;
    const button=document.getElementById("registerButton");

    if(website ==""){
        document.getElementById("websiteErrorMsg").innerHTML = "*Website can't be blank";
        button.setAttribute("disabled","");
        
    }else if(website.length < 11 || website.length > 30 ){
        document.getElementById("websiteErrorMsg").innerHTML = "*Website should be in character";
        button.setAttribute("disabled","");
      
    }else if(website != ""){
        document.getElementById("websiteErrorMsg").innerHTML = "";
        const xhttp = new XMLHttpRequest();
        xhttp.open("GET",
            "http://localhost:8080/VendorManagement/websiteAjax/"
            + website);
        xhttp.send();
        xhttp.onload = function () {
         const response=   document.getElementById("websiteErrorMsg").innerHTML = this.responseText;
         if(response == ""){
            button.removeAttribute("disabled");
         }else{
            button.setAttribute("disabled","");
         }
        } 
    }
    
}
		
    //vendorName
		function validateName() {
   		 let name = document.getElementById("vendorName").value;
   			 let btn = document.getElementById("registerButton");

    			if (name == "") {
       	 document.getElementById("VendorNameErrorMsg").innerHTML = "*Name can't be blank";
       			 console.log("Name can't be blank");
       			 btn.setAttribute("disabled", "");
   			 } else if (name.match(/[0-9]/)) {
     		   document.getElementById("VendorNameErrorMsg").innerHTML = "*Name should be character";
        btn.setAttribute("disabled", "");
       		 console.log("Name should be character");
    } else if(name.length <4 || name.length >15){
        document.getElementById("VendorNameErrorMsg").innerHTML = "*Name should be min 4 or max 15";
        btn.setAttribute("disabled", "");
    }else{
        document.getElementById("VendorNameErrorMsg").innerHTML = "";
        btn.removeAttribute("disabled");
    }
}
	//LocationValidate
	
	function validateLocation() {
    let location = document.getElementById("location").value;
    let btn = document.getElementById("registerButton");

    if (location == null || location =="") {
        document.getElementById("locationErrorMsg").innerHTML = "*Location can't be blank";
        console.log("Name can't be blank");
        btn.setAttribute("disabled", "");
    } else if (location.match(/[0-9]/)) {
        document.getElementById("locationErrorMsg").innerHTML = "*Location can't includes the character";
        btn.setAttribute("disabled", "");
        console.log("Name should be character");
    } else if(location.length <4 || location.length >15){
        document.getElementById("locationErrorMsg").innerHTML = "*Location should be min 4 or max 15";
        btn.setAttribute("disabled", "");
    }else{
        document.getElementById("locationErrorMsg").innerHTML = "";
        btn.removeAttribute("disabled");
    }
}
	
	//ownerName
	function validateOwnerName() {
   		 let name = document.getElementById("ownerName").value;
   			 let btn = document.getElementById("registerButton");

    			if (name == "") {
       	 document.getElementById("ownerNameErrorMsg").innerHTML = "*Name can't be blank";
       			 console.log("Name can't be blank");
       			 btn.setAttribute("disabled", "");
   			 } else if (name.match(/[0-9]/)) {
     		   document.getElementById("ownerNameErrorMsg").innerHTML = "*Name should be in character";
        btn.setAttribute("disabled", "");
       		 console.log("Name should be character");
    } else if(name.length <4 || name.length >15){
        document.getElementById("ownerNameErrorMsg").innerHTML = "*Name should be min 4 or max 15";
        btn.setAttribute("disabled", "");
    }else{
        document.getElementById("ownerNameErrorMsg").innerHTML = "";
        btn.removeAttribute("disabled");
    }
}
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>

</html>