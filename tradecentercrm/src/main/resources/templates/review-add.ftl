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
<h2>Add review:</h2>
<br>
<form enctype="multipart/form-data" action="/review/add-successful" class="form-control" method="post" role="form">
    <div class="form-group">
        <textarea style="resize: none; visibility: hidden" title="userId" name="userId" readonly contenteditable="false" class="text-area">${model.userId}</textarea>
    </div>
    <div class="form-group">
        <label for="file">Upload image</label>
        <input accept="image/png,image/jpeg" id="file" type="file" name="file">
    </div>
    <div class="form-group">
        <textarea style="width: 500px; height: 300px; resize: none" title="content" contenteditable="true" class="text-area" name="content" placeholder="Enter review text"></textarea>
    </div>
    <div class="form-group">
        <button class="btn-lg btn-success" type="submit">Add</button>
    </div>
</form>
</body>
</html>