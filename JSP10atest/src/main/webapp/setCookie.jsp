
<%
    String username = request.getParameter("username");
    Cookie cookie = new Cookie("username", username);
    response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Cookie Set</title>
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
            max-width: 400px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            margin-top: 0;
            font-size: 24px;
            color: #333;
            text-align: center;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }
        p{
        text-align: center;}
    </style>
</head>
<body>
    <div class="container">
        <h2>Cookie Set Successfully!</h2>
        <a href="getCookie.jsp">Click here</a> <p>to view the stored cookie.</p>
    </div>
</body>
</html>
