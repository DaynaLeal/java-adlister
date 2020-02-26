import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class HelloWorldServlet extends HttpServlet {

    int count = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //bonus 2: Create a page that displays a number that goes up by one every time the /count page is viewed.
        count++;
        //bonus 3: Make the page say "Hello, <name>!" if name is passed as part of the query string (e.g. /hello?name=codeup), otherwise default to "Hello, World!".
        String name = request.getParameter("name");
        if(name == null){
            name = "World";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Hello " + name + "!</h3>");
        //response.getWriter().println("<h3>Hello World!</h3>"); //this is also a refactor option
        response.getWriter().println("<p>Page Visits: " + count + "</p>");
    }
}
