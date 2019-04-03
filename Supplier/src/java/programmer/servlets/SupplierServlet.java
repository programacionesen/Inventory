package programmer.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import programmer.objects.SupplierQuery;
import programmer.objects.Query;
import programmer.pojos.SupplierObj;

@WebServlet(name = "SupplierServlet", urlPatterns = {"/SupplierServlet"})
public class SupplierServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        //aca vamos a trabajar
        String strFormId = request.getParameter("formid");
        
        // <editor-fold defaultstate="collapsed" desc="formid 1 - New Supplier">
        if(strFormId.equals("1"))
        {
           
            String strName = request.getParameter("name");
            String strContactName = request.getParameter("contactname");
            String strTelephone = request.getParameter("telephone");
            
            Connection con = createConnection();
            String strSql = "INSERT INTO inventariodb.supplier"
                    + "(id,name,contactname,telephone)"
                    + "VALUES(0,'"+strName+"','"+strContactName+"','"+strTelephone+"');";
            int iRows = executeNonQueryInt(strSql,con);
             
            request.getSession().setAttribute("rows", iRows);
            response.sendRedirect("SupplierNewResponse.jsp");
            
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="formid 2 - Supplier Form Table">
          if(strFormId.equals("2"))
        {
            
            Connection con = createConnection();
            String strSql = "SELECT * FROM inventariodb.supplier;";
            SupplierQuery CQuery = new  SupplierQuery(strSql);
            ArrayList< SupplierObj> arreglo = executeQueryResult(CQuery, con);
            
            request.getSession().setAttribute("arreglo", arreglo);
            response.sendRedirect("SupplierForm.jsp");
            
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="formid 3 - delete supplier">
        if(strFormId.equals("3"))
        
        {
            
            //DELETE FROM inventariodb.supplier WHERE id=1;
            String strId = request.getParameter("id");
            
            String strSql = "DELETE FROM inventariodb.supplier WHERE id="+strId+";";
            Connection con = createConnection();
            int iRows = executeNonQueryInt(strSql, con);
            
            request.getSession().setAttribute("rows", iRows);
            response.sendRedirect("SupplierDeleteResponse.jsp");
            
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="formid 4 - update supplier part 1">        
        if(strFormId.equals("4"))
        {
            
            String strId = request.getParameter("id");
            
            Connection con = createConnection();
            String strSql = "SELECT * FROM inventariodb.supplier"
                    + "where id="+strId+";";
             SupplierQuery CQuery = new  SupplierQuery(strSql);
            ArrayList< SupplierObj> arreglo = executeQueryResult(CQuery, con);
            
            request.getSession().setAttribute("arreglo", arreglo);
            response.sendRedirect("SupplierUpdateData.jsp");
            
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="formid 5 - update supplier part 2">        
        if(strFormId.equals("5"))
        {
            
        
           
            String strId = request.getParameter("id");
            String strName = request.getParameter("name");
            String strContactName = request.getParameter("contactname");
            String strTelephone = request.getParameter("telephone");
            
            Connection con = createConnection();
            String strSql = "UPDATE inventariodb.supplier "
                    + "SET name = '"+strName+"',"
                    + "contactname = '"+strContactName+"',"
                    + "telephone = '"+strTelephone+"',"
                    + "WHERE id = "+strId+";";
            int iRows = executeNonQueryInt(strSql,con);
            
            request.getSession().setAttribute("rows", iRows);
            response.sendRedirect("SupplierUpdateResponse.jsp");
            
            
            
        }
        // </editor-fold>        
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

    // <editor-fold defaultstate="collapsed" desc="Database Methods">
    private Connection createConnection() 
    {
        String strDriver = "com.mysql.cj.jdbc.Driver";
        String strUrl = "jdbc:mysql://localhost:3306/sakila"
                + "?autoReconnect=true"
                + "&useSSL=false"
                + "&useUnicode=true"
                + "&useJDBCCompliantTimezoneShift=true"
                + "&useLegacyDatetimeCode=false"
                + "&serverTimezone=UTC";
        String strUser = "root";
        String strPassword = "12345";
        Connection con = null;
        
        try 
        {
            Class.forName(strDriver);
            con = 
                    DriverManager.getConnection(strUrl, strUser, strPassword);
            
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            Logger.getLogger(SupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }

    private int executeNonQueryInt(String p_strSql, Connection p_CConnection) 
    {
        int iRows = 0;
        try 
        {
            if(!p_CConnection.isClosed())
            {
                try (Statement st = p_CConnection.createStatement()) 
                {
                    iRows = st.executeUpdate(p_strSql);
                    p_CConnection.close();
                }
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iRows;
    }

    private ArrayList executeQueryResult(Query p_CQuery, 
            Connection p_CConnection) 
    {
        ArrayList arreglo = null;
        try 
        {
            if(!p_CConnection.isClosed())
            {
                Statement st = p_CConnection.createStatement();
                ResultSet result = st.executeQuery(p_CQuery.getSql());
                arreglo = p_CQuery.createArrayList(result);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arreglo;
    }
    // </editor-fold>    
}
