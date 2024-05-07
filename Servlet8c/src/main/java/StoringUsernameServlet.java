import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/storeUsername")
public class StoringUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve the username from the HTML form
        String username = request.getParameter("username");

        // Get or create a session
        HttpSession session = request.getSession();

        // Store the username in the session
        session.setAttribute("username", username);

        // Write a confirmation message with a button to redirect to RetrieveUsernameServlet
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Username Stored</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f0f0f0; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println(".card { background-color: #fff; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); transition: 0.3s; width: 300px; border-radius: 5px; padding: 20px; text-align: center; }");
        out.println("h2 { font-size: 24px; color: #333333; }");
        out.println("form { text-align: center; }"); // Center-align form elements
        out.println("input[type='submit'] { background-color: #007bff; color: #ffffff; border: none; border-radius: 4px; cursor: pointer; padding: 10px; font-size: 16px; transition: background-color 0.3s; }");
        out.println("input[type='submit']:hover { background-color: #0056b3; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"card\">");
        out.println("<h2>Username stored in session successfully!</h2>");
        out.println("<br>");
        out.println("<form action='retrieveUsername'>");
        out.println("<input type='submit' value='Retrieve Username'>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
