<%@page import="com.klef.jfsd.springboot.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Employee emp = (Employee) session.getAttribute("employee");

if(emp == null){
	response.sendRedirect("empsessionexpiry");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Home</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #FCFAEE;
        margin-left: 220px; /* For navbar adjustment */
    }

    .profile-card {
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: justify;
    }

    h3 {
        text-align: center;
        font-size: 24px;
        margin-bottom: 20px;
        text-decoration: underline;
    }

    .profile-info {
        font-size: 18px;
        margin: 10px 0;
    }

    .profile-info b {
        font-weight: bold;
    }

    .profile-info span {
        margin-left: 10px;
    }

</style>
</head>
<body>
<%@include file="empnavbar.jsp" %>

<h3>My Profile</h3>

<div class="profile-card">
    <div class="profile-info"><b>ID:</b><span><%=emp.getId()%></span></div>
    <div class="profile-info"><b>NAME:</b><span><%=emp.getName()%></span></div>
    <div class="profile-info"><b>GENDER:</b><span><%=emp.getGender()%></span></div>
    <div class="profile-info"><b>DATE OF BIRTH:</b><span><%=emp.getDateofbirth()%></span></div>
    <div class="profile-info"><b>DEPARTMENT:</b><span><%=emp.getDepartment()%></span></div>
    <div class="profile-info"><b>SALARY:</b><span><%=emp.getSalary()%></span></div>
    <div class="profile-info"><b>LOCATION:</b><span><%=emp.getLocation()%></span></div>
    <div class="profile-info"><b>EMAIL:</b><span><%=emp.getEmail()%></span></div>
    <div class="profile-info"><b>CONTACT:</b><span><%=emp.getContact()%></span></div>
    <div class="profile-info"><b>STATUS:</b><span><%=emp.getStatus()%></span></div>
</div>

</body>
</html>
