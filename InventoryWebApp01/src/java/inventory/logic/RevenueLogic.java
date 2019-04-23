package inventory.logic;

import inventory.database.DatabaseX;
import inventory.objects.RevenueObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RevenueLogic extends Logic {

    public ArrayList<RevenueObj> getRevenue(int iYear, int iMonth, int iDay, int iYear2, int iMonth2, int iDay2) {
        
        DatabaseX database = getDatabase();
        String strSql = "SELECT SUM(inventory.transaction.quantity * inventory.product.price) "
                + "AS revenue FROM inventory.transaction "
                + "INNER JOIN inventory.warehouse_product "
                + "ON inventory.transaction.idwarehouseproduct = inventory.warehouse_product.id "
                + "INNER JOIN inventory.product "
                + "ON inventory.warehouse_product.idproduct = inventory.product.id "
                + "WHERE inventory.transaction.date BETWEEN '" + iYear + "-" + iMonth + "-" + iDay
                +"' AND '" + iYear2 + "-" + iMonth2 + "-" + iDay2 + "' "
                + "AND type = 1";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<RevenueObj> CArray = null;
        
        if(CResult!=null) {
            
            double dRevenue;
            
            RevenueObj CTemp;
            CArray = new ArrayList<>();
            
            try {
                while(CResult.next()) {
                    
                    dRevenue = CResult.getDouble("revenue");
                    
                    CTemp = new RevenueObj(dRevenue);
                    CArray.add(CTemp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CArray;
    }
    
}