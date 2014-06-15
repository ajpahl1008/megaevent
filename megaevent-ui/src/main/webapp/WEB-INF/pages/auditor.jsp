<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<c:set var="refreshInterval" value="5000" scope="page" />
<c:set var="eventCounter" value="0" scope="page" />
<c:set var="taskCounter" value="0" scope="page" />


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>MegaEvent - Auditor</title>
<meta name="viewport" content="width=device-width">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/megaevent.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-1.10.2.min.map" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/megaevent.js" />"></script>
<link rel="icon" type="image/png" href="<c:url value="/resources/images/favicon.ico"/>">

<script type="text/javascript">
	var intervalId = 0;
	intervalId = setInterval(refreshEventGrid, ${refreshInterval});
</script>

</head>
<body>
	<div class="container">
	<div class="header">
        <ul class="nav nav-pills pull-right">
          <li class="active">
            <a href="home">Home</a>
          </li>
          <li>
            <a href="#">About</a>
          </li>
          <li>
            <a href="#">Support</a>
          </li>
        </ul>
        <h3 class="text-muted">MegaEvent</h3>
      </div>
		<div class="masthead">
			<h3 class="text-muted">Auditor Workbench</h3>
			<ul class="nav nav-justified">
				<li><a href="events">Events</a></li>
				<li><a href="tasks">Tasks</a></li>
				<li><a href="changes">Change Controls</a></li>
			</ul>
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

		</div>

		<div class="footer">
    		<div class="container" id="eventGrid">


				<div class="col-lg-12" align="center">
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
					<tbody></tbody>
				</table>
					<p class="text"><strong>Loading...</strong></p>
					<img src="<c:url value="/resources/images/ajax-loader.gif"/>" title="Loading" />
				</div>
			</div>
		</div>
	</div>


</body>
</html>