<%@ page language="java" import = "java.util.*, java.sql.*"  pageEncoding="gb2312" isErrorPage = "true" %>
<%@ page import = "dao.UserDao" %>
<%@ page import = "bean.User" %> 
<html>
	<body>
		<% 
			UserDao ud = new UserDao();
			ArrayList users = ud.queryAllGoods();
		 %>
		 <table border = 2>
		 	<tr>
		 		<td>用户id</td>
		 		<td>用户密码</td>
		 	</tr>
		 	<%
		 		for(int i = 0; i< users.size(); i++) {
		 			User u = (User)users.get(i);
		 	%>
		 	<tr>
		 		<td><% out.print(u.getId()); %></td>
		 		<td><% out.print(u.getPw()); %></td>
		 	</tr>
		 	<% } %>
		 </table>		 
	</body>
</html>