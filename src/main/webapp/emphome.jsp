<!DOCTYPE html>

<%@page import="com.klef.jfsd.springboot.model.Employee"%>
<%
/* through emp, we can access methods in employee object */
	Employee emp = (Employee)session.getAttribute("employee");

	if(emp == null){
		response.sendRedirect("empsessionexpiry");
		return;
	}
%>

<html>
<head>
<meta charset="UTF-8">
<title>Employee Home</title>
</head>
<body>
<%@include file="empnavbar.jsp" %>
<h3 align="center" style="color: blue" >Welcome <%=emp.getName() %></h3>
</body>
</html>