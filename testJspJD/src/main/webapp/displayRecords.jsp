<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display Records</title>
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
            max-width: 800px;
            width: 100%;
        }

        h2 {
            margin-top: 0;
            margin-bottom: 20px;
            color: #d31ba8;
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            border: 2px solid #c1c3c573;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
                     background-color: #00ceff;
                     color: #f8e2e2;
                 }
        tbody {
            font-weight: 550;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Records</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Password</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Database connection parameters
                    String url = "jdbc:mysql://localhost:3306/user_management";
                    String username = "root";
                    String password = "root";

                    // Initialize database connection
                    Connection conn = null;
                    Statement stmt = null;
                    ResultSet rs = null;

                    try {
                        // Connect to the database
                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection(url, username, password);

                        // Create and execute SQL statement
                        stmt = conn.createStatement();
                        String sql = "SELECT * FROM users";
                        rs = stmt.executeQuery(sql);

                        // Iterate over the result set and display records
                        while (rs.next()) {
                            out.println("<tr>");
                            out.println("<td>" + rs.getInt("id") + "</td>");
                            out.println("<td>" + rs.getString("username") + "</td>");
                            out.println("<td>" + rs.getString("password") + "</td>");
                            out.println("</tr>");
                        }
                    } catch (Exception e) {
                        // Error handling
                        out.println("<tr><td colspan='3'>Error: " + e.getMessage() + "</td></tr>");
                    } finally {
                        // Close database connections
                        try { if (rs != null) rs.close(); } catch (Exception e) {}
                        try { if (stmt != null) stmt.close(); } catch (Exception e) {}
                        try { if (conn != null) conn.close(); } catch (Exception e) {}
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
