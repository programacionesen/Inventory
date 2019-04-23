package inventory.logic;

import inventory.database.DatabaseX;
import inventory.objects.SupplierObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupplierLogic extends Logic {
    
    public int insertSupplierRows(String p_strName, String p_strContactName, String p_strTelephone) {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.supplier(id, name, contactname, telephone) VALUES(0,'" + p_strName 
                + "','"+ p_strContactName +"','"+ p_strTelephone +"')";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
        
    public ArrayList<SupplierObj> getAllSuppliers() {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.supplier";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<SupplierObj> CArray = null;
        
        if(CResult!=null) {
            
            int iId;
            String strName;
            String strContactName;
            String strTelephone;
            
            SupplierObj CTemp;
            CArray = new ArrayList<>();
            
            try {
                while(CResult.next()) {
                    
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    strContactName = CResult.getString("contactname");
                    strTelephone = CResult.getString("telephone");
                    
                    CTemp = new SupplierObj(iId, strName, strContactName, strTelephone);
                    CArray.add(CTemp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SupplierLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CArray;
    }

    public int deleteSupplierRows(int p_iId) {
        int iRows = deleteTableRows(p_iId, "supplier");
        return iRows;
    }

    public SupplierObj getSupplierById(int p_iId) {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.supplier where id=" + p_iId + " ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        SupplierObj CTemp = null;
        
        if(CResult!=null) {
            int iId;
            String strName;
            String strContactName;
            String strTelephone;
            
            try {
                while(CResult.next()) {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    strContactName = CResult.getString("contactname");
                    strTelephone = CResult.getString("telephone");
                    
                    CTemp = new SupplierObj(iId, strName, strContactName, strTelephone);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SupplierLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CTemp;
    }

    public int updateSupplierRows(int p_iId, String p_strName, String p_strContactName, String p_strTelephone) {
        DatabaseX database = getDatabase();
        String strSql = "update inventory.supplier set name = '" + p_strName 
                + "', contactname='"+ p_strContactName +"', telephone='"+ p_strTelephone +"' "
                + "where id = " + p_iId + " ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}