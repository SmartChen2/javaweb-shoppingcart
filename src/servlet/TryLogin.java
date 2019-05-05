package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TryLogin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TryLogin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public boolean verifyPw(HttpServletResponse response, String id, String pw) throws Exception {
		String str = "";
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String url = "jdbc:odbc:DSUser";
		Connection conn = null;
		conn = DriverManager.getConnection(url, "", "");
		//运行SQL语句
		
		PreparedStatement sql=null;  
		 sql =conn.prepareStatement("select * from User where id=? and pw=?");
		 sql.setString(1,id);
		 sql.setString(2,pw);
		ResultSet rs = sql.executeQuery();
	
		boolean fl = true;
		if(!rs.next()) {
			out.println("id不存在或者密码错误 请重试");
			fl = false;
		}

		rs.close();
		sql.close();
		conn.close();
		return fl;
	}
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//out.println(3223);
		boolean f = false;
		try {
			 f = verifyPw(response, id, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (f) {
			response.sendRedirect("http://localhost:8080/pr/jsp/cart.jsp");
		}
		out.flush();
		out.close();
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
