<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<h2 style="color: green; text-align: center;">List Of profiles</h2>
<c:choose>
	<c:when test="${!empty pageData }">
		<table align="center">
			<tr>
				<th>profileId</th>
				<th>name</th>
				<th>gender</th>
				<th>photopath</th>
				<th>resumepath</th>
			</tr>
			<c:forEach var="profile" items="${pageData.getContent() }">
				<tr>
					<td>${profile.profileId }</td>
					<td>${profile.name }</td>
					<td>${profile.gender }</td>
					<td><a href="download_info?file=${profile.photo }">${fn:substringAfter(profile.photo,'D:mvc_download_practice/job seekar/')}</a></td>
					<td><a href="download_info?file=${profile.resume }">${fn:substringAfter(profile.resume,'D:mvc_download_practice/job seekar/')}</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p style="color: red; text-align: center">Profiles not found!</p>
	</c:otherwise>
</c:choose>
