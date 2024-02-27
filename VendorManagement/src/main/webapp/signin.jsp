<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
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
    </style>
</head>

<body>
    <nav class="navbar fixed-top navbar-expand-lg  navbar-dark p-md-3">

        <a href="#" class="navbar-brand pt-2">Vendor Management</a>
        <button type="button" class="navbar-toggler" data-bs-target="#navbar" data-bs-toggle="collapse"
            aria-controls="navbar" aria-expanded="true" aria-label="Toggle Navbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar">
            <div class="mx-auto"></div>
            <ul class="navbar-nav">
                <li class="nav-item"><a href="home.jsp" class="nav-link text-white">Home</a></li>
                <li class="nav-item"><a href="index.jsp" class="nav-link text-white">Register</a></li>
            </ul>
        </div>

    </nav>

    <div class="container">
        <!-- Navbar -->

        <form action="vendor" method="post">
            <h2>
                LOG IN
            </h2>
            <div class="content">
            
           <!--  EMAIL ADDRESS FOR LOGIN -->
            
                <div class="input-box">
                    <label>Email</label> <input type="email" placeholder="Enter your email" name="email"
                        id="email" onchange="loginMail()"/> <span id="emailErrorMsg"
                        style="color: red;"></span>
                </div>

                <!-- OTP FOR LOGIN -->
                <div class="input-box">
                    <label>OTP</label>
                    <input type="number"placeholder="Enter your otp" id="email" name="email" onchange="uniqueMail()"/>
                    <Span id="emailMsg" style="color: red"></Span>
                </div>

                <button type="button" class="btn btn-primary">Generate OTP</button>
                <button type="button" class="btn btn-secondary">Log in</button>
            </div>
     
        </form>

    </div>

</body>

</html>