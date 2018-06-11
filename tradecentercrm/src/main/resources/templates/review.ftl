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
<h2>Review:</h2>
<br>
<form action="/review/${model.review.id}/edit" method="post">
    <#if model.hasImage == true>
        <div class="container">
            <img src="/review/${model.review.id}/image" alt="Review's image" width="300px" height="300px">
        </div>
    </#if>
    <div class="panel">
        <div class="panel-heading">
            <div class="pull-left">
                <a href="/user/${model.review.author.id}">${model.review.author.firstName} ${model.review.author.secondName}</a>
            </div>
        </div>
        <div class="panel-body">
            <textarea readonly class="text-area" name="content" style="width: 500px; height: 300px; resize: none">${model.review.content}</textarea>
        </div>
    <#if model.belongs == true>
        <div>
            <button type="submit" class="btn btn-success">Edit</button>
        </div>
    </#if>
    </div>
</form>
<#if model.belongs == true>
<div>
    <a href="/review/${model.review.id}/delete"><button class="btn btn-danger">Delete</button></a>
</div>
</#if>
</body>
</html>