<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<h1 style="color:green;text-align:center">add New Doctor</h1>
<f:form modelAttribute="docs" >
<table align="center" bgcolor="cyan">
 <tr><td> Doctor Name::</td><td><f:input path="doctorName"/></td>
 <tr><td>specialization::</td><td><f:input path="specialization"/></td>
 <tr><td> income::</td><td><f:input path="income"/></td>
  <tr><td><input type="submit" value="submit"/></td><td><input type="reset"></td></tr>
  </table>
</f:form>
