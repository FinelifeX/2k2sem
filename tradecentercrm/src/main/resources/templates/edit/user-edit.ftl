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
    <h2 style="color: #8c8c8c">User:</h2>
    <br>
    <form class="form-control" action="/admin/user/${model.user.id}/edit" method="post">
        <div class="form-group">
            <input required type="text" name="username" placeholder="${model.userLoginData.username}">
        </div>
        <br>
        <div class="form-group">
            <label for="password">${model.userLoginData.passwordHashed}</label>
            <br>
            <input required id="password" type="text" name="passwordHashed" placeholder="Enter new password">
        </div>
        <br>
        <div class="form-group">
            <input required type="text" name="role" placeholder="${model.userLoginData.role}">
        </div>
        <br>
        <div class="form-group">
            <input required type="text" name="status" placeholder="${model.userLoginData.status}">
        </div>
        <br>
        <div class="form-group">
            <input required type="text" name="fullName" placeholder="${model.user.firstName} ${model.user.secondName}">
        </div>
        <br>
        <div class="form-group">
            <input required type="text" name="age" placeholder="${model.user.age}">
        </div>
        <br>
        <div class="form-group">
            <input required type="text" name="contact" placeholder="${model.user.contact}">
        </div>
        <br>
        <div class="form-group">
            <button type="submit" class="btn-default btn-success">Save</button>
        </div>
    </form>
</body>
</html>