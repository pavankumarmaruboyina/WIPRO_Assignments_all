package Assignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if ("admin".equals(name) && "wipro".equals(password)) {
            
            RequestDispatcher rd = request.getRequestDispatcher("SuccessServlet");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("fail.html");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.html");
    }
}

