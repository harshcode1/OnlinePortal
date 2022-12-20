package EWA;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewTable
 */
public class ViewTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTable() {
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
        out.println("<h1>Employees List</h1>");  
        try {
        		Class.forName("com.mysql.cj.jdbc.Driver");
	         
        		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Ha@020502");
	         
        		Statement st = con.createStatement();
        		
        		String query = "select * from info";
        		ResultSet rs = st.executeQuery(query);
        		out.print("<table border='1' width='100%'");  
    	        out.print("<tr><th>Name</th>"
    	        			+ "<th>ID</th>"
    	        			+ "<th>Age</th>"
    	        			+ "<th>POST</th>"
    	        			+ "<th>EDUCATION</th>"
    	        		+ "</tr>");
	while(rs.next()) {
		 out.print("<tr>"
	 				+"<td>"+rs.getString(1)+"</td>"
	 				+"<td>"+rs.getString(2)+"</td>"
	 				+"<td>"+rs.getString(3)+"</td>"
	 				+"<td>"+rs.getInt(4)+"</td>"
	 				+"<td>"+rs.getString(5)+"</td>"
	 			+"</tr>");      	        
}
}catch(ClassNotFoundException e) {
e.printStackTrace();
} catch (SQLException e) {
// TODO Auto-generated catch block
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
