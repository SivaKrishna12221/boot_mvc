<%@ page isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<h1 style="color: green; text-align: center;">Student form</h1>

<f:form  action="register" name="studform" modelAttribute="sinfo">
	<table align="center">
		<tr>
			<td>sno::</td>
			<td><f:input path="sno" /></td>
		</tr>
		<tr>
			<td>sname::</td>
			<td><f:input path="sname" /></td>
		</tr>
		
		<tr>
			<td>country::</td>
			<td>
			<f:select path="country" onchange="getListOfStates(this)">
			<f:options items="${countries}"/>
			</f:select>
			
		</tr>
		
		<tr>
			<td>state::</td>
			<td><f:select path="state" onchange="getListOfDistricts(this)">
			<f:options items="${states}"/>
			</f:select>
		</tr>
		<tr>
			<td>district::</td>
			<td><f:select path="district" onchange="getListOfVillages(this)">
			<f:options items="${districts }"/>
			</f:select></td>
		</tr>
		<tr>
			<td>mandal::</td>
			<td><f:select path="mandal"><f:options items="${mandals }"/></f:select></td>
		</tr>
		<tr>
			<td><input type="submit" value="save" /></td>
			<td><input type="reset" value="cancel" /></td>
		</tr>
	</table>
</f:form>
<script language="JavaScript">
		 function getListOfStates()
		 {
			studform.action="states";
		studform.submit();
			
		 }
		 function getListOfDistricts()
		 {
			 studform.action="districts";
			 studform.submit();
		 }
		 function getListOfMondals()
		 {
		  studform.action="mandals";
		  studform.submit();
		 }
		 
		</script>
