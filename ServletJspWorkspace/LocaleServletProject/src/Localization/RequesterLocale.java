package Localization;
//display a language and associated country for a request
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequesterLocale
 */
@WebServlet("/RequesterLocalePath")
public class RequesterLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequesterLocale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
		      //Get the client's Locale
		      Locale locale = request.getLocale();
		      String language = locale.getLanguage();
		      String country = locale.getCountry();

		      // Set response content type
		      response.setContentType("text/html");
		      PrintWriter out = response.getWriter();

		      String title = "Detecting Locale";
		      out.println("<html>\n" +
		        "<head><title>" + title + "</title></head>\n" +
		        "<body bgcolor=\"#f0f0f0\">\n" +
		        "<h1 align=\"center\">" + language + "</h1>\n" +
		        "<h2 align=\"center\">" + country + "</h2>\n" +
		        "</body></html>");
		  }

	}

	

}
