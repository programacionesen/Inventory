
<%@page import="inventory.objects.ProductViewObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" type="text/css" href="resources/css/normalize.css">
    <link rel=stylesheet type="text/css" href="resources/css/style-inventario.css">
    <link href="https://unpkg.com/ionicons@4.4.4/dist/css/ionicons.min.css" rel="stylesheet">
           <link rel="stylesheet" type="text/css" href="resources/css/queries.css">
        
    <link rel="apple-touch-icon" sizes="180x180" href="resources/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="resources/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="resources/favicon/favicon-16x16.png">
    <link rel="manifest" href="resources/favicon/site.webmanifest">
    <link rel="mask-icon" href="resources/favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Form</title>
    </head>
    <%
        ArrayList<ProductViewObj> CArray = (ArrayList<ProductViewObj>) request.getSession().getAttribute("productsview");
        Iterator<ProductViewObj> iteArray = CArray.iterator();
    %>
    <body>
        <header>
        <h1>Product</h1>
            <nav>
                <div class="row">
                    <ul class="main-nav js--main-nav">
                        <li> <a href="ProductServlet?formid=6">Add New Product </a> <i class="icon ion-ios-add-circle"></i></li>
                        <li><a href="index.html">Menu </a><i class="icon ion-md-menu"></i> </li>
                    </ul>
                    
                </div>
            
            </nav>
        </header>
       
        
          <section class="info-table">
              
            <div class="row">
               <table style="width:125%">
            <tr>
                <th>ID</th>
                <th>Code</th>
                <th>Product</th>
                <th>Cost</th>
                <th>Price</th>
                <th>Category</th>
                <th>Supplier</th>
                <th></th>
            </tr>
            <% if(iteArray!=null) {
                ProductViewObj CTemp;
                while(iteArray.hasNext()) {
                    CTemp = iteArray.next();
            %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getCode() %></td>
                    <td><%= CTemp.getDescription() %></td>
                    <td><%= CTemp.getCost() %></td>
                    <td><%= CTemp.getPrice() %></td>
                    <td><%= CTemp.getCategory() %></td>
                    <td><%= CTemp.getSupplier() %></td>                    
                    <td class="btn-opc"><a href="ProductServlet?formid=4&id=<%= CTemp.getId() %>"><i class="icon ion-ios-color-wand"></i></a>
                        <a href="ProductServlet?formid=3&id=<%= CTemp.getId() %>"><i class="icon ion-ios-trash"></i></a></td>
                </tr>
        <%
                }
            }
        %>
        </table>  
            </div>
          </section>
        <footer></footer>
                
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="js/jquery.waypoints.min.js"></script>
   <script src="js/scripts-stickynav.js"></script>
    
    </body>
</html>