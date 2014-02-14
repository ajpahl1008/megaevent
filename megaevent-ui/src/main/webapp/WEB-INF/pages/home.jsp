<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
  
  <head>
    <title>MegaEvent Workbench</title>
    <meta name="viewport" content="width=device-width">
   <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-1.10.2.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<link rel="icon" type="image/png" href="<c:url value="/resources/images/favicon.ico"/>"></link>
	
    <style type="text/css">
      /* Space out content a bit */
      body {
        padding-top: 20px;
        padding-bottom: 20px;
      }
      /* Everything but the jumbotron gets side spacing for mobile first views */
      .header, .marketing, .footer {
        padding-left: 15px;
        padding-right: 15px;
      }
      /* Custom page header */
      .header {
        border-bottom: 1px solid #e5e5e5;
      }
      /* Make the masthead heading the same height as the navigation */
      .header h3 {
        margin-top: 0;
        margin-bottom: 0;
        line-height: 40px;
        padding-bottom: 19px;
      }
      /* Custom page footer */
      .footer {
        padding-top: 19px;
        color: #777;
        border-top: 1px solid #e5e5e5;
      }
      /* Customize container */
      @media(min-width: 768px) {
        .container {
          max-width: 730px;
        }
      }
      .container-narrow > hr {
        margin: 30px 0;
      }
      /* Main marketing message and sign up button */
      .jumbotron {
        text-align: center;
        border-bottom: 1px solid #e5e5e5;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }
      /* Supporting marketing content */
      .marketing {
        margin: 40px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }
      /* Responsive: Portrait tablets and up */
      @media screen and(min-width: 768px) {
        /* Remove the padding we set earlier */
        .header, .marketing, .footer {
          padding-left: 0;
          padding-right: 0;
        }
        /* Space out the masthead */
        .header {
          margin-bottom: 30px;
        }
        /* Remove the bottom border on the jumbotron for visual effect */
        .jumbotron {
          border-bottom: 0;
        }
      }
    </style>
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
      <div class="jumbotron">
        <p class="lead">Welcome to the MegaEvent planning and execution tool. Please select from one of your available roles.</p>
        <div class="row roles">
          <a class="btn btn-primary btn-lg" href="auditor">Auditor</a>
          <a class="btn btn-primary btn-lg" href="worker">Worker</a>
          <a class="btn btn-primary btn-lg" href="manager">Manager</a>
        </div>
      </div>
      <div class="footer">
        <p>&copy; PahlSoft 2014</p>
      </div>
    </div>
    <!-- /container -->
  </body>

</html>