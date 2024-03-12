<%@ page isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>


<h1 style="color: green; text-align: center;">Customer Info</h1>
<f:form modelAttribute="customer">
	<table align="center">
		<tr>
			<td>custNumber::</td>
			<td><f:input path="cno" /></td>
		</tr>
		<tr>
			<td>custName::</td>
			<td><f:input path="custName" /></td>
		</tr>
		<tr>
			<td>country::</td>
			<td><f:select path="country">
					<f:options items="${countries }" />
				</f:select></td>
		</tr>
		<tr>
			<td>Languages Known</td>

			<td><f:select path="languagesKnown" multiple="multiple" size="5">
					<f:options items="${languages }" />
				</f:select></td>
		</tr>
		</tr>
		<tr>
			<td>select hobbies::</td>
			<td><f:checkboxes items="${hobbiesInfo}" path="hobbies"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="submit" /></td>
			<td><input type="reset" value="cancel" /></td>
	</table>
</f:form>
