<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h1 style="color:green;text-align:center;"><spring:message code="syr.reg.title"/></h1>

 <table align="center">
<f:form modelAttribute="syr">
<tr><td><spring:message code="syr.reg.name"/></td><td><f:input path="name"/></td></tr>
<tr><td><spring:message code="syr.reg.address"/></td><td><f:input path="address"/></td></tr>
<tr><td><spring:message code="syr.reg.contact"/></td><td><f:input path="contact"/></td></tr>
<tr><td><spring:message code="syr.reg.requirement"/></td><td><f:input path="requirement"/></td></tr>
<tr><td><spring:message code="syr.reg.budget"/></td><td><f:input path="budget"/></td></tr>
<tr><td colspan="2"><input align="center" type="submit" value="submit"/></td></tr>
</f:form>
</table>

<br>
<br>
<p style="text-align:center;">
 
 <jsp:useBean id="dt" class="java.util.Date"/>
 <fmt:setLocale value="${response.locale }"/>
 <fmt:formatDate value="${dt}" var="fdt" type="date" dateStyle="FULL"/>
 system date::${fdt}<br>
 <fmt:formatDate value="${dt}" var="ftime" type="time" timeStyle="FULL"/>
 system time::${ftime }<br>
 <fmt:formatNumber value="90000000" var="fprice" type="currency"/>
  price format::${fprice }<br>
  <fmt:formatNumber value="89080899" var="fnumber" type="number"/>
  number format::${fnumber }
  
</p>
<br><br>
<p style="text-align:center">
<a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;
<a href="?lang=fr_FR">French</a>&nbsp;&nbsp;
<a href="?lang=de_DE">German</a>&nbsp;&nbsp;
<a href="?lang=zh_CN">Chinese</a>&nbsp;&nbsp;
<a href="?lang=te_IN">Telugu</a>&nbsp;&nbsp;
<a href="?lang=en_EN">English</a>&nbsp;&nbsp;

</p>