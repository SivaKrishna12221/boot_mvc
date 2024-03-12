<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h1 style="color:green;"><spring:message code="syr.reg.title"/></h1>
<f:form modelAttribute="investor">
<table align="center">
 <tr><td><spring:message code="syr.reg.name"/></td><f:input path="name"/><td></td></tr>
  <tr><td><spring:message code="syr.reg.address"/></td><f:input path="address"/><td></td></tr>
  <tr><td><spring:message code="syr.reg.contact"/></td><f:input path="contact"/><td></td></tr>
  <tr><td><spring:message code="syr.reg.requirement"/></td><f:input path="requirement"/><td></td></tr>
  <tr><td><spring:message code="syr.reg.budget"/></td><td><f:input path="budget"/></td></tr>
 <tr><td><input type="button" value="save"></td><td><input type="reset" value="reset"/></td></tr>
</table>

<p style="text-align:center">
 <jsp:useBean id="dt" class="java.util.Date"></jsp:useBean>
 <fmt:formatDate value="${dt }" var="fdt" type="date" dateStyle="FULL"/>
 system date::${fdt }<br>
 <fmt:formatDate value="${dt }" var="ft" type="time" timeStyle="FULL"/>
 system time::${ft }<br>
 <fmt:formatNumber value="23424024" var="num" type="number"/>
 Number::${num }
 <fmt:formatNumber value="23235252" var="amt" type="currency"/>
 price::${amt }
</p>
</f:form>
<p style="text-align:center">
<a href="?lang=te_IN">Telugu</a>&nbsp;&nbsp;
<a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;
<a href="?lang=de_DE">German</a>&nbsp;&nbsp;
<a href="?lang=zh_CN">Chineese</a>&nbsp;&nbsp;
<a href="?lang=fr_FR">French</a>&nbsp;&nbsp;
<a href="?lang=en_US">English</a>&nbsp;&nbsp;
</p>