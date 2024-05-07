<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
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
            color: #007bff; /* Blue color for font */
        }

        .error {
            color: #dc3545; /* Red color for error messages */
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            // Database connection parameters
            String url = "jdbc:mysql://localhost:3306/user_management";
            String username = "root";
            String password = "root";

            // Retrieve form parameters
            String inputUsername = request.getParameter("username");
            String inputPassword = request.getParameter("password");

            // Initialize database connection
            Connection conn = null;
            PreparedStatement stmt = null;

            try {
                // Connect to the database
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, username, password);

                // Prepare SQL statement
                String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, inputUsername);
                stmt.setString(2, inputPassword);

                // Execute query
                int rowsAffected = stmt.executeUpdate();

                // Check if registration was successful
                if (rowsAffected > 0) {
                    // Registration successful
                    out.println("<h2>Registration Successful!</h2>");
                    out.println("<p>Username: " + inputUsername + "</p>");
                } else {
                    // Registration failed
                    out.println("<h2 class='error'>Registration Failed</h2>");
                    out.println("<p class='error'>Unable to register user.</p>");
                }
            } catch (Exception e) {
                // Error handling
                out.println("<h2 class='error'>Error</h2>");
                out.println("<p class='error'>" + e.getMessage() + "</p>");
            } finally {
                // Close database connections
                try { if (stmt != null) stmt.close(); } catch (Exception e) {}
                try { if (conn != null) conn.close(); } catch (Exception e) {}
            }
        %>
    </div>
</body>
</html>
