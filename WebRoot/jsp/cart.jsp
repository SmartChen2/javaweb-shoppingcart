<%@ page language="java" import = "java.sql.*" import = "java.util.*"  pageEncoding="gb2312" %>

<html>
	<body>
		<h1 align = "center">购物车</h1>
		
		<td>冷鸟  200元 </td>
		<img src="22.jpg" width="200" height="200" /><BR>
		
		<td>海豹  968元 </td>
		<img src="haibao.gif" width="200" height="200" /><BR>
		
		<form action="http://localhost:8080/pr/jsp/cart.jsp" method="POST"> <%-- 按了提交之后会跳转到这个网址 --%>
			请输入商品:<input name= "good", type = "text">
			<input type = "submit" value = 添加到购物车>
		</form>
		
		
		<%--session 会保存服务器关闭之前的数据 --%>
		<HR>
		已加入购物车中的商品:<BR>
		<%
			ArrayList goods = (ArrayList)session.getAttribute("goods"); //获取服务器上原有的goods
			if (goods == null)  {
				goods = new ArrayList();
				session.setAttribute("goods", goods);
			}
			String good = request.getParameter("good");//获取输入的商品
			if (good != null) {
				good = new String(good.getBytes());
				goods.add(good);
			} 
		%>
		
		<%
			for (int i = 0; i < goods.size(); i++) {
				out.println(goods.get(i) + "<BR>");
			}
		 %>
	</body>
</html>