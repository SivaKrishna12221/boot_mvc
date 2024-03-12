<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student form</title>
<script type="text/javascript" src="js/student_validation.js"></script>
</head>
<body>
   <h1 Style="text-align:center">Add new Student</h1>
   <f:form modelAttribute="stud" onsubmit="return studValidate(this)">
  <%--  <p style="color:red;text-align:center"><f:errors path="*"/></p> --%>
    <table align="center">
   <tr><td>Student Name::</td><td><f:input path="name"/><f:errors path="name" cssStyle="color:red"/><spam id="name_err" style="color:red"></spam></td></tr>
   <tr><td>course::</td><td><f:input path="course"/><f:errors path="course" cssStyle="color:red"/><spam id="course_err" style="color:red"></spam></td></tr>
   <tr><td>Age::</td><td><f:input path="age"/><f:errors path="age"  cssStyle="color:red"/><spam id="age_err" style="color:red"></spam></td></tr>
   <tr><td>mobile number::</td><td><f:input path="mobile"/><f:errors path="mobile" cssStyle="color:red"/><spam id="mobile_err" style="color:red"></spam></td></tr>
   <tr><td>Fees::</td><td><f:input path="fees"/><f:errors path="fees" cssStyle="color:red"/><spam id="fees_err" style="color:red"></spam></td></tr>
   <tr><td>Date::</td><td><f:input path="dof"/></td></tr>
   <tr><td><f:hidden path="validateFlag"/></td></tr>
    <tr><td><input type="submit" value="add"/></td><td><input type="reset" value="reset"/></td></tr>  
   </table>
    
   </f:form>
   <a href="./">Home</a>
</body>
</html>