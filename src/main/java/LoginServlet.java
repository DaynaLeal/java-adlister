import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if((session.getAttribute("user") != null) && ((boolean) session.getAttribute("user"))){
            response.sendRedirect("/profile");
        } else {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getMethod().equalsIgnoreCase("post")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Boolean validLogin = (username != null && username.equals("admin")) && (password != null && password.equals("password"));

            HttpSession session = request.getSession();

            if (validLogin) {
                session.setAttribute("user", true);
                session.setAttribute("username", username);
                response.sendRedirect("/profile");
            } else {
                session.setAttribute("user", false);
                response.sendRedirect("/login");
            }
        }
    }
}
//