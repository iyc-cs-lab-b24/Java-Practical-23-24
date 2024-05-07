import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DisplayRecordsServlet")
public class DisplayRecordsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // JDBC URL, username, and password of MySQL server
        String jdbcUrl = "jdbc:mysql://localhost:3306/teacher";
        String username = "root";
        String password = "root";

        // JDBC variables for opening, closing and managing connection
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to MySQL database
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Prepare SQL statement to retrieve all records from the teachers table
            String sql = "SELECT * FROM teachers";
            preparedStatement = connection.prepareStatement(sql);

            // Execute the SQL query
            resultSet = preparedStatement.executeQuery();

            // Display the records in an HTML table with CSS styling
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Teacher Records</title>");
            out.println("<style>");
            out.println(".container {");
            out.println("    display: flex;");
            out.println("    justify-content: center;");
            out.println("    align-items: center;");
            out.println("    height: 100vh;");
            out.println("}");
            out.println(".card {");
            out.println("    background-color: #fff;");
            out.println("    border-radius: 10px;");
            out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
            out.println("    padding: 20px;");
            out.println("    max-width: 600px;");
            out.println("}");
            out.println("table {");
            out.println("    width: 100%;");
            out.println("    border-collapse: collapse;");
            out.println("}");
            out.println("th, td {");
            out.println("    padding: 8px;");
            out.println("    text-align: left;");
            out.println("    border-bottom: 1px solid #ddd;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<div class='card'>");
            out.println("<h2 style=\"color:#00A6FF ;\">Teacher Records</h2>");
            out.println("<table>");
            out.println("<tr style=\"color:#D500FF\" ><th>ID</th><th>Name</th><th>Age</th><th>Email</th></tr>");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + age + "</td><td>" + email + "</td></tr>");
            }
            out.println("</table>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
