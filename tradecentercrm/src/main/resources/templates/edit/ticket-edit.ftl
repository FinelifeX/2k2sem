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
<h2 style="color: #8c8c8c">Ticket:</h2>
<br>
<form class="form-control" action="/admin/ticket/${model.ticket.id}/edit" method="post">
    <div class="form-group">
        <input type="text" name="title" required width="300px" placeholder="${model.ticket.title}">
    </div>
    <div class="form-group">
        <label for="content-old">Ticket text:</label>
        <br>
        <textarea id="content-old" class="text-area" style="resize: none; width: 300px; height: 150px" disabled>${model.ticket.content}</textarea>
    </div>
    <div class="form-group">
        <label for="content">Enter edited text here:</label>
        <br>
        <textarea id="content" required class="text-area" style="resize: none; width: 300px; height: 150px;" name="content"></textarea>
    </div>
    <div class="form-group">
        <label for="answer-old">Ticket's answer:</label>
        <br>
        <textarea id="answer-old" class="text-area" style="resize: none; width: 300px; height: 150px;" disabled>${model.ticket.answer}</textarea>
    </div>
    <div class="form-group">
        <label for="answer">Enter edited answer text here:</label>
        <br>
        <textarea id="answer" required class="text-area" style="resize: none; width: 300px; height: 150px;" name="answer"></textarea>
    </div>
    <div class="form-group">
        <input type="text" name="status" required placeholder="${model.ticket.status}">
    </div>
    <br>
    <div class="form-group">
        <button type="submit" class="btn-default btn-success">Save</button>
    </div>
</form>
</body>
</html>