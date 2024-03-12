<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<h1 style="color:orange;text-align:center;">Modify doctor properties</h1>
<f:form modelAttribute="docs">
<table border="0" bgcolor="yellow" align="center">
<tr><td>Doctor Number::</td><td><f:input path="doctorId" readonly="true"/></td></tr>
<tr><td>Doctor Name::</td><td><f:input path="doctorName" /></td></tr>
<tr><td>Specialization::</td><td><f:input path="specialization"/></td></tr>
<tr><td>Income::</td><td><f:input path="income"/></td></tr>
<tr><td><input type="submit" value="save"></td><td><input type="reset" value="reset"></td></tr>
</table>
</f:form>