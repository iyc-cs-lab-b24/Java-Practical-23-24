<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
    <title>Validation Result</title>
</head>
<body>
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
        ResultSet rs = null;

        try {
            // Connect to the database
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);

            // Prepare SQL statement
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, inputUsername);
            stmt.setString(2, inputPassword);

            // Execute query
            rs = stmt.executeQuery();

            // Check if user exists
            if (rs.next()) {
                // User exists, redirect to success page with username as parameter
                response.sendRedirect("success.jsp?username=" + inputUsername);
            } else {
                // User doesn't exist, redirect to failure page
                response.sendRedirect("failure.jsp");
            }
        } catch (Exception e) {
            // Error handling
            out.println("Error: " + e.getMessage());
        } finally {
            // Close database connections
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    %>
</body>
</html>
