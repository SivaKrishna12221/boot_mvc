<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<h1 style="color:green;text-align:center;">Register form</h1>
<f:form modelAttribute="seekar" enctype="multipart/form-data">
<table align="center">
<tr><td>name</td><td><f:input path="name"/></td></tr>
<tr><td>gender</td><td><f:radiobutton path="gender" value="male"/>male&nbsp;
                        <f:radiobutton path="gender" value="female"/>female</td></tr>

<tr><td>photo</td><td><f:input type="file" path="photo"/></td></tr>

<tr><td>resume</td><td><f:input type="file" path="resume"/></td></tr>
<tr><td><input type="submit" value="register"></td><td><input type="reset" value="cancel"></td></tr>

</table>
</f:form>
