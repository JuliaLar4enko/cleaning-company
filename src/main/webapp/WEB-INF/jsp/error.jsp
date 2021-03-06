<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="local" var="loc"/>
<fmt:message bundle="${loc}" key="local.error.page.title.500" var="title"/>
<fmt:message bundle="${loc}" key="local.error.page.message.500" var="message"/>
<fmt:message bundle="${loc}" key="local.error.page.little.message.500" var="littleMessage"/>

<html>
<body class="container">
<div style="margin-left: 100px; margin-top: 20px">
    <h1 style="color:#CF0B15;" class="text-center"><c:out value="${title}"/></h1>
    <h3 class="text-center"><c:out value="${message}"/></h3>
    <h4 class="text-center"><c:out value="${littleMessage}"/></h4>
</div>
</body>
</html>
