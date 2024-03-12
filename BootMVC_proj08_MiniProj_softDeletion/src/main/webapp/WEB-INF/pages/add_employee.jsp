<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new Employee</title>
<style>
 body{
        background:radial-gradient(circle,rgb(100, 172, 100),rgb(168, 124, 179),rgb(203, 163, 88));
    }
 input{
 border:none;
 border-bottom:2px solid black ;
 background:transparent;
 outline:none;
 height:20px;
 color:rgb(124, 69, 69);
 font-size:14px;
   }
  
  #id1{
    position: absolute;
    top: 0%;
    left: 50%;
    transform: translateX(-50%);
    animation: dropDown 3s forwards;
    align:center;
}
 @keyframes dropDown {
    0% { top: 0; }
    100% { top: 35%; }
}
.c1 input[type="submit"]
{
  border:none;
  outline:none;
  height:40px;
  background-color: rgb(99, 99, 154);
  border-radius:20px;
}
.c1  input[type="reset"]
    {
  border:none;
  outline:none;
  height:40px;
  background-color:  rgb(99, 99, 154);
  border-radius:20px;
}

 .c1 input[type="submit"]:hover
{
   cursor:pointer ;
   background:rgb(117, 130, 159);
  color:rgb(150,99,154);
}
.c1 input[type="reset"]:hover
{
    cursor:pointer ;
   background:rgb(117, 130, 159);
   color:rgb(150,99,154);
}
td{
  padding-left:2px;
  padding-right:2px;
}
</style>
</head>
<body>
 <h1 align="center">Add new Employee</h1>
 <div id="id1">
 <f:form modelAttribute="emp">
 <table align="center">
 <tr><td>Empno::</td><td><f:input path="empno"/></td></tr>
 <tr><td>Name::</td><td><f:input path="ename"/></td></tr>
 <tr><td>Job::</td><td><f:input path="job"/></td></tr>
 <tr><td>Sal::</td><td><f:input path="sal"/></td></tr>
 <tr><td>deptno::</td><td><f:input path="deptno"/></td></tr>
 <tr><td><input type="submit" value="Add"/></td><td><input type="reset" value="reset"/></td></tr>
 </div>
 </table>
 </f:form>
 </div>
</body>
</html>