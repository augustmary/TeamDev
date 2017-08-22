<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Title</title>
    <jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<!-- NAVBAR -->
<jsp:include page="/WEB-INF/views/common/navbar.jsp"/>

 <div class="container">

     <c:choose>
         <c:when test="${pageContext.request.userPrincipal.name != null}">
             <form id="logoutForm" method="POST" action="${contextPath}/login?logout">
                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
             </form>

             <h2>Welcome to TeamDev, ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
             </h2>
            <h3>Go to <a href="/tasks"> Tasks </a> </h3>
         </c:when>
         <c:otherwise>
             <form id="loginForm" method="GET" action="${contextPath}/login">
                <h2> Please, log in! | <a onclick="document.forms['loginForm'].submit()">Log in</a>
                </h2>
             </form>
         </c:otherwise>
     </c:choose>


 </div>
</body>
</html>
