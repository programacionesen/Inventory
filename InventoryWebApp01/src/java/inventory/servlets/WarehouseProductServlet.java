package inventory.servlets;

import inventory.logic.WarehouseProductLogic;
import inventory.logic.WarehouseLogic;
import inventory.logic.ProductLogic;
import inventory.objects.WarehouseProductObj;
import inventory.objects.WarehouseViewObj;
import inventory.objects.ProductViewObj;
import inventory.objects.WarehouseProductViewObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "WarehouseProductServlet", urlPatterns = {"/WarehouseProductServlet"})
public class WarehouseProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1")) {
                String strStock = request.getParameter("stock");
                String strWarehouse = request.getParameter("warehouse");
                String strProduct = request.getParameter("product");
                int iStock = Integer.parseInt(strStock);
                int iIdWarehouse = Integer.parseInt(strWarehouse);
                int iIdProduct = Integer.parseInt(strProduct);
                
                WarehouseProductLogic CLogic = new WarehouseProductLogic();
                int iRows = CLogic.insertWarehouseProductRows(iStock, iIdWarehouse, iIdProduct);
                System.out.println("insert warehouse rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2")) {
                WarehouseProductLogic CLogic = new WarehouseProductLogic();
                ArrayList<WarehouseProductViewObj> CArray = CLogic.getAllWarehouseProducts();

                request.getSession().setAttribute("warehouseproductsview", CArray);
                response.sendRedirect("warehouseproductForm.jsp");
            }
            
            if(strFormId.equals("3")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                WarehouseProductLogic CLogic = new WarehouseProductLogic();
                int iRows = CLogic.deleteWarehouseProductRows(iId);
                
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("4")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                WarehouseProductLogic CLogic = new WarehouseProductLogic();
                WarehouseProductObj CWarehouseProduct = CLogic.getWarehouseProductById(iId);
                
                WarehouseLogic CWarehouseLogic = new WarehouseLogic();
                ArrayList<WarehouseViewObj> CWarehouseArray = CWarehouseLogic.getAllWarehouses();
                
                ProductLogic CProductLogic = new ProductLogic();
                ArrayList<ProductViewObj> CProductArray = CProductLogic.getAllProducts();
                
                request.getSession().setAttribute("warehouses", CWarehouseArray);
                request.getSession().setAttribute("products", CProductArray);
                request.getSession().setAttribute("warehouseproduct", CWarehouseProduct);
                response.sendRedirect("warehouseproductUpdateForm.jsp");
            } 
            
            if(strFormId.equals("5")) {
                String strId = request.getParameter("id");
                String strStock = request.getParameter("stock");
                String strWarehouse = request.getParameter("warehouse");
                String strProduct = request.getParameter("product");
                int iId = Integer.parseInt(strId);
                int iStock = Integer.parseInt(strStock);
                int iIdWarehouse = Integer.parseInt(strWarehouse);
                int iIdProduct = Integer.parseInt(strProduct);
                
                WarehouseProductLogic CLogic = new WarehouseProductLogic();
                int iRows = CLogic.updateWarehouseProductRows(iId, iStock, iIdWarehouse, iIdProduct);
                System.out.println("update warehouseproduct rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("6"))
            {
                WarehouseLogic CWarehouseLogic = new WarehouseLogic();
                ArrayList<WarehouseViewObj> CWarehouseArray = CWarehouseLogic.getAllWarehouses();
                
                ProductLogic CProductLogic = new ProductLogic();
                ArrayList<ProductViewObj> CProductArray = CProductLogic.getAllProducts();
                
                request.getSession().setAttribute("warehouses", CWarehouseArray);
                request.getSession().setAttribute("products", CProductArray);
                response.sendRedirect("warehouseproductNew.jsp");
            }   
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
