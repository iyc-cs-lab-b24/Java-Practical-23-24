<!DOCTYPE html>
<html>
<head>
    <title>Display Cookies</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        h2 {
            margin-top: 0;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Display Cookies</h2>
        <table>
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>
            <%
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
            %>
            <tr>
                <td><%= cookie.getName() %></td>
                <td><%= cookie.getValue() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="2">No cookies found</td>
            </tr>
            <% } %>
        </table>
    </div>
</body>
</html>
