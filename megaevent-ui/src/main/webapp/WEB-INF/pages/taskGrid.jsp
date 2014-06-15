<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<c:set var="taskCounter" value="0" scope="page" />

    <div class="row">
        <div class="col-lg-4">
            <p></p>
        </div>
        <div class="col-lg-4">
            <input type="text" class="form-control" id="taskNumber" >
            <a class="btn btn-xs btn-success" onclick="goSearchTaskGrid()">Find Task</a>
            <a class="btn btn-xs btn-info" onclick="resetTaskSearch()">Clear Search</a>
        </div>
     </div>

<div class="container" id="taskGrid">
    <div class="col-lg-12" align="center">
        <c:forEach items="${taskModel}" var="task" varStatus="counter">
            <c:set var="taskCounter" value="${taskCounter + 1}" scope="page" />
        </c:forEach>
        <span class="badge pull-right">Active Tasks: ${taskCounter}</span>
        <table
            class="table table-hover table-striped table-bordered table-condensed">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Status</th>
                    <th>Result</th>
                    <th>Owner</th>
                    <th>Activator</th>
                    <th>Validator</th>
                    <th>Role</th>
                    <th><abbr title="There's an explanation here">Task Name</abbr></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:forEach items="${taskModel}" var="task" varStatus="counter">
                        <tr>
                            <td>${task.id}</td>
                            <td>${task.title}</td>
                            <td>${task.eventStatus}</td>
                            <td>${task.description}</td>
                        </tr>
                    </c:forEach>
                </tr>
            </tbody>
        </table>
    </div>
</div>