<%@ page language="java" import = "java.sql.*" import = "java.util.*"  pageEncoding="gb2312" %>

<html>
	<body>
		<h1 align = "center">���ﳵ</h1>
		
		<td>����  200Ԫ </td>
		<img src="22.jpg" width="200" height="200" /><BR>
		
		<td>����  968Ԫ </td>
		<img src="haibao.gif" width="200" height="200" /><BR>
		
		<form action="http://localhost:8080/pr/jsp/cart.jsp" method="POST"> <%-- �����ύ֮�����ת�������ַ --%>
			��������Ʒ:<input name= "good", type = "text">
			<input type = "submit" value = ��ӵ����ﳵ>
		</form>
		
		
		<%--session �ᱣ��������ر�֮ǰ������ --%>
		<HR>
		�Ѽ��빺�ﳵ�е���Ʒ:<BR>
		<%
			ArrayList goods = (ArrayList)session.getAttribute("goods"); //��ȡ��������ԭ�е�goods
			if (goods == null)  {
				goods = new ArrayList();
				session.setAttribute("goods", goods);
			}
			String good = request.getParameter("good");//��ȡ�������Ʒ
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