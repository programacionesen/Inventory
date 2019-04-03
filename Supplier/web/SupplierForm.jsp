<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supplier Form</title>
    </head>
    <body>
        <h1>Supplier Form</h1>
        <br><br>
        <a href="SupplierNew.html">New Supplier</a>
        <br><br>
    
 <table style="width:70%" border=”1”>
            <tr>
              <th> Id </th>
              <th> Name </th>
              <th> ContactName </th> 
              <th> Telephone </th>
              
          </tr >
            <c:forEach items="${arreglo}" var="supplier">
            <tr>
                     <td>${supplier.getId()}</td>
                     <td>${supplier.getName()}</td>
                     <td>${supplier.getContactName()}</td>
                     <td>${supplier.getTelephone()}</td>
                      
                      <td>   
                        <a href="SupplierServlet?formid=4&id=${supplier.getId()}">
                            
                            update
                         </a>
                    </td>
                   
                       <td>  
                        <a href="SupplierServlet?formid=3&id=${supplier.getId()}">
                            delete 
                        </a>
                      </td> 
          
            </tr>
              </c:forEach>
          </table>

    </body>
</html>
                   
          
         