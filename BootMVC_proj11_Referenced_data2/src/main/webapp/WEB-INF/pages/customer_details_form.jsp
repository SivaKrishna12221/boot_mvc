<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<h1 style="color: green; text-align: center;">
	Customer Info</h1>
	<f:form modelAttribute="cust">
		<table align="center">
			<tr>
				<td>cust number</td>
				<td><f:input path="custno" /></td>
			</tr>
			<tr>
				<td>customer name</td>
				<td><f:input path="custName" /></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><f:select path="country">
						<f:options items="${countries }" />
						<f:option value="Jangampalli">Jangampalli</f:option>
					</f:select></td>
			</tr>
			<tr>
				<td>languages Known</td>
				<td><f:select path="languagesKnown" multiple="multiple" size="5">
						<f:options items="${languagesKnown }" />
						<f:option value="telugu">Telugu</f:option>
					</f:select>
			<tr>
			<tr>
			 <td>Items purchased</td>
			 <td>
			    <f:checkboxes items="${things }" path="things"/>
			</tr>
				<td><input type="submit" value="submit" /></td>
				<td><input type="reset" value="cancel" /></td>
			</tr>
		</table>
	</f:form>

