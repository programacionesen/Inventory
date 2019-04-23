package inventory.servlets;

import inventory.logic.RevenueLogic;
import inventory.objects.RevenueObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RevenueServlet", urlPatterns = {"/RevenueServlet"})
public class RevenueServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1")) {
                String strYear = request.getParameter("year");
                String strMonth = request.getParameter("month");
                String strDay = request.getParameter("day");
                String strYear2 = request.getParameter("year2");
                String strMonth2 = request.getParameter("month2");
                String strDay2 = request.getParameter("day2");
                int iYear = Integer.parseInt(strYear);
                int iMonth = Integer.parseInt(strMonth);
                int iDay = Integer.parseInt(strDay);
                int iYear2 = Integer.parseInt(strYear2);
                int iMonth2 = Integer.parseInt(strMonth2);
                int iDay2 = Integer.parseInt(strDay2);
                
                RevenueLogic CLogic = new RevenueLogic();
                ArrayList<RevenueObj> CArray = CLogic.getRevenue(iYear, iMonth, iDay, iYear2, iMonth2, iDay2);

                request.getSession().setAttribute("revenue", CArray);
                response.sendRedirect("revenueForm.jsp");
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
