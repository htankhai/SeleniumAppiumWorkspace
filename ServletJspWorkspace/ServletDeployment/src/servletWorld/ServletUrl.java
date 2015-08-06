package servletWorld;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletIntro
 */
@WebServlet(description = "Servlet Introduction", urlPatterns = { "/ServletIntroPath" })
public class ServletUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		System.out.println("display get method");

		PrintWriter out = response.getWriter();

		String title = "Servlet: Read Form Data";
		out.println("<html>" + "<head><title>" + title
				+ "</title></head><body>"
				+ "<h1>" + title + "</h1>"+
				"<h2>Get method in Html " +  new Date()
		+ "<p>Hi "
		+ request.getParameter("name")
		+ "</p>"
		+ "</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String title = "Servlet: Read Form Data";
		out.println("<html>" + "<head><title>" + title
				+ "</title></head><body>"
				+ "<h1>" + title + "</h1>"
				+ "<p>Hi "
				+ request.getParameter("name")
				+ "</p>"
				+ "</body></html>");
	}

}
