<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">


    <link type="text/css" rel="stylesheet" href="css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="css/animate.css">
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900|Montserrat:400,700' rel='stylesheet' type='text/css'>


    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">

    <script type="text/javascript" src="js/modernizr-2.7.1.js"></script>
    <script type="text/javascript" src="js/wow.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <link type="text/css" rel="stylesheet" href="css/main.css">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
    <script type="text/javascript" src="js/wow.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
</head>
<body class="container">
<h2 style="color: #8c8c8c">All reviews about SNOW Trade center: </h2>
<br>
<a href="/reviews/download"><button class="btn btn-primary">Download list</button></a>
<#list model.reviews as review>
<div class="panel">
    <div class="panel-heading">
        <div class="pull-left">
            <a href="/user/${review.author.id}">${review.author.firstName} ${review.author.secondName}</a>
        </div>
    </div>
    <div class="panel-body">
        <p style="max-lines: 1">${review.content}...</p>
    </div>
    <div>
        <a href="/review/${review.id}"><button class="btn btn-primary">Read more</button> </a>
    </div>
</div>
</#list>
</body>
</html>