<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<h1 style=color:green;text-align:center> Edit student Register form:</h1>
<f:form action="saveStudInfo" method="post" modelAttribute="sInfo">
 <table style=bgcolor:cyan;text-align:center >
 <tr><td>student Id::</td><td><f:input path="sId"/></td></tr>
<tr><td>student Name::</td><td><f:input path="sName"/></td></tr>
<tr><td>student Address::</td><td><f:input path="sAddress"/></td></tr>
<tr><td>student course::</td><td><f:input path="sCourse"/></td></tr>
<tr><td colspan=2><input type="submit"></td></tr>

 </table>
</f:form>