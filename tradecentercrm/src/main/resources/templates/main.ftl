<!DOCTYPE html>
<html lang="en"><head>
  <meta charset="utf-8">
  <title>SNOW Trade Center Website</title>
  <meta name="keywords" content="">
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  
  <meta property="og:title" content="">
	<meta property="og:type" content="website">
	<meta property="og:url" content="">
	<meta property="og:site_name" content="">
	<meta property="og:description" content="">

  <!-- Styles -->
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/animate.css">
  <link href='http://fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900|Montserrat:400,700' rel='stylesheet' type='text/css'>
  

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/main.css">

  <script src="js/modernizr-2.7.1.js"></script>
  
</head>

<body>

    
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
            <a href="/"><img src="img/logo.svg" alt="SNOW Trade Center"></a>
        </div>
        <div class="navbar-collapse collapse">
            <#--Menu on main page-->
          <ul class="nav navbar-nav navbar-right">
              <li><a href="/stores">Stores</a> </li>
              <li><a href="/reviews">Reviews</a></li>
              <#if model.replacementNeeded == true>
                <#if model.isAdmin == true>
                    <li><a href="/admin">Control panel</a></li>
                </#if>
                <#if model.isAdmin == false>
                    <li><a href="/user/me">Profile</a></li>
                </#if>
                </#if>
              <#if model.replacementNeeded == false>
                  <li><a href="/login">Sign in</a></li>
              </#if>
          </ul>
        </div><!--/.navbar-collapse -->
      </div>
    </div>
        
    <header>
      <div class="container">
        <div class="row">
          <div class="col-xs-6">
            <a href="/"><img src="img/logo.svg" alt="Snow Trade Center"></a>
          </div>
          <div class="col-xs-6 signin text-right navbar-nav">
            <a href="/stores">Stores</a>&nbsp; &nbsp;<a href="/reviews">Reviews</a>&nbsp; &nbsp;<#if model.replacementNeeded == true><#if model.isAdmin == true><a href="/admin">Control panel</a></#if><#if model.isAdmin == false><a href="/user/me">Profile</a></#if></#if> <#if model.replacementNeeded == false><a href="/login">Sign in</a></#if>
          </div>
        </div>
        
        <div class="row header-info">
          <div class="col-sm-10 col-sm-offset-1 text-center">
            <h1 class="wow fadeIn">Welcome to the SNOW trade center website</h1>
            <br />
            <p class="lead wow fadeIn" data-wow-delay="0.5s">This website presents CRM system for trade center. <br>
            Log in to see all of the functionality.</p>
            <br />
          </div>
        </div>
      </div>
    </header>
    
    <div class="mouse-icon hidden-xs">
				<div class="scroll"></div>
    </div>
    <div class="col-sm-10 col-sm-offset-1 text-center">
        <br>
        <br>
        <br>
        <p class="lead wow fadeIn" style="color: #8c8c8c; font-weight: bold; font-size: x-large"  data-wow-delay="0.2s">There are some reviews about our trade center:</p>
        <br />
    </div>
    <section id="main-info" class="pad-xl">
	    <div class="container">
		    <div class="row">
                <#list model.reviews as review>
			    <div class="col-sm-4 wow fadeIn" data-wow-delay="0.6s">
				    <hr class="line purple">
				    <h3>${review.author.firstName} ${review.author.secondName}</h3>
				    <p>${review.content}</p>
			    </div>
                </#list>
		    </div>
	    </div>
    </section>

    <section id="press" class="pad-sm">
      <div class="container">
        
        <div class="row margin-30 news-container">
          <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 wow fadeInLeft" data-wow-delay="0.8s">
            <a href="#" target="_blank">
            <img class="news-img pull-left" src="img/press-01.jpg" alt="Tech Crunch">
            <p class="black">Fcking awsum trade center. Told ya.<br />
            <small><em>Tech Crunch - January 15, 2015</em></small></p>
            </a>
          </div>
        </div>
        
        <div class="row margin-30 news-container">
          <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 wow fadeInLeft" data-wow-delay="1.2s">
            <a href="#" target="_blank">
            <img class="news-img pull-left" src="img/press-02.jpg" alt="Forbes">
            <p class="black">Even Abramovich goes here to hang out with his bruddas. <br />
            <small><em>Forbes - Feb 25, 2015</em></small></p>
            </a>
          </div>
        </div>
        
      </div>
    </section>
    
    
    <footer>
      <div class="container">
        
        <div class="row">
          <div class="col-sm-8 margin-20">
            <ul class="list-inline social">
              <li>Connect with us on</li>
              <li><a href="#"><i class="fa fa-twitter"></i></a></li>
              <li><a href="#"><i class="fa fa-facebook"></i></a></li>
              <li><a href="#"><i class="fa fa-instagram"></i></a></li>
            </ul>
          </div>
          
          <div class="col-sm-4 text-right">
            <p><small>Copyright &copy; 2014. All rights reserved. <br>
	            Created by <a href="http://visualsoldiers.com">Visual Soldiers</a></small></p>
          </div>
        </div>
        
      </div>
    </footer>
    
    
    <!-- Javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
    <script src="js/wow.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>

   
    </body>
</html>