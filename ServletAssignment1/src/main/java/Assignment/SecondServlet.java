package Assignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null) {
            String name = (String) session.getAttribute("name");
            String password = (String) session.getAttribute("password");

            out.println("<h2>Session Data from Second Servlet</h2>");
            out.println("Name: " + name + "<br>");
            out.println("Password: " + password);
        } else {
            out.println("<h2>No Session Found. Please login first.</h2>");
        }
    }
}

