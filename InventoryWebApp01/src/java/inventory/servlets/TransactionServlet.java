package inventory.servlets;

import inventory.logic.TransactionLogic;
import inventory.logic.WarehouseProductLogic;
import inventory.logic.WarehouseLogic;
import inventory.logic.ProductLogic;
import inventory.objects.TransactionObj;
import inventory.objects.WarehouseProductObj;
import inventory.objects.WarehouseViewObj;
import inventory.objects.ProductViewObj;
import inventory.objects.TransactionViewObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TransactionServlet", urlPatterns = {"/TransactionServlet"})
public class TransactionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1")) {
                String strQuantity = request.getParameter("quantity");
                String strDate = request.getParameter("date");
                Date dDate = Date.valueOf(strDate);
                String strType = request.getParameter("type");
                String strWarehouse = request.getParameter("warehouse");
                String strProduct = request.getParameter("product");
                int iQuantity = Integer.parseInt(strQuantity);
                int iType = Integer.parseInt(strType);
                int iIdWarehouse = Integer.parseInt(strWarehouse);
                int iIdProduct = Integer.parseInt(strProduct);
                                
                WarehouseProductLogic WPLogic = new WarehouseProductLogic();
                WarehouseProductObj CWarehouseProduct = WPLogic.getWarehouseProduct(iIdWarehouse, iIdProduct);
                
                int iIdWarehouseProduct = CWarehouseProduct.getId();
                int iStock = CWarehouseProduct.getStock();
                
                if(iType == 0) {
                    int iNewStock = iStock + iQuantity;
                    int iRows = WPLogic.updateWarehouseProductRows(iIdWarehouseProduct, iNewStock, iIdWarehouse, iIdProduct);
                    System.out.println("UPDATE warehouseproduct rows: " + iRows);
                } else if(iType == 1) {
                    int iNewStock = iStock - iQuantity;
                    int iRows = WPLogic.updateWarehouseProductRows(iIdWarehouseProduct, iNewStock, iIdWarehouse, iIdProduct);
                    System.out.println("UPDATE warehouseproduct rows: " + iRows);
                }
                
                TransactionLogic CLogic = new TransactionLogic();
                int iRows2 = CLogic.insertTransactionRows(iQuantity, dDate, iType, iIdWarehouseProduct);
                System.out.println("INSERT transaction rows: " + iRows2);
                
                request.getSession().setAttribute("rows", new Integer(iRows2) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2")) {
                TransactionLogic CLogic = new TransactionLogic();
                ArrayList<TransactionViewObj> CArray = CLogic.getAllTransactions();

                request.getSession().setAttribute("transactionsview", CArray);
                response.sendRedirect("transactionForm.jsp");
            }
            
            if(strFormId.equals("3")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                TransactionLogic CLogic = new TransactionLogic();
                int iRows = CLogic.deleteTransactionRows(iId);
                
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("4")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                TransactionLogic CLogic = new TransactionLogic();
                TransactionObj CTransaction = CLogic.getTransactionById(iId);
                
                int iIdwarehouseproduct = CTransaction.getIdwarehouseproduct();
                
                WarehouseProductLogic WPLogic = new WarehouseProductLogic();
                WarehouseProductObj CWarehouseProduct = WPLogic.getWarehouseProductById(iIdwarehouseproduct);
                
                WarehouseLogic CWarehouseLogic = new WarehouseLogic();
                ArrayList<WarehouseViewObj> CWarehouseArray = CWarehouseLogic.getAllWarehouses();
                
                ProductLogic CProductLogic = new ProductLogic();
                ArrayList<ProductViewObj> CProductArray = CProductLogic.getAllProducts();
                
                request.getSession().setAttribute("warehouses", CWarehouseArray);
                request.getSession().setAttribute("products", CProductArray);
                request.getSession().setAttribute("warehouseproduct", CWarehouseProduct);
                request.getSession().setAttribute("transaction", CTransaction);
                response.sendRedirect("transactionUpdateForm.jsp");
            } 
            
            if(strFormId.equals("5")) {
                String strId = request.getParameter("id");
                String strQuantity = request.getParameter("quantity");
                String strDate = request.getParameter("date");
                Date dDate = Date.valueOf(strDate);
                String strType = request.getParameter("type");
                String strWarehouse = request.getParameter("warehouse");
                String strProduct = request.getParameter("product");
                int iId = Integer.parseInt(strId);
                int iQuantity = Integer.parseInt(strQuantity);
                int iType = Integer.parseInt(strType);
                int iIdWarehouse = Integer.parseInt(strWarehouse);
                int iIdProduct = Integer.parseInt(strProduct);

                WarehouseProductLogic WPLogic = new WarehouseProductLogic();
                WarehouseProductObj CWarehouseProduct = WPLogic.getWarehouseProduct(iIdWarehouse, iIdProduct);
                
                int iIdWarehouseProduct = CWarehouseProduct.getId();
                int iStock = CWarehouseProduct.getStock();
                
                if(iType == 0) {
                    int iNewStock = iStock + iQuantity;
                    int iRows = WPLogic.updateWarehouseProductRows(iIdWarehouseProduct, iNewStock, iIdWarehouse, iIdProduct);
                    System.out.println("UPDATE warehouseproduct rows: " + iRows);
                } else if(iType == 1) {
                    int iNewStock = iStock - iQuantity;
                    int iRows = WPLogic.updateWarehouseProductRows(iIdWarehouseProduct, iNewStock, iIdWarehouse, iIdProduct);
                    System.out.println("UPDATE warehouseproduct rows: " + iRows);
                }
                
                TransactionLogic CLogic = new TransactionLogic();
                int iRows2 = CLogic.updateTransactionRows(iId, iQuantity, dDate, iType, iIdWarehouseProduct);
                System.out.println("INSERT transaction rows: " + iRows2);
                
                request.getSession().setAttribute("rows", new Integer(iRows2) );
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
                response.sendRedirect("transactionNew.jsp");
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
