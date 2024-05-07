<!DOCTYPE html>
<html>
<head>
    <title>Set User Name</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .card {
            width: 400px; /* Increased width */
            max-width: 80%; /* Max width for responsiveness */
            background-color: #fff;
            border-radius: 10px; /* Rounded corners */
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1); /* Slight shadow effect */
            padding: 30px; /* Increased padding */
        }

        h2 {
            margin-top: 0;
            font-size: 24px;
            color: #530202;
            text-align: center;
            margin-bottom: 20px; /* Added margin below heading */
        }

        form {
            text-align: center;
        }

        input[type="text"] {
            width: calc(100% - 40px); /* Adjusted width */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 20px; /* Increased margin */
        }

        button[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #ff00b3;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        button[type="submit"]:hover {
            background-color: #b30084;
        }
    </style>
</head>
<body>
    <div class="card">
        <h2>Enter Your Name</h2>
        <form action="storeName.jsp" method="post">
            <input type="text" name="username" placeholder="Enter your name">
            <br>
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
