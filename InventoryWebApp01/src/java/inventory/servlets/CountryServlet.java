package inventory.servlets;

import inventory.logic.CountryLogic;
import inventory.objects.CountryObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CountryServlet", urlPatterns = {"/CountryServlet"})
public class CountryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1")) {
                String strName = request.getParameter("name");
                
                CountryLogic CLogic = new CountryLogic();
                int iRows = CLogic.insertCountryRows(strName);
                System.out.println("insert country rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2")) {
                CountryLogic CLogic = new CountryLogic();
                ArrayList<CountryObj> CArray = CLogic.getAllCountries();

                request.getSession().setAttribute("countries", CArray);
                response.sendRedirect("countryForm.jsp");
            }
            
            if(strFormId.equals("3")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                CountryLogic CLogic = new CountryLogic();
                int iRows = CLogic.deleteCountryRows(iId);
                
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("4")) {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                CountryLogic CLogic = new CountryLogic();
                CountryObj CCountry = CLogic.getCountryById(iId);
                
                request.getSession().setAttribute("country", CCountry);
                response.sendRedirect("countryUpdateForm.jsp");
            } 
            
            if(strFormId.equals("5")) {
                String strId = request.getParameter("id");
                String strName = request.getParameter("name");
                int iId = Integer.parseInt(strId);
                
                CountryLogic CLogic = new CountryLogic();
                int iRows = CLogic.updateCountryRows(iId, strName);
                System.out.println("update country rows: " + iRows);
                
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
