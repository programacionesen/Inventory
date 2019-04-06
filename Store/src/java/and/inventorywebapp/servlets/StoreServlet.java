
package and.inventorywebapp.servlets;

import and.inventorywebapp.logic.StoreLogic;
import and.inventorywebapp.objects.StoreObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StoreServlet", urlPatterns = {"/StoreServlet"})
public class StoreServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            /* your code */
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                //get parameters
                String strName = request.getParameter("name");
                String strTelephone = request.getParameter("telephone");
                String strIdlocation = request.getParameter("idlocation");
                int iIdlocation = Integer.parseInt(strIdlocation);
                
                //access logic
                StoreLogic CLogic = new StoreLogic();
                int iRows = CLogic.insertStoreRows(strName, strTelephone, iIdlocation);
                System.out.println("inser client rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                StoreLogic CLogic = new StoreLogic();
                ArrayList<StoreObj> CArray = CLogic.getAllStore();
                
                //send to frontend
                request.getSession().setAttribute("store", CArray);
                response.sendRedirect("storeForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                StoreLogic CLogic = new StoreLogic();
                int iRows = CLogic.deleteTableRows(iId);
                
                //send to frontend
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("4"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                StoreLogic CLogic = new StoreLogic();
                StoreObj SStore = CLogic.getStoreById(iId);
                
                //send to frontend
                request.getSession().setAttribute("store", SStore);
                response.sendRedirect("storeUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {
            /*String strId = request.getParameter("id");
            String strName = request.getParameter("name");
            String strTelephone = request.getParameter("telephone");
            String strIdlocation = request.getParameter("idlocation");
            
            Connection con = createConnection();
            String strSql = "UPDATE inventory.store"
                    + "name = '"+strName+"',"
                    + "telephone = '"+strTelephone+"',"
                    + "idlocation = '"+strIdlocation+"',"
                    + "WHERE id = "+strId+";";
            int iRows = executeNonQueryInt(strSql,con);
            
            request.getSession().setAttribute("rows", iRows);
            response.sendRedirect("storeUpdateForm.jsp");
            
            */
               
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