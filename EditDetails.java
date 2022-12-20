package EWA;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditDetails
 */
public class EditDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        String id = request.getQueryString();
        System.out.println("Query String: "+id);
		String[] IDS = id.split("=");
		System.out.println("Edit Servlet: "+IDS[1]);
		String ename = IDS[1];
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	         
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","Ha@020502");
    		
    		String query = "select * from info where name = ?";
    		
    		PreparedStatement pst = con.prepareStatement(query);
    		pst.setString(1, ename);
    		
    		ResultSet rs = pst.executeQuery();
    		
    		while(rs.next()) {
    			out.print("<form action='UpdateDetails?id="+rs.getString(1)+"' method='post'>");  
                out.print("<table>");  
                out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+rs.getString(1)+"' disabled/></td></tr>");    
                out.print("<tr><td>Password:</td><td><input type='id' name='id' value='"+rs.getInt(2)+"'/></td></tr>");  
                out.print("<tr><td>Age:</td><td><input type='number' name='age' value='"+rs.getInt(3)+"'/></td></tr>");  
                out.print("<tr><td>Languages:</td><td><input type='text' name='Education' value='"+rs.getString(4)+"'/></td></tr>");
                out.print("<tr><td>Instructions:</td><td><input type='text' name='post' value='"+rs.getString(5)+"'/></td></tr>");
                out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");  
                out.print("</table>");  
                out.print("</form>");  
    		}
    		
    		
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
