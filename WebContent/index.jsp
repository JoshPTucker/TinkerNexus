<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <title>TinkerNexus: The Social Network for Makers!</title>
        <meta charset="UTF-8">
        
        <!-- the following tag makes it so that the site can be viewed by a 
             multitude of devices -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <!-- keywords make it so that the website can be found by search engines -->
        <meta name="keywords" content="Tinker, Nexus, TinkerNexus, tinkernexus, 
              tinker-nexus, Tinker-Nexus, Tinker Nexus, make, makers, build, collaborate, social, 
              network, social netwoking, machine, machining, invent, invention, produce, production">
        
        <!-- create a link to the bootstrap css file -->
        <link rel="stylesheet" href="CSS/bootstrap.min.css">
        
        <!-- create a link to our personal css file -->
        <link rel="stylesheet" href="CSS/newcss.css">
        
        <!-- links for the login section css -->
        <link rel="stylesheet" href="normalize.css">
        <link rel="stylesheet" href="style.css">
        
        <!-- link the slider css file for the "About Us" (later "Featured Projects")
             slide show -->
        <link rel="stylesheet" type="text/css" href="slick/slick.css"/>
</head>

    
<body>
<jsp:include page="navbar.jsp"></jsp:include>
    <!-- Create a CSS bootstrap container class to help arrange the elements on the page -->
    <div class="container-fluid">
        <!-- row that contains login and logo -->
        <div class="row container1">
            <!-- Center the logo, make it responsive, create class="relative" to help position the login area -->
            <img class="logo img-responsive" id="center" src="images/NewLogo.png" width="10%" height="7%"alt="logo">
                <!-- Position the login area in spite of the margin space taken up by the logo using class="absolute" and placing
                    the login div within the logo div. -->
            <div class="loginsect">
                <section class="loginform cf">
                    <form name="login" action="index_submit" method="get" accept-charset="utf-8">
			<ul>
				<li>
					<label for="usermail">Email</label>
					<input type="email" name="usermail" placeholder="yourname@email.com" required>
				</li>
				<li>
					<label for="password">Password</label>
					<input type="password" name="password" placeholder="password" required></li>
				<li>
					<input type="submit" value="Login">
				</li>
			</ul>
                    </form>
                </section>

            </div>       
        </div>
        
        <!-- Create a row to place the TinkerNexus banner --> 
        <div class="row">
                <!--Create a div to contain the banner -->
                <div class="col-md-12">
                    <!-- implement the image -->
                    <img src="images/bannertop.png" alt="Tinker Nexus" class="img-responsive center-block"/>
                </div>
        </div>
        
        <!-- Create a row for the slogan -->
        <div class="row">
            <!-- Create a div to contain the slogan -->
            <div class="col-md-12">
                <!-- implement the slogan -->
                <h3 align= 'center'><strong>The Social Network Site For Makers!</strong></h3> 
            </div>
        </div>
        
        
        <!-- Create a row for the "About Us" banner (later to be called "Featured Projects") -->
        <div class="row">
            <!-- Create a div to contain the banner -->
            <div class="col-md-12">
                <!-- Implement the banner -->
                <img src="images/AboutUs.png" alt="About Us" class="img-responsive center-block"/>
            </div>
        </div>
        
        
        <!-- Create a row to contain the "body" of the website -->
        <div class="row" id="slide_container">
            <!-- Implement a carousel that will contain all the fancy stuff -->
            <div class="col-md-3"><img src="images/ProjectFrame.png" class="img-responsive" alt="project frame"/></div>
            <div class="col-md-3"><img src="images/ProjectFrame.png" class="img-responsive" alt="project frame"/></div>
            <div class="col-md-3"><img src="images/ProjectFrame.png" class="img-responsive" alt="project frame"/></div>
            <div class="col-md-3"><img src="images/ProjectFrame.png" class="img-responsive" alt="project frame"/></div>
            <div class="col-md-3"><img src="images/ProjectFrame.png" class="img-responsive" alt="project frame"/></div>
            <div class="col-md-3"><img src="images/ProjectFrame.png" class="img-responsive" alt="project frame"/></div>
        </div>
        
        
        <footer class="bgimg row bottomrow">
            <div class="col-md-1">
                <a href="About_Us/about-us.html"><strong >About Us! :)</strong></a>
            </div>
            
            <div class="col-md-1">
                <strong >Start a Project</strong>
            </div> 
            
            <div class="col-md-1">
                <a href="Contact_Us/contact-us.html"><strong class="pagetext">Contact</strong></a>
            </div>
            
            <div class="col-md-1">
                <a href="Terms/terms.html"><strong >Terms</strong></a>
            </div> 
            
            <div class="col-md-1">
                <strong >Advertise</strong>
            </div> 
            
            <div class="col-md-1">
                <strong>Careers</strong>
            </div> 
            
            <div class="col-md-1">
                <strong>Help and FAQ</strong>
            </div>       
        </footer>
        
        <!-- Link to JQuery (necessary for bootstrap javascript) -->
        <script src="jquery-3.1.1.min.js"></script>
        <!-- Link to bootstrap javascript -->
        <script src="bootstrap.min.js"></script>
    </div>
</body>
       
</html>