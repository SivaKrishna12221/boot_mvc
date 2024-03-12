<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Student report</title>
</head>
<body>
	<h1 style="text-align: center; color: green">Student Report</h1>
	<c:choose>
		<%-- <c:when test="${!empty stud_data }">
		 --%>
		<c:when test="${!empty pageData}">
			<table align="center">
				<tr>
					<th>StudentId</th>
					<th>Name</th>
					<th>course</th>
					<th>age</th>
					<th>mobile number</th>
					<th>fees</th>
					<th>dof</th>
					<th>validataion</th>
					<th>edit</th>
					<th>delete</th>
				</tr>

				<c:forEach var="stud" items="${pageData.getContent() }">
					<tr>
						<td>${stud.studentId}</td>
						<td>${stud.name }</td>
						<td>${stud.course }</td>
						<td>${stud.age }</td>
						<td>${stud.mobile }</td>
						<td>${stud.fees }</td>
						<td>${stud.dof}</td>
						<td>${stud.validateFlag }
						<td><%-- <a href="edit_student?studentId=${stud.studentId }">edit</a> --%>Edit</td>
						<td><a href="delete_student?studentId=${stud.studentId }"
							onclick="return confirm('do you want to delete')">delete</a></td>
					</tr>
				</c:forEach>
			</table>
			<p style="text-align: center">

				<c:if test="${!pageData.isFirst() }">
					<a href="student_report?page=0">[first]</a>&nbsp;&nbsp;
			</c:if>
				<br>

				<c:if test="${!pageData.isLast() }">
					<a href="student_report?page=${pageData.getNumber()+1}">[next]</a>&nbsp;
			</c:if>

				<%-- <C:forEach var="i" begin="2" end="${pageData.getTotalPages()}" step="1">
			[ <a href="student_report?page=${i-1}">${i}</a>]&nbsp;&nbsp;
			</C:forEach> --%>
				<br>
				<c:if test="${!pageData.isLast() }">
					<a href="student_report?page=${pageData.getTotalPages()-1 }">[Last]</a>&nbsp;&nbsp;
			</c:if>
				<c:if test="${!pageData.isFirst() }">
					<a href="student_report?page=${pageData.getNumber()-1 }">[previous]</a>&nbsp;&nbsp;
			   </c:if>
			</p>
			<br>
			<blink>
				<h3 Style="text-align: center; color: green;">${message }</h3>
			</blink>
			<br>
			<h3 style="text-align: center;">
				<a href="add_student">Click here</a> to add a new student
			</h3>

		</c:when>
		<c:otherwise>
			<h1 style="text-align: center; color: red">Data not found</h1>
		</c:otherwise>
	</c:choose>
	<h1><a href="./">Home</a></h1>
</body>
</html>