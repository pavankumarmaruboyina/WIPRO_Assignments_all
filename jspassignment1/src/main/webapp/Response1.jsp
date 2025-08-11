<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Form 1</title>
</head>
<body>
    <h2>Enter Details</h2>
    <form action="Response2.jsp" method="post">
        Name: <input type="text" name="name"><br><br>
        Password: <input type="password" name="password"><br><br>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
</body>
</html>