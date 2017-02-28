package servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class MyServlet1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5598983689849651912L;
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\n" + "<html>\n" +
			"<head><title>A Test Servlet</title></head>\n" +
			"<body bgcolor=\"#fdf5e6\">\n" +
			"<h1>Test</h1>\n" +
			"<p>Simple servlet for testing.</p>\n" +
			"</body></html>");
	}

}
