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
<body class="container">
<h2 style="color: #8c8c8c">New employee:</h2>
<br>
<form class="form-control" action="/director/new-employee" method="post">
    <div class="form-group">
        <input name="fullName" type="text" placeholder="Enter user's full name here">
    </div>
    <br>
    <div class="form-group">
        <textarea name="review" placeholder="Enter review here"></textarea>
    </div>
    <br>
    <div class="form-group">
        <input name="salary" type="text" placeholder="Enter salary here">
    </div>
    <br>
    <div class="form-group">
        <button type="submit" class="btn-default">Add</button>
    </div>
</form>
</body>
</html>