package inventory.servlets;

import inventory.logic.ProductLogic;
import inventory.logic.CategoryLogic;
import inventory.logic.SupplierLogic;
import inventory.objects.ProductObj;
import inventory.objects.ProductViewObj;
import inventory.objects.CategoryObj;

import inventory.objects.SupplierObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1")) {
                String strCode = request.getParameter("code");
                String strDescription = request.getParameter("description");
                String strCost = request.getParameter("cost");
                String strPrice = request.getParameter("price");
                String strCategory = request.getParameter("category");
                String strSupplier = request.getParameter("supplier");
                double dCost = Double.parseDouble(strCost);
                double dPrice = Double.parseDouble(strPrice);
                int iIdCategory = Integer.parseInt(strCategory);
                int iIdSupplier = Integer.parseInt(strSupplier);
                
                ProductLogic CLogic = new ProductLogic();
                int iRows = CLogic.insertProductRows(strCode, strDescription, dCost, dPrice, iIdCategory, iIdSupplier);
                System.out.println("insert product rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2")) {
                ProductLogic CLogic = new ProductLogic();
                ArrayList<ProductViewObj> CArray = CLogic.getAllProducts();

                request.getSession().setAttribute("productsview", CArray);
                response.sendRedirect("productForm.jsp");
            }
            
            if(strFormId.equals("3")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                ProductLogic CLogic = new ProductLogic();
                int iRows = CLogic.deleteProductRows(iId);
                
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("4")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                ProductLogic CLogic = new ProductLogic();
                ProductObj CProduct = CLogic.getProductById(iId);
                
                CategoryLogic CCategoryLogic = new CategoryLogic();
                ArrayList<CategoryObj> CCategoryArray = CCategoryLogic.getAllCategories();
                
                SupplierLogic CSupplierLogic = new SupplierLogic();
                ArrayList<SupplierObj> CSupplierArray = CSupplierLogic.getAllSuppliers();
                
                request.getSession().setAttribute("product", CProduct);
                request.getSession().setAttribute("categories", CCategoryArray);
                request.getSession().setAttribute("suppliers", CSupplierArray);
                response.sendRedirect("productUpdateForm.jsp");
            } 
            
            if(strFormId.equals("5")) {
                String strId = request.getParameter("id");
                String strCode = request.getParameter("code");
                String strDescription = request.getParameter("description");
                String strCost = request.getParameter("cost");
                String strPrice = request.getParameter("price");
                String strCategory = request.getParameter("category");
                String strSupplier = request.getParameter("supplier");
                int iId = Integer.parseInt(strId);
                double dCost = Double.parseDouble(strCost);
                double dPrice = Double.parseDouble(strPrice);
                int iIdCategory = Integer.parseInt(strCategory);
                int iIdSupplier = Integer.parseInt(strSupplier);
                
                
                ProductLogic CLogic = new ProductLogic();
                int iRows = CLogic.updateProductRows(iId, strCode, strDescription, dCost, dPrice, iIdCategory, iIdSupplier);
                System.out.println("update product rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("6"))
            {
                CategoryLogic CCategoryLogic = new CategoryLogic();
                ArrayList<CategoryObj> CCategoryArray = CCategoryLogic.getAllCategories();
                
                SupplierLogic CSupplierLogic = new SupplierLogic();
                ArrayList<SupplierObj> CSupplierArray = CSupplierLogic.getAllSuppliers();
                
                request.getSession().setAttribute("categories", CCategoryArray);
                request.getSession().setAttribute("suppliers", CSupplierArray);
                response.sendRedirect("productNew.jsp");
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
