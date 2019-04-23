<%@page import="inventory.objects.ExpensesObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" type="text/css" href="resources/css/normalize.css">
    <link rel=stylesheet type="text/css" href="resources/css/style-inventario.css">
    <link href="https://unpkg.com/ionicons@4.4.4/dist/css/ionicons.min.css" rel="stylesheet">
        
    <link rel="apple-touch-icon" sizes="180x180" href="resources/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="resources/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="resources/favicon/favicon-16x16.png">
    <link rel="manifest" href="resources/favicon/site.webmanifest">
    <link rel="mask-icon" href="resources/favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">  
        
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expenses</title>
    </head>
    <%
        ArrayList<ExpensesObj> CArray = (ArrayList<ExpensesObj>) request.getSession().getAttribute("expenses");
        Iterator<ExpensesObj> iteArray = CArray.iterator();
    %>
    <body>
         <header>
        <h1>Expenses</h1>
            <nav>
                <div class="row">
                    <ul class="main-nav js--main-nav">
                        <li><a href="expensesNew.html">Back </a> </li>
                        <li><a href="index.html">Menu </a><i class="icon ion-md-menu"></i> </li>
                    </ul>
                    
                </div>
            
            </nav>
        </header>
        
        <section class="info-table">
            <div class="row">
            <table style="width:100%">
            <tr>
                <th>Expenses</th>
            </tr>
            <% if(iteArray!=null) {
                ExpensesObj CTemp;
                while(iteArray.hasNext()) {
                    CTemp = iteArray.next();
            %>
                <tr>
                    <td>$ <%= CTemp.getExpenses() %></td>
                </tr>
        <%
                }
            }
        %>
             </table>
        
            
                
                
            </div>
            
            
        </section>
        
    </body>
</html>