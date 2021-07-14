
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Error</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <!-- VENDOR CSS -->
        <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
        <!-- MAIN CSS -->
        <link rel="stylesheet" href="assets/css/main.css">
        <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
        <link rel="stylesheet" href="assets/css/demo.css">
        <!-- GOOGLE FONTS -->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
        <!-- ICONS -->
       
    </head>

    <body>


        <div class="error-container" style="text-align: center">
            <h1>404</h1>
            <div class="error-details">
                
                Sorry, an error has occured! Why not try going back to the <a href="MainController?action=ViewHome">home page</a> or perhaps try following!
            </div> <!-- /error-details -->
            <br>
            <div class="error-actions">
                <a href="MainController?action=ViewHome" class="btn btn-large btn-primary">
                    <i class="icon-chevron-left"></i>
                    &nbsp;
                    Back to Home						
                </a>
            </div> <!-- /error-actions -->

        </div> <!-- /error-container -->	






        <script src="js/jquery-1.7.2.min.js"></script>
        <script src="js/bootstrap.js"></script>

    </body>

</html>

