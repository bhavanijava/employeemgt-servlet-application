

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registercode
 */
@WebServlet("/Registercode")
public class Registercode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registercode() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("uname");
		String password=request.getParameter("pwd");
		String email=request.getParameter("mail");
		String gender=request.getParameter("gender");
		String mobileno=request.getParameter("mno");
		String state=request.getParameter("ustate");
		String country=request.getParameter("ucountry");
		String address=request.getParameter("addr");

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bdb", "bdb");
			PreparedStatement ps=con.prepareStatement("insert into empreg values(?,?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,gender);
			ps.setString(5,mobileno);
			ps.setString(6,state);
			ps.setString(7,country);
			ps.setString(8,address);


			int i=ps.executeUpdate();
			out.print(i+"Record inserted successfully.....");
			con.close();



		}
		catch(Exception ex)
		{
			out.print(ex);
		}

	}
}
