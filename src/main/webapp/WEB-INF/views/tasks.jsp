<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>TeamDev</title>
    <jsp:include page="/WEB-INF/views/common/head.jsp"/>

</head>
<body>
<!-- NAVBAR -->
<jsp:include page="/WEB-INF/views/common/navbar.jsp"/>

<div class="container">
    <h1>Active tasks</h1>
    <a class="btn btn-primary" href="/add_page">New task</a>
    <c:if test="${fn:length(tasks) gt 0}">
        <c:forEach items="${tasks}" var="task">
            <div class="row list-group-item">
                <div class="col-md-1">
                    <h3>${task.crtDate}</h3>
                </div>
                <div class="col-md-1">
                    <h4>${task.id}</h4>
                </div>
                <div class="col-md-1">
                    <h4>${task.author.username}</h4>
                </div>
                <div class="col-md-2">
                    <h4>${task.status.description}</h4>
                </div>
                <div class="col-md-3">
                    <a href="/task_${task.id}">${task.title}</a>
                </div>
            </div>
        </c:forEach>
    </c:if>
    <!-- /.row -->
</div>
<!-- jQuery -->
<script src="WEB-INF/views/common/bootstrap/js/bootstrap.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="WEB-INF/views/common/bootstrap/js/bootstrap.min.js"></script>

<!-- Contact Form JavaScript -->
<!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
<script src="js/jqBootstrapValidation.js"></script>
<script src="js/contact_me.js"></script>
</body>
</html>
