<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 color="orange">Special types are:</h1>
nicknames:
<br>
<c:forEach var="names" items="${nickNames}">
 ${names} <br>
</c:forEach>
<br>
<b>phone numbers</b>
<c:forEach var="phNumbers" items="${phoneNumbers }">
${phNumbers}<br>
</c:forEach>
<br>
<b>courseInfo:</b>
<c:forEach var="courses" items="${courseList }">
${courses}<br>
</c:forEach>
<b>ids</b>
<c:forEach var="ids" items="${ids}">
${ids.key}==>${ids.value }<br>
</c:forEach>

<table border=2px>
	<tr>
		<th>pid</th>
		<th>pname</th>
		<th>paddress</th>
		<th>phoneNumbers</th>
	<tr>
		<c:forEach var="pdetails" items="${pinfo }">

			<tr>
				<td>${pdetails.getPid() }</td>
				<td>${pdetails.getName() }</td>
				<td>${pdetails.getAddress()}</td>
				<td>${pdetails.getPhNumber() }</td>
			<tr>
		</c:forEach>
</table>
<h3>Passing single model class object</h3>
info:
<br>
${singlePInfo.getPid() }
<br>
${singlePInfo.getName() }
<br>
${singlePInfo.getAddress() }
<br>
${singlePInfo.getPhNumber() }
<br>

