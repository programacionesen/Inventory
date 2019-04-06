
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="and.inventorywebapp.objects.StoreObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store</title>
        <link href="styles/tablaStyles.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        ArrayList<StoreObj> CArray = 
                (ArrayList<StoreObj>)request.getSession().getAttribute("store");
        Iterator<StoreObj> iteArray = CArray.iterator();
    %>
    
    <body>
        <h1>Store</h1>
        <br>
        <a href="storeNew.html">New Store</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Telephone</th>
            <th>Idlocation</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                StoreObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getName() %></td>
                    <td><%= CTemp.getTelephone() %></td>
                    <td><%= CTemp.getIdlocation() %></td>
                    <td>
                        <a href="StoreServlet?formid=4&id=<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="StoreServlet?formid=3&id=<%= CTemp.getId() %>">
                            delete
                        </a>
                    </td>
                </tr>
        <%
                }
            }
        %>
        
        </table>
    </body>
</html>
