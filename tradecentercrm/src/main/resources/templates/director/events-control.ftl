<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">


    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/animate.css">
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900|Montserrat:400,700' rel='stylesheet' type='text/css'>


    <link rel="stylesheet" href="css/bootstrap.min.css">

    <script src="js/modernizr-2.7.1.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/main.js"></script>
    <link rel="stylesheet" href="css/main.css">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
    <script src="js/wow.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</head>
<body>
<div class="container">
    <h1><b>All events:</b></h1>
    <br>
    <a href="/director/new-event"><button class="btn-default btn-warning">New event</button></a>
<#list model.events as event>
    <div>
        <a href="/event/${event.id}">${event.title}</a>
        <br>
        <br>
        <a href="/director/event/${event.id}/edit"><button class="btn btn-warning">Edit</button></a>
        <a href="/director/event/${event.id}/delete"><button class="btn btn-danger">Delete</button></a>
    </div>
    -----------------------------------------------------------------
</#list>
</div>
</body>
</html>