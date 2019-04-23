package inventory.servlets;

import inventory.logic.WarehouseLogic;
import inventory.logic.StoreLogic;
import inventory.objects.WarehouseObj;
import inventory.objects.StoreViewObj;
import inventory.objects.WarehouseViewObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "WarehouseServlet", urlPatterns = {"/WarehouseServlet"})
public class WarehouseServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1")) {
                String strName = request.getParameter("name");
                String strStore = request.getParameter("store");
                int iIdStore = Integer.parseInt(strStore);
                
                WarehouseLogic CLogic = new WarehouseLogic();
                int iRows = CLogic.insertWarehouseRows(strName, iIdStore);
                System.out.println("insert warehouse rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2")) {
                WarehouseLogic CLogic = new WarehouseLogic();
                ArrayList<WarehouseViewObj> CArray = CLogic.getAllWarehouses();

                request.getSession().setAttribute("warehousesview", CArray);
                response.sendRedirect("warehouseForm.jsp");
            }
            
            if(strFormId.equals("3")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                WarehouseLogic CLogic = new WarehouseLogic();
                int iRows = CLogic.deleteWarehouseRows(iId);
                
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("4")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                WarehouseLogic CLogic = new WarehouseLogic();
                WarehouseObj CWarehouse = CLogic.getWarehouseById(iId);
                
                StoreLogic CStoreLogic = new StoreLogic();
                ArrayList<StoreViewObj> CStoreArray = CStoreLogic.getAllStores();

                request.getSession().setAttribute("stores", CStoreArray);
                request.getSession().setAttribute("warehouse", CWarehouse);
                response.sendRedirect("warehouseUpdateForm.jsp");
            } 
            
            if(strFormId.equals("5")) {
                String strId = request.getParameter("id");
                String strName = request.getParameter("name");
                String strStore = request.getParameter("store");
                int iId = Integer.parseInt(strId);
                int iIdStore = Integer.parseInt(strStore);
                
                WarehouseLogic CLogic = new WarehouseLogic();
                int iRows = CLogic.updateWarehouseRows(iId, strName, iIdStore);
                System.out.println("update warehouse rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("6"))
            {
                StoreLogic CStoreLogic = new StoreLogic();
                ArrayList<StoreViewObj> CStoreArray = CStoreLogic.getAllStores();

                request.getSession().setAttribute("stores", CStoreArray);
                response.sendRedirect("warehouseNew.jsp");
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
