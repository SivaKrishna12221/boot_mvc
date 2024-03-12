<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<h1 style="color:orange;text-align:center">Doctor Details</h1>
<c:choose>
 <c:when test="${!empty docsList}">
  <table align="center",bgcolor="cyan">
  <tr><th>DoctorId</th><th>DoctorName</th><th>specialization</th><th>Income</th><th>Edit</th><th>Delete</th></tr>
  <c:forEach var="docs" items="${ docsList}">
  <tr><td>${ docs.doctorId}</td><td>${ docs.doctorName}</td><td>${ docs.specialization}</td><td>${ docs.income}</td><td><a href="edit_doctor_report?doctorId=${docs.doctorId}">edit</a></td><td><a href="delete_doctor_report?doctorId=${docs.doctorId }" onclick="confirm('do you want to delete')">delete</a></td></tr>
  </c:forEach>
  </table>
  <blink><h1 style="color:green;text-align:center">${msg }</h1></blink>
 </c:when>
  <c:otherwise><h1 style="color:orange;text-align:center">Doctors Data Not Found</h1></c:otherwise>
</c:choose>

<br>
<h1 style="text-align:center; color:green;"><a href="add_doctor">Add new Doctor</a></h1>
<br>
<br>
<a href="./">Home</a>
