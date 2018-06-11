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
    <div>
        <div class="col-lg-offset-4 col-lg-3">
            <a href="/"><img src="img/logo.svg" alt="SNOW Trade Center"></a>
        </div>
    </div>
    <br>
    <div>
        <a href="/logout"><button class="btn-lg btn-success">Logout</button></a>
    </div>
        <br>
    <#if model.me == false>
        <div class="container">
            <h1>${model.user.firstName} ${model.user.secondName} aka ${model.userLoginData.username}</h1>
        </div>
    </#if>
    <#if model.me == true>
    <div class="container">
        <h1>Welcome, ${model.user.firstName} ${model.user.secondName} aka ${model.userLoginData.username}</h1>
    </div>
    </#if>
    <div class="container">
        <h3>Contact me: ${model.user.contact}</h3>
    </div>
    <div>
        <h2 style="color: #8c8c8c">Reviews: </h2>
    <#if model.me == true>
        <a href="/user/${model.user.id}/add-review"><button class="btn-lg btn-success">Add new review</button> </a>
    </#if>
        <br>
        <#list model.user.reviews as review>
            <div class="panel">
                <div class="panel-heading">
                  <div class="pull-left">
                     <a href="/user/${model.user.id}">${review.author.firstName} ${review.author.secondName}</a>
                  </div>
                </div>
                <div class="panel-body">
                    <a href="/review/${review.id}">${review.content}</a>
                </div>
            </div>
            <br>
        </#list>
        <#if model.me == true>
        <h2 style="color: #8c8c8c">Sent tickets:</h2>
        ------------------------------------------------------------------------
        <p><a href="/user/${model.user.id}/new-ticket"><button class="btn btn-lg btn-default">Send new ticket</button></a></p>
        <#list model.user.ticketsSent as ticket>
        <div class="panel">
            <div class="panel-heading">
                <div class="pull-left">
                    <p>${ticket.date}</p>
                </div>
                <div>
                    <a href="/user/${ticket.receiver.id}">${ticket.receiver.firstName} ${ticket.receiver.secondName}</a>
                </div>
                <div class="pull-right">
                    <p>${ticket.status}</p>
                </div>
            </div>
            <div class="panel-body">
                <a href="/ticket/${ticket.id}">${ticket.title}</a>
                <br>
                <p>${ticket.content}</p>
                <p  style="color: #8c8c8c">Answer:</p>
                <p>${ticket.answer}</p>
            </div>
            ---------------------------------------------------------
        </div>
        </#list>
        <br>
        <h2 style="color: #8c8c8c">Received tickets:</h2>
        ----------------------------------------------------------------------
        <#list model.user.ticketsReceived as ticket>
        <div class="panel">
            <div class="panel-heading">
                <div class="pull-left">
                    <p>${ticket.date}</p>
                </div>
                <div>
                    <a href="/user/${ticket.sender.id}">${ticket.sender.firstName} ${ticket.sender.secondName}</a>
                </div>
                <div class="pull-right">
                    <p>${ticket.status}</p>
                </div>
            </div>
            <div class="panel-body">
                <a href="/ticket/${ticket.id}">${ticket.title}</a>
                <p>${ticket.content}</p>
                <p style="color: #8c8c8c">Answer:</p>
                <p>${ticket.answer}</p>
            </div>
            ---------------------------------------------------------------
        </div>
        </#list>
        </#if>
    </div>
</body>
</html>