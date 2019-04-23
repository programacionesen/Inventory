package inventory.logic;

import inventory.database.DatabaseX;
import inventory.objects.ExpensesObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpensesLogic extends Logic {

    public ArrayList<ExpensesObj> getExpenses(int iYear, int iMonth, int iDay, int iYear2, int iMonth2, int iDay2) {
        
        DatabaseX database = getDatabase();
        String strSql = "SELECT SUM(inventory.transaction.quantity * inventory.product.cost) "
                + "AS expenses FROM inventory.transaction "
                + "INNER JOIN inventory.warehouse_product "
                + "ON inventory.transaction.idwarehouseproduct = inventory.warehouse_product.id "
                + "INNER JOIN inventory.product "
                + "ON inventory.warehouse_product.idproduct = inventory.product.id "
                + "WHERE inventory.transaction.date BETWEEN '" + iYear + "-" + iMonth + "-" + iDay
                +"' AND '" + iYear2 + "-" + iMonth2 + "-" + iDay2 + "' "
                + "AND type = 0";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<ExpensesObj> CArray = null;
        
        if(CResult!=null) {
            
            double dExpenses;
            
            ExpensesObj CTemp;
            CArray = new ArrayList<>();
            
            try {
                while(CResult.next()) {
                    
                    dExpenses = CResult.getDouble("expenses");
                    
                    CTemp = new ExpensesObj(dExpenses);
                    CArray.add(CTemp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CArray;
    }
    
}