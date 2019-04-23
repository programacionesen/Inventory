<%@page import="inventory.objects.CategoryObj"%>
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
        <meta name="msapplication-TileColor" content="#da532c">
        <meta name="theme-color" content="#ffffff">  
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Category</title>
    </head>
    <% CategoryObj category = (CategoryObj) request.getSession().getAttribute("category"); %>
    <body>
        <h1>Update Category</h1>
        
        
        <div class="row">
        <form id="myform" name="myform" action="CategoryServlet" method="get">
            <label>ID:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= category.getId() %>" disabled>
            <br><br>
            
            <label>Name:</label><br>
            <input type="text" id="name" name="name" value="<%= category.getName() %>">
            <br><br>
            
            <input class="btn-submit" type="submit" id="mysubmit" name="mysubmit" value="Update">
            <input type="hidden" id="formid" name="formid" value="5">
            <input type="hidden" id="id" name="id" value="<%= category.getId() %>">
        </form>
        </div>
        
        
        <a class="back" href="CategoryServlet?formid=2">Back</a>
        
    </body>
</html>