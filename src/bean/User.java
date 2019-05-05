package bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class User extends HttpServlet {
	private String id;
	private String pw;
	/**
	 * Constructor of the object.
	 */
	public User() {
		super();
	}

	public void setId(String g) {
		this.id = g;
	}
	public void setPw(String gn) {
		this.pw = gn;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}

}
