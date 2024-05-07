import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/SelectTeachersServlet")
public class SelectTeachersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/teacher";
        String username = "root";
        String password = "root";

        // SQL query to select all records from the teachers table
        String sql = "SELECT * FROM teachers";

        try (
                // Establish a database connection
                Connection connection = DriverManager.getConnection(url, username, password);
                // Create a statement
                Statement statement = connection.createStatement();
                // Execute the query and get the result set
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            // Set response content type
            response.setContentType("text/html");

            // Get the PrintWriter object to write the HTML response
            PrintWriter out = response.getWriter();

            // Write HTML response
            out.println("<html><head><title>Teachers</title></head><body>");
            out.println("<h2>Teachers</h2>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Age</th><th>Email</th></tr>");

            // Iterate through the result set and display each record in a table row
            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getInt("id") + "</td>");
                out.println("<td>" + resultSet.getString("name") + "</td>");
                out.println("<td>" + resultSet.getInt("age") + "</td>");
                out.println("<td>" + resultSet.getString("email") + "</td>");
                out.println("</tr>");
            }

            out.println("</table></body></html>");
        } catch (SQLException e) {
            // Handle any errors
            e.printStackTrace();
            // Redirect to a general error page if needed
            // response.sendRedirect("general-error.html");
        }
    }
}
