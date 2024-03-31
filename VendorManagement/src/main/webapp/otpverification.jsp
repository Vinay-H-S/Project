<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Otp verification page</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #fff;
}

.text-color {
	color: red;
}

h5 {
	font-size: 33px;
	font-family: 'Poppins';
}

.card {
	width: 400px;
	padding: 10px;
	border-radius: 20px;
	background: #fffe;
	position: relative;
	text-align: center;
}

.container {
	height: 100vh;
}

.mobile-text {
	color: #989696;
	font-size: 15px;
}

.inputs {
	width: 100%;
	height: 40px;
	border-radius: 50%;
	border: none;
	outline: 0.4mm solid rgba(28, 58, 64, 0.7);
	text-align: center;
	font-family: poppins;
	background: white;
	font-size: 18px;
	margin: 5px;
}

.inputs input:focus {
	outline: 0.4mm solid rgba(130, 190, 87);
}

#loginBtn {
	border-radius: 25px;
	background-image: linear-gradient(to right, #aa076b, #610456);
	width: 100%;
}

.inputs input:valid {
	background: rgb(130, 190, 87);
	color: white;
	outline: 0.4mm solid rgb(130, 190, 87);
}

#click {
	text-decoration: none;
}

#otpErrmsg {
	font-size: 14px;
	font-weight: 550;
}

.input-box {
	margin-top: 30px;
	width: 100%;
	height: 40px;
}

#resendOtp {
	border-style: none;
	background-color: white;
	color: blue;
}

.closeLink {
	font-weight: 700;
	text-decoration: none;
	position: fixed;
	top: 9.4rem;
	left: 57.7rem;
	text-decoration: none;
	color: black;
	font-size: 20px;
}
</style>
</head>

<body>
	<div class="d-flex justify-content-center align-items-center container">
		<div class="card py-5 px-3">
			<span><a href="signin.jsp" class="closeLink">X</a></span>
			<h5>Email OTP Verification</h5>
			<span class="mobile-text">Enter the code we just send on your
				email</span>
			<form action="verifyotp" method="post">

				<div class="input-box ">
					<input type="text" value="${ent.email}" name="email" id="email"
						class="form-control" />
				</div>

				<div class="d-flex flex-row mt-3">
					<input type="text" class="inputs" maxlength="6" name="otp" id="otp"
						onblur="validateOTP()">
				</div>
				<span id="otpErrmsg" style="color: red">${otpErrmsg}</span>

				<div class="text-color mt-3">
					<span class="d-block mobile-text pb-3" id="resend">Did't
						recive a code </span>
					<div class="resend mb-3">
						<button id="resendOtp" onclick="sendOtp()">Click to
							resend</button>
						<span class="time"></span>
					</div>

				</div>
				<button type="submit" class="btn text-white" id="loginBtn"
					disabled="disabled">Submit</button>
			</form>
		</div>
	</div>

	<script>
            function timer(n) {
                document.getElementById("resend").disabled = true;
                const interval = setInterval(() => {
                    if (n == 0) {
                        clearInterval(interval);
                        document.getElementById("resend").disabled = false;
                    }
                    document.querySelector(".time").innerHTML = n;
                    n = n - 1;
                }, 1000);
            }
            timer(60);
            document.getElementById("resend").onclick = function () {
                timer(60);
            }

            //loginOtpAjax
            function validateOTP() {
                const otp = document.getElementById("otp").value;
                const loginButton = document.getElementById("loginBtn");

                if (otp == null || otp == "") {
                    console.log("Otp Can't be empty");
                    document.getElementById("otpErrmsg").innerHTML = "*OTP Can't Be Empty";
                    loginButton.setAttribute("disabled", "");
                } else if (otp.length > 6 || otp.length < 6) {
                    console.log("Otp Should Be Format");
                    document.getElementById("otpErrmsg").innerHTML = "*OTP Should Be in Format";
                    loginButton.setAttribute("disabled", "");
                } else if (otp != "") {

                    const xhttp = new XMLHttpRequest();

                    xhttp.open("GET",
                        "http://localhost:8080/VendorManagement/loginOtpAjax/"
                        + otp);
                    
                    xhttp.send();

                    xhttp.onload = function () {
                        const response = document.getElementById("otpErrmsg").innerHTML = this.responseText;
                        
                            loginButton.removeAttribute("disabled");
                       

                    }
                }

            }

            //genarateOtp
            function sendOtp() {
                let mail = document.getElementById("email").value;

                const xhttp = new XMLHttpRequest();
                xhttp.open("GET",
                    "http://localhost:8080/VendorManagement/loginOtpEmailMsg/"
                    + mail);
                concsole.log("Otp sent")
                xhttp.send();

                xhttp.onload = function () {
                    document.getElementById("otpErrmsg") = this.responseText;
                }

            }




        </script>


	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>

</body>

</html>