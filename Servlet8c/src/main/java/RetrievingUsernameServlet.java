import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/retrieveUsername")
public class RetrievingUsernameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the session
        HttpSession session = request.getSession();

        // Retrieve the username from the session
        String username = (String) session.getAttribute("username");

        // Write the username to the response with boxy design
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Retrieve Username</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f0f0f0; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println(".box { background-color: #fff; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); transition: 0.3s; width: 300px; border-radius: 5px; padding: 20px; text-align: center; }");
        out.println("h2 { font-size: 24px; color: #333333; }");
        out.println(".username { color: #007bff; font-weight: bold; }"); // Username color
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"box\">");
        if (username != null) {
            out.println("<h2>Username: <span class=\"username\">" + username + "</span></h2>");
        } else {
            out.println("<h2>No username found in session!</h2>");
        }
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
