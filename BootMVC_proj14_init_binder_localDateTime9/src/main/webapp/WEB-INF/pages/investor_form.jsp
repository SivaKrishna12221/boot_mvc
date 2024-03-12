<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<h1 style="color:green;text-align:center;">Welcome to SYR properties</h1>
<h3 style="text-align:center;">Enter Investor info</h3>
<f:form action="register" method="post" modelAttribute="investor" >
 <table align="center">
 <tr><td>Investor number::</td><td><f:input path="ino"/></td><tr>
 <tr><td>Name::</td><td><f:input path="name"/></td></tr>
 <tr><td>date of register::</td><td><f:input type="date" path="dor"/></td></tr>
 <tr><td>time of register::</td><td><f:input type="time" path="tor"/></td></tr>
 <tr><td>date and time of exit::</td><td><f:input type="dateTime-local" path="exit"/></td></tr>
 <tr><td><input type="submit" value="save"/></td><td><input type="reset" value="cancel"/></td></tr>
 
 </table>
</f:form>
