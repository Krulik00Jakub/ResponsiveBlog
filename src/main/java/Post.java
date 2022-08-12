

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Post
 * Servlet creates a post based off of content contained in a database (i.e., dynamic webpage)
 */
@WebServlet("/Post")
public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Post() {
        super();
    }

	/**
	 * Sends a formatted HTML document on HTTP Get request.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		
		Modular mod;
		try {
			mod = new Modular("C:\\Users\\Jakub\\eclipse-workspace\\Sinoling\\src\\main\\webapp\\Week1D3.html");
		} catch (Exception e) {
			throw new IOException(e);
		}
		
		out.println("<HTML>");
		
		out.println("<HEAD>");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" charset=\"utf-8\">");
		out.println("<TITLE>Week1D3</TITLE>");
		out.println("<link rel=\"stylesheet\" href=\"style.css\">");
		out.println("</HEAD>");
		
		out.println("<BODY>");
		out.println(mod.topNav());
		out.println(mod.content());
		out.println("</BODY>");
		
		out.println("</HTML>");
	} // end of doGet(request, response) method

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
