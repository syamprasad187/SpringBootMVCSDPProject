<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body style="background-color: #FCFAEE; font-family: Arial, sans-serif;">
<%@include file="mainnavbar.jsp" %>

<!-- Card container -->
<div style="background-color: #ECDFCC; border: 2px solid #A5B68D; border-radius: 15px; padding: 30px; width: 50%; margin: 50px auto; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);">

    <h2 style="text-align: center; color: #DA8359; font-family: 'Arial', sans-serif; font-weight: bold;">Flow Of Project</h2>
    <ol style="list-style-type: decimal; margin: 20px 0; padding: 0;">
        <li style="color: #DA8359; font-weight: bold; padding: 10px 0;">Controller Layer will access Service Layer</li>
        <li style="color: #DA8359; font-weight: bold; padding: 10px 0;">Service Layer will access Repository Layer</li>
        <li style="color: #DA8359; font-weight: bold; padding: 10px 0;">Repository Layer contains Database Logic</li>
    </ol>
    
</div>

</body>
</html>
