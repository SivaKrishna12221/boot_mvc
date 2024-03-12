<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Syr Properties</title>

</head>
<body>
	<h1 style="color: green; text-align: center;">Welcome to SYR
		properties</h1>
	<f:form action="customer_data" name="frm" modelAttribute="investor">
		<table align="center">
			<tr>
				<td>Investor number::</td>
				<td><f:input path="ino" /></td>
			</tr>
			<tr>
				<td>Name::</td>
				<td><f:input path="name" /></td>
			</tr>
			<script language="JavaScript">
				function sendRequestForStates()//if we get the country name then send the name to js and it submit with action request
				{
					frm.action = "states";
					frm.submit();
				}
			</script>
			<tr>
				<td>Country::</td>
				<td><f:select path="country"
						onchange="sendRequestForStates(this)">
						<f:options items="${countries }" />
					</f:select></td>
			</tr>
			<tr>
				<td>state::</td>
				<td><f:select path="state">
						<f:options items="${statesOfCountry}"></f:options>
					</f:select></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" /></td>
				<td><input type="reset" value="cancel" /></td>
			</tr>

		</table>
	</f:form>
</body>
</html>