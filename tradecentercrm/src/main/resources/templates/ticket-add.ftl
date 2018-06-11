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
<body>
<div class="container">
<h2>Add ticket:</h2>
<br>
<form action="/user/${model.user.id}/new-ticket" method="post" role="form">
    <div class="form-group">
        <input class="form-control" style="visibility: hidden; height: 0; width: 0" name="sender" value="${model.username}" type="text">
    </div>
    <div class="form-group">
        <input class="form-control" name="receiver" type="text" placeholder="Type receiver username here">
    </div>
    <div class="form-group">
        <input class="form-control" name="title" type="text" placeholder="Type ticket's title here">
    </div>
    <div class="form-group">
        <textarea style="width: 500px; height: 300px; resize: none" title="content" contenteditable="true" class="text-area" name="content" placeholder="Enter ticket text here"></textarea>
    </div>
    <div>
        <button class="btn-lg btn-success" type="submit">Send</button>
    </div>
</form>
</div>
</body>
</html>