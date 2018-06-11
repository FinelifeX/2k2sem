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
<form action="/ticket/${model.ticket.id}/edit" method="post">
    <h2>Ticket:</h2>
    <div class="container">
        <p>Title:</p>
        <p>${model.ticket.title}</p>
        <p>Sender:</p>
        <a href="/user/${model.ticket.sender.id}">${model.ticket.sender.firstName} ${model.ticket.sender.secondName} aka ${model.sender}</a>
        <p>Receiver:</p>
        <a href="/user/${model.ticket.receiver.id}">${model.ticket.receiver.firstName} ${model.ticket.receiver.secondName} aka ${model.receiver}</a>
        <p>Text:</p>
        <textarea readonly class="text-area" name="content" style="width: 300px; height: 150px; resize: none">${model.ticket.content}</textarea>
        <p>Answer:</p>
        <textarea readonly class="text-area" name="answer" style="width: 300px; height: 150px; resize: none;">${model.ticket.answer}</textarea>
        <p></p>
    <#if model.isParticipant == true>
        <button type="submit" class="btn-lg btn-success">Edit</button>
    </#if>
    </div>
</form>
</body>
</html>