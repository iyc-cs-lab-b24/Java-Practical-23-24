import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve data from the request parameters
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/teacher";
        String username = "root";
        String password = "root";

        // SQL query to insert data into the database
        String sql = "INSERT INTO teachers (name, age, email) VALUES (?, ?, ?)";

        try (
                // Establish a database connection
                Connection connection = DriverManager.getConnection(url, username, password);
                // Create a prepared statement
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            // Set the parameters of the prepared statement
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, email);

            // Execute the SQL statement to insert the data
            statement.executeUpdate();

            // Redirect to a success page
            response.sendRedirect("registration-success.html");
        } catch (Exception e) {
            // Handle any errors
            e.printStackTrace();
            response.sendRedirect("registration-error.html");
        }
    }
}
