package EWA;

import java.sql.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeePage
 */
public class EmployeePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Welcome</title></head>");
	         out.println("<body><h2>You have entered</h2>");
	         
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Ha@020502");
	         
	         // Retrieve the value of the query parameter "username" (from text field)
	         String Name = request.getParameter("username");
	         if (Name == null) {
	        	 System.out.println("Please enter your Name");
	         }
	         else {
	        	 out.println("<p>Name: " +Name + "</p>");
	         }
	      // Retrieve the value of the query parameter "password" (from password field)
	         String ID = request.getParameter("id");
	         if (ID == null) {
	        	 System.out.println("Please Enter your Assigned ID");
	         }
	         else {
	        	 out.println("<p>ID: " + ID + "</p>");
	         }
	         // Retrieve the value of the query parameter "gender" (from radio button)
	         String gender = request.getParameter("gender");
	         if (gender == null) {
	             System.out.println("Please enter your gender!!");
	          } else if (gender.equals("m")) {
	             out.println("<p>Gender: male</p>");
	          } else {
	             out.println("<p>Gender: female</p>");
	          }
	      // Retrieve the value of the query parameter "age" (from pull-down menu)
	         String age = request.getParameter("age");
	         if (age == null) {
	            System.out.println("Please Enter your age!!");
	         } else {
	        	 
	         }
	      // Retrieve the value of the query parameter "language" (from checkboxes).
	         // Multiple entries possible.
	         // Use getParameterValues() which returns an array of String.
	         String[] POST = request.getParameterValues("post");
	         String pst = null;
	         // Get null if the parameter is missing from query string.
	         if (POST == null || POST.length == 0) {
	            System.out.println("You Have selected None Posts");
	         } else {
	            out.println("<p>Posts: ");
	            for (String ps : POST) {
	               if (ps.equals("software engineer")) {
	                  out.println("Software Engineer ");
	                  pst = "Software Engineer";
	               } else if (ps.equals("manager")) {
	                  out.println("Manager");
	                  pst = pst + " Manager";
	               } else if (ps.equals("marketing team")) {
	                  out.println("Marketing Team");
	                  pst = pst + " Marketing Team";
	               }
	            }
	            out.println("</p>");
	         }
	      // Retrieve the value of the query parameter "instruction" (from text area)
	         String Education = request.getParameter("education");
	         if (Education == null) {
	        	 System.out.println("Please Enter your Education Details");
	         }
	         else {
	        	 out.println("<p>Instruction: " + Education + "</p>");
	         }
	      // Retrieve the value of the query parameter "secret" (from hidden field)
			/*
			 * String secret = request.getParameter("secret"); out.println("<p>Secret: " +
			 * secret + "</p>");
			 */
	      // Hyperlink "BACK" to input page
	         out.println("<a href='index.jsp'>BACK</a>"+"  "+"<a href='ViewServlet'>View Details</a>");
	 
	         out.println("</body></html>");
	         
	         String query = "INSERT into info VALUES (ID,'Name',age,'Education','pst')";
	      
	         Statement stmt = con.createStatement();
	         
	         int record = stmt.executeUpdate(query);
	         
	         if(record == 1) {
	        	 	out.println("<h2>Record Inserted Successfully</h2>");
	         }else {
	        	 out.println("<h2>Error in saving the record!!<h2>");
	         }
	         
	         out.println("</body></html>");
	      
	      } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	      finally {
	          out.close();  // Always close the output writer
	       }
	}

}
