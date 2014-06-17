<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<c:set var="eventCounter" value="0" scope="page" />

<div class="container" id="eventGrid">

    <div class="row">
        <div class="col-lg-4">
            <p></p>
        </div>
        <div class="col-lg-4">
            <input type="text" class="form-control" id="eventNumber" >
            <a class="btn btn-xs btn-success" onclick="goSearchEventGrid()">Find Event</a>
            <a class="btn btn-xs btn-info" onclick="resetEventSearch()">Clear Search</a>
        </div>
     </div>


    <div class="col-lg-12" align="center">
        <c:forEach items="${eventModel}" var="event" varStatus="counter">
            <c:set var="eventCounter" value="${eventCounter + 1}" scope="page" />
        </c:forEach>
        <span class="badge pull-right">Active Events: ${eventCounter}</span>
        <table
            class="table table-hover table-striped table-bordered table-condensed">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Status</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:forEach items="${eventModel}" var="event" varStatus="counter">
                        <tr>
                            <td>${event.id}</td>
                            <td>${event.title}</td>
                            <td>${event.eventStatus}</td>
                            <td>${event.description}</td>
                        </tr>
                    </c:forEach>
                </tr>
            </tbody>
        </table>
    </div>
</div>

