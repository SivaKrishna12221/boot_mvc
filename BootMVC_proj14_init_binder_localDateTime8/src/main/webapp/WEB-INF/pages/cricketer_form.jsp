<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Cricker Form</title>
</head>
<body>
	<h1 Style="text-align: center; color: green">Circketer Form page</h1>
	<f:form action="cricketer_data" name="frm" modelAttribute="cric">
		<table align="center">
			<tr>
				<td>Name::</td>
				<td><f:input path="name" /></td>
			</tr>
			<tr>
				<td>type::</td>
				<td><f:input path="type" /></td>
			</tr>
			<tr>
				<td>dob::</td>
				<td><f:input path="dob" type="date" /></td>
			</tr>
			<tr>
			<td>tob::</td>
			<td><f:input path="tob" type="time"/></td>
			</tr>
			<tr>
				<td>doj::</td>
				<td><f:input path="doj" type="dateTime-local"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="save" /></td>
				<td><input type="reset" value="cancel"></td>
		</table>
	</f:form>
</body>
</html>