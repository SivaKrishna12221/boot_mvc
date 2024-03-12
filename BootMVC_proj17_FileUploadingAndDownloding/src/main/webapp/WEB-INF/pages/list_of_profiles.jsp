<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:choose>
	<c:when test="${!empty profiles}">
		<table align="center">
			<tr>
				<th>name</th>
				<th>gender</th>
				<th>biodata</th>
				<th>photo</th>
			</tr>
			<c:forEach var="data" items="${profiles.getContent()}">
				<tr>
					<td>${data.name }</td>
					<td>${data.gender }</td>
					<td><a href="download_info?file=${data.resumePath }">${fn:substringAfter(data.resumePath,'D:mvc_download_practice/')}</a></td>
					<td><a href="download_info?file=${data.photoPath }">${fn:substringAfter(data.photoPath,'D:mvc_download_practice/')}</a></td>
					
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="text-align: center; color: green">Profiles are not
			found</h1>
	</c:otherwise>
</c:choose>