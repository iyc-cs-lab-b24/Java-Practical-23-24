import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/storeUsername")
public class StoreUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve the username from the HTML form
        String username = request.getParameter("username");

        // Create a cookie with the username
        Cookie usernameCookie = new Cookie("username", username);

        // Add the cookie to the response
        response.addCookie(usernameCookie);

        // Write a confirmation message with a button to redirect to RetrieveUsernameServlet
        response.setContentType("text/html");
        response.getWriter().println("<html><head><title>Username Stored</title>");
        response.getWriter().println("<style>");
        response.getWriter().println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; justify-content: center; align-items: center; height: 100vh; }");
        response.getWriter().println("h2 { padding-top: 100px;margin-top: 100px;font-size: 24px;text-align: center; color: #333333; }");
        response.getWriter().println("form { text-align: center; }"); // Center-align form elements
        response.getWriter().println("input[type='submit'] { margin-top: 10px;padding-right: 300px; background-color: #007bff; color: #ffffff; border: none; border-radius: 4px; cursor: pointer; padding: 10px; font-size: 16px; transition: background-color 0.3s; }");
        response.getWriter().println("input[type='submit']:hover { background-color: #0056b3; }");
        response.getWriter().println("</style>");
        response.getWriter().println("</head><body>");
        response.getWriter().println("<h2>Username stored as cookie successfully!</h2>");
        response.getWriter().println("<form action='retrieveUsername'>");
        response.getWriter().println("<input type='submit' value='Retrieve Username'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }
}
