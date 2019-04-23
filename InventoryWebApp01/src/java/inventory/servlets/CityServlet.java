package inventory.servlets;

import inventory.logic.CityLogic;
import inventory.objects.CityObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CityServlet", urlPatterns = {"/CityServlet"})
public class CityServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1")) {
                String strName = request.getParameter("name");
                String strIdCountry = request.getParameter("idcountry");
                int iIdCountry = Integer.parseInt(strIdCountry);
                        
                CityLogic CLogic = new CityLogic();
                int iRows = CLogic.insertCityRows(strName, iIdCountry);
                System.out.println("insert city rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2")) {
                CityLogic CLogic = new CityLogic();
                ArrayList<CityObj> CArray = CLogic.getAllCities();

                request.getSession().setAttribute("cities", CArray);
                response.sendRedirect("cityForm.jsp");
            }
            
            if(strFormId.equals("3")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                CityLogic CLogic = new CityLogic();
                int iRows = CLogic.deleteCityRows(iId);
                
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("4")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                CityLogic CLogic = new CityLogic();
                CityObj CCity = CLogic.getCityById(iId);
                
                request.getSession().setAttribute("city", CCity);
                response.sendRedirect("cityUpdateForm.jsp");
            } 
            
            if(strFormId.equals("5")) {
                String strId = request.getParameter("id");
                String strName = request.getParameter("name");
                String strIdCountry = request.getParameter("idcountry");
                int iId = Integer.parseInt(strId);
                int iIdCountry = Integer.parseInt(strIdCountry);
                
                CityLogic CLogic = new CityLogic();
                int iRows = CLogic.updateCityRows(iId, strName, iIdCountry);
                System.out.println("update city rows: " + iRows);
                
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
