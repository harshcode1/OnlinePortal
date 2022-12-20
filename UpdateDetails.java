package EWA;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateDetails
 */
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDetails() {
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
		//doGet(request, response);
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        String id = request.getQueryString();
        System.out.println("Query String: "+id);
		String[] IDS = id.split("=");
		System.out.println("Edit Servlet: "+IDS[1]);
		String ename = IDS[1];
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
	         
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Ha@020502");
           
    		String username = ename;
    		String ID = request.getParameter("id");
    		String age = request.getParameter("age");
    		String post = request.getParameter("post");
    		String Education = request.getParameter("Education");
    		
            PreparedStatement ps=con.prepareStatement("update info set name=?,ID=?,age=?, post=?, Education=? where name = ?");  
            ps.setString(1,username);  
            ps.setString(2,ID);  
            ps.setString(3,age);
            ps.setString(4,post);
            ps.setString(5, Education);
              
            int status=ps.executeUpdate();  
            
            response.sendRedirect("/project/ViewTable");
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
	}

	}

}
