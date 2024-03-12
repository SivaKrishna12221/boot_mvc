<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
  @keyframes change_color
         {
            25%{background-color:rgb(104, 166, 62);
               background-color: rgb(198, 137, 115);}
            50%{background-color: rgb(93, 140, 167);}
            75%{background-color:rgb(188, 116, 173)}
            100%{background-color:rgb(103, 68, 138);
                background-color:rgb(114, 158, 141);
            }
        }
         @keyframes font_color {
            25%{color:rgb(25, 63, 104)}
            50%{color:#5b7f36}
            75%{color:rgb(26, 18, 118)}
            100%{color:darksalmon}
        }
       .c1{
        animation-name: change_color;
        animation-duration: 20s;
        animation-iteration-count:infinite;
       }
        #id1{
       text-align: center;
       animation:font_color ;
       animation-duration: 10s;
       animation-iteration-count: infinite;
     }
     th{
        border-bottom:2px solid black;
         padding-left:2ch;
        padding-right:2ch;
    }
    td{
        text-align: center;     
    }
     
 </style>
</head>
<body class="c1">
	<h1 id="id1">Employee Details</h1>
	<hr>
	<br>
	<c:choose>
		<c:when test="${!empty emps }">
			
		<%--  <c:when test="$!empty pageData">
		 --%>
		  <Table align="center">
				<tr>
					<th>Emp Number</th>
					<th>Emp Name</th>
					<th>Job</th>
					<th>Salary</th>
					<th>DeptNo</th>
					<th>Status</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="emp" items="${ emps}">
					<tr>
						<td>${ emp.empno}</td>
						<td>${ emp.ename}</td>
						<td>${ emp.job}</td>
						<td>${emp.sal}</td>
						<td>${ emp.deptno}</td>
						<td>${emp.status}</td>
						<td><a href="edit_emp?empno=${emp.empno}"><img src="edit icon.png" onclick="return confirm('do you want to edit')" width="25px" height="25px"></a></td>
						<td><a href="delete_emp?empno=${emp.empno}" onclick="return confirm('do you want to delete ')"><img src="delete icon.png" width="25px" height="25px"></a></td>
					</tr>
				</c:forEach>
				
				
			</Table>
			<%-- <p style="text-align:center;">
			[ <c:forEach var="i" begin="2" end="${pageData.getTotalPages() }" step="1">
			<a href="employeeInfo?page=${i-1 }">${i}</a>]&nbsp;&nbsp;
			</c:forEach>
			</p> --%>
			<blink></blink><h1 style="color:green;text-align:center">${message }</h1>
		</c:when>
		<c:otherwise>
			<h1 id="id1">Employee Details are not found</h1>
		</c:otherwise>
	</c:choose>
	<h1 id="id1">Add New Employee<a href="addEmp"><img src="add emp.png" height=100px width=100px></a></h1>
     <h2 id="id1"><a href="./"><img src="home page.png" width=100px height=100px></a></h2>
</body>
</html>