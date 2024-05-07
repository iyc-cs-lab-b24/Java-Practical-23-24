import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // JDBC URL, username, and password of MySQL server
        String jdbcUrl = "jdbc:mysql://localhost:3306/teacher";
        String username = "root";
        String password = "root";

        // JDBC variables for opening, closing and managing connection
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to MySQL database
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Create SQL statement
            statement = connection.createStatement();

            // Execute SQL query
            resultSet = statement.executeQuery("SELECT * FROM teachers");

            // Process the result set
            out.println("<html><body>");
            out.println("<h2>Teacher Information:</h2>");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email + "<br>");
            }
            out.println("</body></html>");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Close all JDBC objects
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
