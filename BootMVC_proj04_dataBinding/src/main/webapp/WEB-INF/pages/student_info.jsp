<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student info page</title>
</head>
<body>
	<h1>Naresh It</h1>
	<form action="student_info" method="post">
		<lable>Student Id</lable>
		<input type="text" name="sId" /><br>
		<lable>Student Name</lable>
		<input type="text" name="sName" /><br>
		<lable>Student address</lable>
		<input type="text" name="sAddress" /><br>
		<lable>Student course</lable>
		<input type="text" name="sCourse" /><br> 
		<input type="submit" value="register" />

	</form>
</body>
</html>