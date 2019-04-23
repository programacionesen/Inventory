<%@page import="inventory.objects.StoreObj"%>
<%@page import="inventory.objects.CityObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Update Store</title>
    </head>
    <%
        StoreObj store = (StoreObj) request.getSession().getAttribute("store");
        
        ArrayList<CityObj> CCityArray = (ArrayList<CityObj>)request.getSession().getAttribute("cities");
        Iterator<CityObj> iteCityArray = CCityArray.iterator();
    %>
    <body>
        <h1>Update Store</h1>
        
        <div class="row">
        
        <form id="myform" name="myform" action="StoreServlet" method="get">
            <label>ID:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= store.getId() %>" disabled>
            <br><br>
            
            <label>Name:</label><br>
            <input type="text" id="name" name="name" value="<%= store.getName() %>">
            <br><br>
            
            <label>Telephone:</label><br>
            <input type="text" id="telephone" name="telephone" value="<%= store.getTelephone() %>">
            <br><br>
            
            <label>Address:</label><br>
            <input type="text" id="address" name="address" value="<%= store.getAddress() %>">
            <br><br>
            
            <label>ZIP Code:</label><br>
            <input type="text" id="zipcode" name="zipcode" value="<%= store.getZipCode() %>">
            <br><br>
            
            <label>Coordinates:</label><br>
            <input type="text" id="coordinates" name="coordinates" value="<%= store.getCoordinates() %>">
            <br><br>
            
            <label>City:</label><br>
            <select id="city" name="city">
                <option id="city0" name="city0" value="0"></option>                
                <%
                    if(iteCityArray!=null)
                    {
                        CityObj CCityTemp;
                        while(iteCityArray.hasNext())
                        {
                            CCityTemp = iteCityArray.next();
                            
                            if(CCityTemp.getId() == store.getIdCity()) {
                %>
                            <option id="category<%= CCityTemp.getId() %>" 
                                    name="category<%= CCityTemp.getId() %>" 
                                    value="<%= CCityTemp.getId() %>"
                                    selected="selected">
                                <%= CCityTemp.getName() %>
                            </option>
                <%
                        } else {
                %>
                            <option id="category<%= CCityTemp.getId() %>" 
                                    name="category<%= CCityTemp.getId() %>" 
                                    value="<%= CCityTemp.getId() %>">
                                <%= CCityTemp.getName() %>
                            </option>
                <%
}

                        }
                    }
                %>
            </select>
            <br><br>
            
            <input class="btn-opc" type="submit" id="mysubmit" name="mysubmit" value="Update">
            <input type="hidden" id="formid" name="formid" value="5">
            <input type="hidden" id="id" name="id" value="<%= store.getId() %>">
        </form>
        </div>
        
        
        <a class="back"href="StoreServlet?formid=2">Back</a>
        
    </body>
</html>