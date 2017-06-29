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
            <h1 class="page-header">Creating new task</h1>
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
                                <form role="form" action="/add_task" method="post">
                                    <div class="form-group">
                                        <label>Title</label>
                                        <input name="title" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <textarea name = "content" class="form-control" rows="3"></textarea>
                                    </div>
                                    <button type="submit" class="btn btn-default">Add task</button>
                                    <button type="reset" class="btn btn-default">Cancel</button>
                                </form>
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
