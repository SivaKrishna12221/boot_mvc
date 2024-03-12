<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit employee</title>
<style>
  @keyframes dropDown
 {
    0%{left:0%}
    100%{top:35%}
 }
 #id1{
   position:absolute;
   left:50%;  
   top:0%;
    animation-name: dropDown;
   transform:translateX(-50%);
   animation:dropDown 3s forwards;
 }
 .c1{
    background:radial-gradient(ellipse,rgb(175, 155, 117),rgb(150, 150, 92),rgb(83, 83, 131),rgb(98, 155, 98))
 }
 input{
    border:none;
    outline:none;
    background-color: transparent;
    border-bottom: 2px solid black;
    color:rgb(63, 35, 35);
    height: 20px;
    font-size: 16px;
 }
.c2 input[type=submit],input[type=reset]
{
    background-color:transparent;
    border:none;
    outline:none;
    border-bottom:1px solid black;
    border-radius:25px;
}
.c2 input[type=submit]:hover{
    background-color: blueviolet;
    size:25px;
}
.c2 input[type=reset]:hover{
    background-color: blueviolet;
    size:25px;
}
td{
padding-left:4px;
padding-right:4px;
}

</style>
</head>
<body class="c1">
  <h1 style="text-align:center;">Edit employee Details</h1>

  <hr color=1px solid black>
  <div id="id1">
  <f:form modelAttribute="emp" class="c2">
  <table align="center">
  <tr><td>EmpNumber::</td><td><f:input path="empno" readonly="true"/></td></tr>
  <tr><td>EmpName::</td><td><f:input path="ename"/></td></tr>
  <tr><td>Job::</td><td><f:input path="job"/></td></tr>
  <tr><td>Sal::</td><td><f:input path="sal"/></td></tr>
  <tr><td>deptNumber::</td><td><f:input path="deptno"/></td></tr>
  <tr><td>status::</td><td><f:input path="status" readonly="true"/></td></tr>
  <tr><td><input type="submit" value="save"/></td><td><input type="reset" value="reset"/></td>
    </table>
  </f:form>
  </div>
</body>
</html>