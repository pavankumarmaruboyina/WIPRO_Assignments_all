package Assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet1() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");

		// Get form parameters
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		// Write response
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Form Submitted Successfully!</h2>");
		out.println("<p><strong>Name:</strong> " + name + "</p>");
		out.println("<p><strong>Password:</strong> " + password + "</p>");
		out.println("</body></html>");
	}
}
