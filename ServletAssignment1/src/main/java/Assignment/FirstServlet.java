package Assignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("password", password);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Data Stored in Session</h2>");
        out.println("<a href='SecondServlet'>Go to Second Servlet</a>");
    }
}
