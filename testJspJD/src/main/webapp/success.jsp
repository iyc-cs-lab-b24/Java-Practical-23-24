<!DOCTYPE html>
<html>
<head>
    <title>Login Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            padding: 30px;
            max-width: 400px;
            width: 100%;
            text-align: center;
        }

        h2 {
            margin-top: 0;
            margin-bottom: 20px;
            color: #333;
        }

        p {
            margin-bottom: 20px;
            font-size: 18px;
        }

        .username {
            font-weight: bold;
            color: #007bff; /* Blue color for username */
        }

        .success-image {
            width: 50px; /* Adjust size as needed */
            height: auto; /* Maintain aspect ratio */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login Successful!</h2>
        <img class="success-image" src="success.png" alt="Success Icon">
        <p>Welcome, <span class="username"><%= request.getParameter("username") %></span>!</p>

    </div>
</body>
</html>
