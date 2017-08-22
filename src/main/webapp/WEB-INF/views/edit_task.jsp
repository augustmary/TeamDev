<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add task</title>
    <jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/navbar.jsp"/>
<div id = "wrapper">
    <div id="page-wrapper" style = "margin-left: 200px">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Editing task</h1>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <!-- Basic Form Elements -->
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="/update_task" method="post">
                                        <input type="hidden" name="id" value="${task.id}">
                                        <div class="form-group">
                                            <label>Title</label>
                                            <input name="title" class="form-control" value=${task.title}>
                                           </div>
                                        <div class="form-group">
                                            <label>Description</label>
                                            <textarea name = "content" class="form-control" rows="3" name = "content">
                                             ${task.content}
                                            </textarea>
                                        </div>
                                        <button type="submit" class="btn btn-default">Edit task</button>
                                        <button type="reset" class="btn btn-default">Reset</button>
                                    </form>
                                    <button type="button" class="btn btn-default"  href="tasks">Cancel</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
