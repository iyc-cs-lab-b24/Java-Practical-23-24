<!DOCTYPE html>
<html>
<head>
    <title>Login Failure</title>
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

        a {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        a:hover {
            background-color: #0056b3;
        }
        .fail-image {
                    width: 50px; /* Adjust size as needed */
                    height: auto; /* Maintain aspect ratio */
                }
        p {
            margin-bottom: 20px;
            font-size: 18px;
            font-style: italic;
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login Failed</h2>
        <img class="fail-image" src="fail.png" alt="Success Icon">
        <p>Invalid username or password.</p>
        <a href="index.html">Back to Login</a>
    </div>
</body>
</html>
