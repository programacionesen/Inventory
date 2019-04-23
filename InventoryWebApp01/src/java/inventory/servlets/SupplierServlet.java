package inventory.servlets;

import inventory.logic.SupplierLogic;
import inventory.objects.SupplierObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SupplierServlet", urlPatterns = {"/SupplierServlet"})
public class SupplierServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1")) {
                String strName = request.getParameter("name");
                String strContactName = request.getParameter("contactname");
                String strTelephone = request.getParameter("telephone");
                
                SupplierLogic CLogic = new SupplierLogic();
                int iRows = CLogic.insertSupplierRows(strName, strContactName, strTelephone);
                System.out.println("insert supplier rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2")) {
                SupplierLogic CLogic = new SupplierLogic();
                ArrayList<SupplierObj> CArray = CLogic.getAllSuppliers();

                request.getSession().setAttribute("suppliers", CArray);
                response.sendRedirect("supplierForm.jsp");
            }
            
            if(strFormId.equals("3")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                SupplierLogic CLogic = new SupplierLogic();
                int iRows = CLogic.deleteSupplierRows(iId);
                
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("4")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                SupplierLogic CLogic = new SupplierLogic();
                SupplierObj CSupplier = CLogic.getSupplierById(iId);
                
                request.getSession().setAttribute("supplier", CSupplier);
                response.sendRedirect("supplierUpdateForm.jsp");
            } 
            
            if(strFormId.equals("5")) {
                String strId = request.getParameter("id");
                String strName = request.getParameter("name");
                String strContactName = request.getParameter("contactname");
                String strTelephone = request.getParameter("telephone");
                int iId = Integer.parseInt(strId);
                
                SupplierLogic CLogic = new SupplierLogic();
                int iRows = CLogic.updateSupplierRows(iId, strName, strContactName, strTelephone);
                System.out.println("update supplier rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
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
