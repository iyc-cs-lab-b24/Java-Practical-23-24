import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/displayCookies")
public class DisplayCookiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();

        out.println("<html><head><title>Cookie Information</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f9f9f9; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println(".card { background-color: #ffffff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); padding: 20px; }");
        out.println("h2 { text-align: center; color: #333333; margin-bottom: 20px; }");
        out.println("ul { list-style-type: none; padding: 0; }");
        out.println("li { padding: 10px 0; border-bottom: 1px solid #007bff; }"); // Changed line color to blue
        out.println(".bold { font-weight: bold; }"); // Added class for bold text
        out.println("</style>");
        out.println("</head><body>");
        out.println("<div class='card'>");
        out.println("<h2>Cookie Information</h2>");

        if (cookies != null && cookies.length > 0) {
            out.println("<ul>");
            for (Cookie cookie : cookies) {
                out.println("<li><span class='bold'>Name:</span> " + cookie.getName() + ", <span class='bold'>Value:</span> " + cookie.getValue() + "</li>"); // Made "Name:" and "Value:" text bold
            }
            out.println("</ul>");
        } else {
            out.println("<p>No cookies found.</p>");
        }

        out.println("</div>");
        out.println("</body></html>");
    }
}
