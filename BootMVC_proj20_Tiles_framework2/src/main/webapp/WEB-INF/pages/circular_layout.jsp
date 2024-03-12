<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<head>
<style>
		table,td{
			border:1x solid rgb(43, 12, 17);
			border-collapse: collapse;  
		}
	</style>
</head>
<table border="1px solid black" width="100%" height="100%" rows="3" columns="3">
	<tr height="20%">
		<td width="20%" ><tiles:insertAttribute name="top-left-adv" /></td>
		<td width="60%"><tiles:insertAttribute name="header"/></td>
		<td width="20%"><tiles:insertAttribute name="top-right-adv"/></td>
	</tr>
	<tr height="70%">
	  <td width="20%"><tiles:insertAttribute name="menu"/></td>
	  <td width="60%" ><tiles:insertAttribute name="body"/></td>
	  <td width="20%"><tiles:insertAttribute name="right-adv"/></td>
	</tr>
	<tr height="10%">
	<td width="20%"><tiles:insertAttribute name="bottom-left-adv"/></td>
	<td width="60%" ><tiles:insertAttribute name="footer"/></td>
	<td width="20%"><tiles:insertAttribute name="bottom-right-adv"/></td>
	</tr>
</table>