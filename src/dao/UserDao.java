package dao;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import bean.User;


public class UserDao  {
	public ArrayList queryAllGoods() throws Exception {
		Connection conn = null;
		ArrayList users = new ArrayList();
		try { 
			//��ȡ����
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:DSUser";
			conn = DriverManager.getConnection(url, "", "");
			//����SQL���
			String sql = "select id, pw from User";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()){
				User user = new User();
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				users.add(user);
			}
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception ex) {
				
			}
		}
		return users;
	}
}
