<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<table border="0" width="100%" height="100%" rows="3" columns="3">
	<tr height="25%" bgcolor="green">
		<td colspan="3"><tiles:insertAttribute name="header" /></td>
	</tr>
	<tr height="65%">
		<td width="20%" bgcolor="green"><tiles:insertAttribute name="menu"/></td>
		<td width="60%"><tiles:insertAttribute name="body"/></td>
		<td width="20%" bgcolor="orange"><tiles:insertAttribute name="advertisement"/>
		<td>
	</tr>
	<tr height="10%">
		<td text-align="center"><tiles:insertAttribute name="footer" /></td>
	</tr>
</table>