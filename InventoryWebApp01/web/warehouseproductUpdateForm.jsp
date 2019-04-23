<%@page import="inventory.objects.WarehouseProductObj"%>
<%@page import="inventory.objects.WarehouseViewObj"%>
<%@page import="inventory.objects.ProductViewObj"%>
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
        <title>Update Warehouse</title>
    </head>
    <% 
        WarehouseProductObj warehouseproduct = (WarehouseProductObj) request.getSession().getAttribute("warehouseproduct"); 
    
        ArrayList<WarehouseViewObj> CWarehouseArray = (ArrayList<WarehouseViewObj>)request.getSession().getAttribute("warehouses");
        Iterator<WarehouseViewObj> iteWarehouseArray = CWarehouseArray.iterator();
        
        ArrayList<ProductViewObj> CProductArray = (ArrayList<ProductViewObj>)request.getSession().getAttribute("products");
        Iterator<ProductViewObj> iteProductArray = CProductArray.iterator();
    %>
    <body>
        <h1>Update WarehouseProduct</h1>
        
        <div class="row">
        
        <form id="myform" name="myform" action="WarehouseProductServlet" method="get">
            <label>ID:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= warehouseproduct.getId() %>" disabled>
            <br><br>
            
            <label>Stock:</label><br>
            <input type="text" id="stock" name="stock" value="<%= warehouseproduct.getStock() %>">
            <br><br>
            
            <label>Product:</label><br>
            <select id="product" name="product">
                <option id="product0" name="product0" value="0"></option>                
                <%
                    if(iteProductArray!=null)
                    {
                        ProductViewObj CProductTemp;
                        while(iteProductArray.hasNext())
                        {
                            CProductTemp = iteProductArray.next();
                            
                            if(CProductTemp.getId() == warehouseproduct.getIdProduct()) {
                %>
                            <option id="product<%= CProductTemp.getId() %>" 
                                    name="product<%= CProductTemp.getId() %>" 
                                    value="<%= CProductTemp.getId() %>"
                                    selected="selected">
                                <%= CProductTemp.getDescription() %>
                            </option>
                <%
                        } else {
                %>
                            <option id="product<%= CProductTemp.getId() %>" 
                                    name="product<%= CProductTemp.getId() %>" 
                                    value="<%= CProductTemp.getId() %>">
                                <%= CProductTemp.getDescription() %>
                            </option>
                <%
}

                        }
                    }
                %>
            </select>
            <br><br>
            
            <label>Warehouse:</label><br>
            <select id="warehouse" name="warehouse">
                <option id="warehouse0" name="warehouse0" value="0"></option>                
                <%
                    if(iteWarehouseArray!=null)
                    {
                        WarehouseViewObj CWarehouseTemp;
                        while(iteWarehouseArray.hasNext())
                        {
                            CWarehouseTemp = iteWarehouseArray.next();
                            
                            if(CWarehouseTemp.getId() == warehouseproduct.getIdWarehouse()) {
                %>
                            <option id="warehouse<%= CWarehouseTemp.getId() %>" 
                                    name="warehouse<%= CWarehouseTemp.getId() %>" 
                                    value="<%= CWarehouseTemp.getId() %>"
                                    selected="selected">
                                <%= CWarehouseTemp.getName() %>
                            </option>
                <%
                        } else {
                %>
                            <option id="warehouse<%= CWarehouseTemp.getId() %>" 
                                    name="warehouse<%= CWarehouseTemp.getId() %>" 
                                    value="<%= CWarehouseTemp.getId() %>">
                                <%= CWarehouseTemp.getName() %>
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
            <input type="hidden" id="id" name="id" value="<%= warehouseproduct.getId() %>">
        </form>
        </div>
       

        <a class="back" href="WarehouseProductServlet?formid=2">Back</a>
        
    </body>
</html>