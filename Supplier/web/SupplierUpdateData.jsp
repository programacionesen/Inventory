<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Supplier</title>
    </head>
    <body>
        <h1>Update Supplier</h1>
        <br><br>
        
        <form name="SupplierUpdateForm" action="SupplierServlet" method="get" >
            Id: <br>
            <input type ="text" name ="regid" value="${arreglo[0].getId()}" disabled/>
            <br><br>
            
            Name: <br>
            <input type ="text" name ="name" value="${arreglo[0].getName()}" />
            <br><br>
            
            ContactName: <br>
            <input type ="text" name="contactname" value="${arreglo[0].getContactName()}" />
            <br><br>
            
            Telephone: <br>
            <input type ="text" name="telephone" value="${arreglo[0].getTelephone()}" />
            <br><br>
            
            <input type = "submit" name = "myform" value="Create"/>
            <br><br>
            
            
            <input type = "hidden" name="id" value="${arreglo[0].getId()}" />
            <input type = "hidden" name="formid" value="5" />
            
        </form>
    </body>
</html>