package inventory.logic;

import inventory.database.DatabaseX;
import inventory.objects.TransactionObj;
import inventory.objects.TransactionViewObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionLogic extends Logic {
    
   public int insertTransactionRows(int p_iQuantity, Date p_dDate, int p_iType, int p_iIdwarehouseproduct)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.transaction(id,quantity,date,type,idwarehouseproduct) "
                + "VALUES(0,"+p_iQuantity+",'"+p_dDate+"',"+p_iType+","+p_iIdwarehouseproduct+")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
        
    public ArrayList<TransactionViewObj> getAllTransactions() {
        
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM inventory.transaction_view ORDER BY inventory.transaction_view.id;";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<TransactionViewObj> CArray = null;
        
        if(CResult!=null) {
            
            int iId;
            int iQuantity;
            Date dDate;
            int iType;
            String strWarehouse;
            String strProduct;
            
            TransactionViewObj CTemp;
            CArray = new ArrayList<>();
            
            try {
                while(CResult.next()) {
                    
                    iId = CResult.getInt("id");
                    iQuantity = CResult.getInt("quantity");
                    dDate = CResult.getDate("date");
                    iType = CResult.getInt("type");
                    strWarehouse = CResult.getString("warehouse");
                    strProduct = CResult.getString("product");
                    
                    if(iType == 0) {
                        String strType = "Purchase";
                        
                        CTemp = new TransactionViewObj(iId, iQuantity, dDate, strType, strWarehouse, strProduct);
                        CArray.add(CTemp);
                    } else if(iType == 1) {
                        String strType = "Sale";
                        
                        CTemp = new TransactionViewObj(iId, iQuantity, dDate, strType, strWarehouse, strProduct);
                        CArray.add(CTemp);
                    } else {
                        String strType = "Unknown";
                        
                        CTemp = new TransactionViewObj(iId, iQuantity, dDate, strType, strWarehouse, strProduct);
                        CArray.add(CTemp);
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(TransactionLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CArray;
    }

    public int deleteTransactionRows(int p_iId) {
        int iRows = deleteTableRows(p_iId, "transaction");
        return iRows;
    }

    public TransactionObj getTransactionById(int p_iId) {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.transaction where id=" + p_iId + " ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        TransactionObj CTemp = null;
        
        if(CResult!=null) {
            int iId;
            int iQuantity;
            Date dDate;
            int iType;
            int iIdWarehouseProduct;
            
            try {
                while(CResult.next()) {
                    iId = CResult.getInt("id");
                    iQuantity = CResult.getInt("quantity");
                    dDate = CResult.getDate("date");
                    iType = CResult.getInt("type");
                    iIdWarehouseProduct = CResult.getInt("idwarehouseproduct");
                    
                    CTemp = new TransactionObj(iId, iQuantity, dDate, iType, iIdWarehouseProduct);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TransactionLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CTemp;
    }

    public int updateTransactionRows(int p_iId, int p_iQuantity, Date p_dDate, int p_iType, int p_iIdWarehouseProduct) {
        DatabaseX database = getDatabase();
        String strSql = "update inventory.transaction set quantity = " + p_iQuantity 
                + ", date = '" + p_dDate + "', type = " + p_iType + ", idwarehouseproduct = " + p_iIdWarehouseProduct + " "
                + "where id = " + p_iId + " ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}
