package fatima.inventory.logic;

import fatima.inventory.database.DatabaseX;
//id, quantity, date, type, idwarehouseproduct
public class TransactionLogic extends Logic 
{
    public int insertTransactionRows(int p_iQuanity, String p_strDate, String p_strType, int p_iIdWarehouseproduct) 
    {   
      
      DatabaseX database = getDatabase();
      String strSql = "INSERT INTO inventory.transaction(id, quantity, date, type, idwarehouseproduct) "
              + "VALUES(0, "+p_iQuanity+", "+p_strDate+", "+p_strType+", "+p_iIdWarehouseproduct+");";
                //sysout(Strsql);
      
      int iRows = database.executeNonQueryRows(strSql);
      return iRows;  
    } 
    
}
