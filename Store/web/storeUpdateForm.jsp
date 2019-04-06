<%@page import="and.inventorywebapp.objects.StoreObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Store</title>
    </head>
    <%
        StoreObj SStore = 
                (StoreObj)request.getSession().getAttribute("store");   
    %>
<body>
        <h1>Update Store</h1>
        <br><br>
        
        <form id="myform" name="myform" action="StoreServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= SStore.getId() %>" disabled/>
            <br><br>
            
            
            <label>Name:</label><br>
            <input type="text" id="name" name="name" value="<%= SStore.getName() %>" />
            <br><br>
            
            <label>Telephone:</label><br>
            <input type="text" id="telephone" name="telephone" value="<%= SStore.getTelephone() %>" />
            <br><br>
            
            <label>Id Location:</label><br>
            <input type="number" id="idlocation" name="idlocation" value="<%= SStore.getIdlocation() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= SStore.getId() %>" />
        </form>
    </body>
</html>
