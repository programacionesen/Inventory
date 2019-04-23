package inventory.logic;

import inventory.database.DatabaseX;
import inventory.objects.WarehouseObj;
import inventory.objects.WarehouseViewObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WarehouseLogic extends Logic {
    
    public int insertWarehouseRows(String p_strName, int p_iIdStore) {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.warehouse(id, name, idstore) VALUES(0,'" + p_strName + "', " + p_iIdStore + ")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
        
    public ArrayList<WarehouseViewObj> getAllWarehouses() {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.warehouse_view ORDER BY inventory.warehouse_view.id;";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<WarehouseViewObj> CArray = null;
        
        if(CResult!=null) {
            
            int iId;
            String strName;
            String strStore;
            
            WarehouseViewObj CTemp;
            CArray = new ArrayList<>();
            
            try {
                while(CResult.next()) {
                    
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    strStore = CResult.getString("store");
                    
                    CTemp = new WarehouseViewObj(iId, strName, strStore);
                    CArray.add(CTemp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(WarehouseLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CArray;
    }

    public int deleteWarehouseRows(int p_iId) {
        int iRows = deleteTableRows(p_iId, "warehouse");
        return iRows;
    }

    public WarehouseObj getWarehouseById(int p_iId) {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.warehouse where id=" + p_iId + " ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        WarehouseObj CTemp = null;
        
        if(CResult!=null) {
            int iId;
            String strName;
            int iIdStore;
            
            try {
                while(CResult.next()) {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    iIdStore = CResult.getInt("idstore");
                    
                    CTemp = new WarehouseObj(iId, strName, iIdStore);
                }
            } catch (SQLException ex) {
                Logger.getLogger(WarehouseLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CTemp;
    }

    public int updateWarehouseRows(int p_iId, String p_strName, int p_iIdStore) {
        DatabaseX database = getDatabase();
        String strSql = "update inventory.warehouse set name = '" + p_strName + "', idstore = " + p_iIdStore + " "
                + "where id = " + p_iId + " ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}
