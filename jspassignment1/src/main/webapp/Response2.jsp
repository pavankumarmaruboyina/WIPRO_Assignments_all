<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
    <title>Display Info</title>
</head>
<body>
    <h2>Received Info:</h2>
    Name: <%= request.getParameter("name") %><br>
    Password: <%= request.getParameter("password") %>
    
</body>
</html>