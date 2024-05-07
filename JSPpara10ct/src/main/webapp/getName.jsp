<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Get User Name</title>
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

        .container {
            max-width: 600px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
        }

        h2 {
            margin-top: 0;
            font-size: 24px;
            color: #333;
        }

        .username-label {
            font-weight: bold;
            color: #007bff;
        }

        .username-value {
            color: #ff0000;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            // Retrieve username from session
            String username = (String) session.getAttribute("username");
        %>
        <h2>Stored Username:</h2>
        <p><span class="username-label">Username: </span><span class="username-value"><%= username %></span></p>
    </div>
</body>
</html>
