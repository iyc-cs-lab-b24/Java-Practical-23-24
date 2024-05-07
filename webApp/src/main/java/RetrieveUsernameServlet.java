import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/retrieveUsername")
public class RetrieveUsernameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve the cookie with the username
        Cookie[] cookies = request.getCookies();
        String username = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        // Write HTML response with CSS styling
        response.setContentType("text/html");
        response.getWriter().println("<html><head><title>Retrieve Username</title>");
        response.getWriter().println("<style>");
        response.getWriter().println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        response.getWriter().println("h2 { margin-top: 0; font-size: 24px; color: #333333; }");
        response.getWriter().println("</style>");
        response.getWriter().println("</head><body>");
        response.getWriter().println("<h2>Username: " + (username != null ? username : "Cookie not found!") + "</h2>");
        response.getWriter().println("</body></html>");
    }
}
