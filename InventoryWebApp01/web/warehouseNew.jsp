<%@page import="inventory.objects.StoreViewObj"%>
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
        <title>New Warehouse</title>
    </head>
    <%
        ArrayList<StoreViewObj> CStoreArray = (ArrayList<StoreViewObj>)request.getSession().getAttribute("stores");
        Iterator<StoreViewObj> iteStoreArray = CStoreArray.iterator();
    %>
    <body>
        
        <h1>New Warehouse</h1>
        
        <div class="row">
        <form id="myform" name="myform" action="WarehouseServlet" method="get">
            <label>Name:</label><br>
            <input type="text" id="name" name="name" required>
            <br><br>
            
            <label>Store:</label><br>
            <select id="store" name="store">
                <option id="store0" name="store0" value="0"></option>                
                <%
                    if(iteStoreArray!=null)
                    {
                        StoreViewObj CStoreTemp;
                        while(iteStoreArray.hasNext())
                        {
                            CStoreTemp = iteStoreArray.next();
                %>
                            <option id="store<%= CStoreTemp.getId() %>" 
                                    name="store<%= CStoreTemp.getId() %>" 
                                    value="<%= CStoreTemp.getId() %>">
                                <%= CStoreTemp.getName() %>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            <br><br>
            
            <input class="btn-opc" type="submit" id="mysubmit" name="mysubmit" value="Create">
            <input type="hidden" id="formid" name="formid" value="1">
        </form>
        </div>
        <br><br>

        <a class="back"href="WarehouseServlet?formid=2">Back</a>
        
    </body>
</html>