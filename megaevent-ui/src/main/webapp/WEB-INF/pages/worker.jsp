<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
  
  <head>
    <title>Worker Workbench</title>
    <meta name="viewport" content="width=device-width">
   	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-1.10.2.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<link rel="icon" type="image/png" href="<c:url value="/resources/images/favicon.ico"/>"></link>
	
    <style type="text/css">
      body {
        padding-top: 20px;
      }
      .footer {
        border-top: 1px solid #eee;
        margin-top: 40px;
        padding-top: 40px;
        padding-bottom: 40px;
      }
      /* Main marketing message and sign up button */
      .jumbotron {
        text-align: center;
        background-color: transparent;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }
      /* Customize the nav-justified links to be fill the entire space of the .navbar */
      .nav-justified {
        background-color: #eee;
        border-radius: 5px;
        border: 1px solid #ccc;
      }
      .nav-justified > li > a {
        padding-top: 15px;
        padding-bottom: 15px;
        color: #777;
        font-weight: bold;
        text-align: center;
        border-bottom: 1px solid #d5d5d5;
        background-color: #e5e5e5;
        /* Old browsers */
        background-repeat: repeat-x;
        /* Repeat the gradient */
        background-image: -moz-linear-gradient(top, #f5f5f5 0%, #e5e5e5 100%);
        /* FF3.6+ */
        background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f5f5f5), color-stop(100%, #e5e5e5));
        /* Chrome,Safari4+ */
        background-image: -webkit-linear-gradient(top, #f5f5f5 0%, #e5e5e5 100%);
        /* Chrome 10+,Safari 5.1+ */
        background-image: -ms-linear-gradient(top, #f5f5f5 0%, #e5e5e5 100%);
        /* IE10+ */
        background-image: -o-linear-gradient(top, #f5f5f5 0%, #e5e5e5 100%);
        /* Opera 11.10+ */
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#f5f5f5', endColorstr='#e5e5e5', GradientType=0);
        /* IE6-9 */
        background-image: linear-gradient(top, #f5f5f5 0%, #e5e5e5 100%);
        /* W3C */
      }
      .nav-justified > .active > a, .nav-justified > .active > a:hover, .nav-justified > .active > a:focus {
        background-color: #ddd;
        background-image: none;
        box-shadow: inset 0 3px 7px rgba(0, 0, 0, .15);
      }
      .nav-justified > li:first-child > a {
        border-radius: 5px 5px 0 0;
      }
      .nav-justified > li:last-child > a {
        border-bottom: 0;
        border-radius: 0 0 5px 5px;
      }
      @media(min-width: 768px) {
        .nav-justified {
          max-height: 52px;
        }
        .nav-justified > li > a {
          border-left: 1px solid #fff;
          border-right: 1px solid #d5d5d5;
        }
        .nav-justified > li:first-child > a {
          border-left: 0;
          border-radius: 5px 0 0 5px;
        }
        .nav-justified > li:last-child > a {
          border-radius: 0 5px 5px 0;
          border-right: 0;
        }
      }
      /* Responsive: Portrait tablets and up */
      @media screen and(min-width: 768px) {
        /* Remove the padding we set earlier */
        .masthead, .marketing, .footer {
          padding-left: 0;
          padding-right: 0;
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
      <div class="masthead">
        <h3 class="text-muted">Worker Workbench</h3>
        <ul class="nav nav-justified">
          <li>
            <a href="home">Home</a>
          </li>
          <li>
            <a>My Events</a>
          </li>
          <li>
            <a>My Tasks</a>
          </li>
        </ul>
      </div>
      <!-- Jumbotron -->
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
          <p></p>
        </div>
        <div class="col-lg-4">
          <div class="drag-mask" data-ds-form="text_field" style="width: 720px; height: 34px;"></div>
        </div>
      </div>
      <!-- Site footer -->
    </div>
    <!-- /container -->
  </body>

</html>