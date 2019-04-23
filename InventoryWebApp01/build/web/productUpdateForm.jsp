<%@page import="inventory.objects.ProductObj"%>
<%@page import="inventory.objects.CategoryObj"%>
<%@page import="inventory.objects.SupplierObj"%>
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
        <title>Update Product</title>
    </head>
    <% 
        ProductObj product = (ProductObj) request.getSession().getAttribute("product");
        
        ArrayList<CategoryObj> CCategoryArray = (ArrayList<CategoryObj>)request.getSession().getAttribute("categories");
        Iterator<CategoryObj> iteCategoryArray = CCategoryArray.iterator();
        
        ArrayList<SupplierObj> CSupplierArray = (ArrayList<SupplierObj>)request.getSession().getAttribute("suppliers");
        Iterator<SupplierObj> iteSupplierArray = CSupplierArray.iterator();    
    %>
    <body>
        <h1>Update Product</h1>
        <div class="row">
        <form id="myform" name="myform" action="ProductServlet" method="get">
            <label>ID:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= product.getId() %>" disabled>
            <br><br>
            
            <label>Code:</label><br>
            <input type="text" id="code" name="code" value="<%= product.getCode() %>">
            <br><br>
            
            <label>Description:</label><br>
            <input type="text" id="description" name="description" value="<%= product.getDescription() %>">
            <br><br>
            
            <label>Cost:</label><br>
            <input type="number" id="cost" name="cost" step="0.01" value="<%= product.getCost() %>">
            <br><br>
            
            <label>Price:</label><br>
            <input type="number" id="price" name="price" step="0.01" value="<%= product.getPrice() %>">
            <br><br>
            
            <label>Category:</label><br>
            <select id="category" name="category">
                <option id="category0" name="category0" value="0"></option>                
                <%
                    if(iteCategoryArray!=null)
                    {
                        CategoryObj CCategoryTemp;
                        while(iteCategoryArray.hasNext())
                        {
                            CCategoryTemp = iteCategoryArray.next();
                            
                            if(CCategoryTemp.getId() == product.getIdCategory()) {
                %>
                            <option id="category<%= CCategoryTemp.getId() %>" 
                                    name="category<%= CCategoryTemp.getId() %>" 
                                    value="<%= CCategoryTemp.getId() %>"
                                    selected="selected">
                                <%= CCategoryTemp.getName() %>
                            </option>
                <%
                        } else {
                %>
                            <option id="category<%= CCategoryTemp.getId() %>" 
                                    name="category<%= CCategoryTemp.getId() %>" 
                                    value="<%= CCategoryTemp.getId() %>">
                                <%= CCategoryTemp.getName() %>
                            </option>
                <%
}

                        }
                    }
                %>
            </select>
            <br><br>
            
            <label>Supplier:</label><br>
            <select id="supplier" name="supplier">
                <option id="supplier0" name="supplier0" value="0"></option>                
                <%
                    if(iteSupplierArray!=null)
                    {
                        SupplierObj CSupplierTemp;
                        while(iteSupplierArray.hasNext())
                        {
                            CSupplierTemp = iteSupplierArray.next();
                            
                            if(CSupplierTemp.getId() == product.getIdSupplier()) {
                %>
                            <option id="supplier<%= CSupplierTemp.getId() %>" 
                                    name="supplier<%= CSupplierTemp.getId() %>" 
                                    value="<%= CSupplierTemp.getId() %>"
                                    selected="selected">
                                <%= CSupplierTemp.getName() %>
                            </option>
                <%
                        } else {
                %>
                            <option id="supplier<%= CSupplierTemp.getId() %>" 
                                    name="supplier<%= CSupplierTemp.getId() %>" 
                                    value="<%= CSupplierTemp.getId() %>">
                                <%= CSupplierTemp.getName() %>
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
            <input type="hidden" id="id" name="id" value="<%= product.getId() %>">
        </form>
        </div>
        
        <a class="back" href="ProductServlet?formid=2">Back</a>
        
    </body>
</html>