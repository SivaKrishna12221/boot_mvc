<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${!empty pageData }">
		<h1 style="text-align: center; color: green;">Doctors Report</h1>
		<table align="center">
			<tr>
				<th>DoctorId</th>
				<th>DoctorName</th>
				<th>specialization</th>
				<th>income</th>
			</tr>
			<c:forEach var="info" items="${pageData.getContent() }">
				<tr>
					<td>${info.getDoctorId() }</td>
					<td>${info.getDoctorName() }</td>
					<td>${info.getSpecialization() }</td>
					<td>${info.getIncome()}</td>
				</tr>
			</c:forEach>
		</table>
		<p style="text-align:center">
		<c:forEach var="i" begin="1" end="${pageData.getTotalPages()-1 }" step="1" >
		[<a href="doctor_report?page=${i }">${i+1}</a>]&nbsp;&nbsp;
		</c:forEach>
		</p>
		<p style="text-align:center">
		<%-- <c:if test="${!pageData.isFirst() }"><!--if page number is not first condition true display hiperlink-->
		   [<a href="doctor_report?page=${pageData.getNumber()-1 }">previous</a>]&nbsp;&nbsp;&nbsp;&nbsp;
		</c:if>
		<c:if test="${!pageData.isLast() }"> <!-- if it page is page present in last page it wont display the next hyperlink-->
		   [<a href="doctor_report?page=${pageData.getNumber()+1 }">Next</a>]
		</c:if> --%>
		<c:if test="${!pageData.isFirst() }">
		 [<a href="doctor_report?page=${pageData.getNumber()-1 }">previous</a>]&nbsp;&nbsp;&nbsp;&nbsp;
		</c:if>
		<c:if test="${!pageData.isLast() }">
		[<a href="doctor_report?page=${pageData.getNumber()+1 }">next</a>]
		</c:if>
		</p>
		
		
		
	</c:when>
	<c:otherwise>
		<h1 style="text-align: center; color: red;">Data Not Found</h1>
	</c:otherwise>
</c:choose>