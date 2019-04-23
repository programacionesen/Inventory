package inventory.servlets;

import inventory.logic.StoreLogic;
import inventory.logic.CityLogic;
import inventory.objects.CityObj;
import inventory.objects.StoreObj;
import inventory.objects.StoreViewObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StoreServlet", urlPatterns = {"/StoreServlet"})
public class StoreServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1")) {
                String strName = request.getParameter("name");
                String strTelephone = request.getParameter("telephone");
                String strAddress = request.getParameter("address");
                String strZipCode = request.getParameter("zipcode");
                String strCoordinates = request.getParameter("coordinates");
                String strCity = request.getParameter("city");
                int iIdCity = Integer.parseInt(strCity);
                
                StoreLogic CLogic = new StoreLogic();
                int iRows = CLogic.insertStoreRows(strName, strTelephone, strAddress, strZipCode, strCoordinates, iIdCity);
                System.out.println("insert store rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2")) {
                StoreLogic CLogic = new StoreLogic();
                ArrayList<StoreViewObj> CArray = CLogic.getAllStores();

                request.getSession().setAttribute("storesview", CArray);
                response.sendRedirect("storeForm.jsp");
            }
            
            if(strFormId.equals("3")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                StoreLogic CLogic = new StoreLogic();
                int iRows = CLogic.deleteStoreRows(iId);
                
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("4")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                StoreLogic CLogic = new StoreLogic();
                StoreObj CStore = CLogic.getStoreById(iId);
                
                CityLogic CCityLogic = new CityLogic();
                ArrayList<CityObj> CCityArray = CCityLogic.getAllCities();
                
                request.getSession().setAttribute("store", CStore);
                request.getSession().setAttribute("cities", CCityArray);
                response.sendRedirect("storeUpdateForm.jsp");
            } 
            
            if(strFormId.equals("5")) {
                String strId = request.getParameter("id");
                String strName = request.getParameter("name");
                String strTelephone = request.getParameter("telephone");
                String strAddress = request.getParameter("address");
                String strZipCode = request.getParameter("zipcode");
                String strCoordinates = request.getParameter("coordinates");
                String strCity = request.getParameter("city");
                int iId = Integer.parseInt(strId);
                int iIdCity = Integer.parseInt(strCity);
                
                StoreLogic CLogic = new StoreLogic();
                int iRows = CLogic.updateStoreRows(iId, strName, strTelephone, strAddress, strZipCode, strCoordinates, iIdCity);
                System.out.println("update store rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("6"))
            {
                CityLogic CCityLogic = new CityLogic();
                ArrayList<CityObj> CCityArray = CCityLogic.getAllCities();
                
                request.getSession().setAttribute("cities", CCityArray);
                response.sendRedirect("storeNew.jsp");
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
