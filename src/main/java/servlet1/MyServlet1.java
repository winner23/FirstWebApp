package servlet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
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
	static public List<User> users;
	
	public void init(ServletConfig config) throws ServletException {
		 users = new ArrayList<User>();
    }
	
	class User{
		private String firstName;
		private String lastName;
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public User(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		@Override
		public String toString(){
			return "User: "+firstName+", "+lastName;
		}
		
		
	}
	
	private static final long serialVersionUID = 5598983689849651912L;
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fn = request.getParameter("firstName");
		String ln = request.getParameter("lastName");
		users.add(new User(fn,ln));
		String table ="<thead><tr><th>First Name</th><th>Last Name</th></tr></thead><tbody>";
		for(User user:users){
			table +="<tr><td>"+user.getFirstName()+"</td><td>"+user.getLastName()+"</td></tr>";
		}
		table +="</tbody>";
		out.println("<!DOCTYPE html>\n" + "<html>\n" +
			""+
			"<head><title>A Test Servlet</title> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"+
			"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
			"<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">"+
			"<link rel=\"stylesheet\" href=\"https://code.getmdl.io/1.3.0/material.indigo-pink.min.css\">"+
			"<script defer src=\"https://code.getmdl.io/1.3.0/material.min.js\"></script>"+
			"</head>\n" +
			"<body>\n" +
			"<h1>Users</h1>\n" +
			"<h2> Name: "+ fn +", " + ln + " added!</h2>"+
			"<p>List of all users bellow.</p>\n" +
			"<table class=\"mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp\">"+table+"</table>"+
			"<a href=\"index.jsp\"><img src=\"/img/back.jpg\"></a>"+
			"</body></html>");
	}
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fn = request.getParameter("remove");
		
		
	}
}
