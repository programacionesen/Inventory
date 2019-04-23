<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <link rel="stylesheet" type="text/css" href="resources/css/normalize.css">
    <link href="https://unpkg.com/ionicons@4.5.5/dist/css/ionicons.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="resources/css/style-form.css">
    
    
    
        <link rel="apple-touch-icon" sizes="180x180" href="resources/favicon/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="resources/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="resources/favicon/favicon-16x16.png">
        <link rel="manifest" href="resources/favicon/site.webmanifest">
        <link rel="mask-icon" href="resources/favicon/safari-pinned-tab.svg" color="#5bbad5">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message</title>
    </head>
    <%  
        Integer iRowsObj = (Integer) request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
    %>
    <body>
        <h1>Message</h1>
        <br><br>
        <div class="row"
        <p><%= iRows %> row(s) were affected. <a class="back" href="index.html">Home</a></p>
        <br><br>
        </div>
        
    
    </body>
</html>