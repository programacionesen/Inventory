package and.inventorywebapp.logic;

import and.inventorywebapp.database.DatabaseX;
import and.inventorywebapp.objects.StoreObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StoreLogic extends Logic
{
    public boolean insertStoreBool(String p_strName, String p_strTelephone, int p_iIdlocation)
    {
        //INSERT INTO inventory.store(id,name,telephone,idlocation)VALUES(0,'Alejandro','(503)7571-5294',0);

        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.store(id,name,telephone,idlocation) "
                + "VALUES(0,'"+p_strName+"','"+p_strTelephone+"', 0)";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertStoreRows(String p_strName, String p_strTelephone, int p_iIdlocation )
    {
        //INSERT INTO inventory.store(id,name,telephone,idlocation)VALUES(0,'Alejandro','(503)7571-5294',0);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.store(id,name,telephone,idlocation) "
                + "VALUES(0,'"+p_strName+"','"+p_strTelephone+"', 0)";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public ArrayList<StoreObj> getAllStore() 
    {
        //SELECT * FROM inventory.store;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM inventory.store; ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<StoreObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strTelephone;
            int iIdlocation;
            
            StoreObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    strTelephone = CResult.getString("telephone");
                    iIdlocation = CResult.getInt("idlocation");
                    
                    CTemp = new StoreObj(iId, strName, strTelephone, iIdlocation);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(StoreLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteTableRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId,"store");
        return iRows;
    }

    public StoreObj getStoreById(int p_iId) 
    {
        //SELECT * FROM inventory.store;
        DatabaseX database = getDatabase();
        String strSql = "select * from travelsys.client where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        StoreObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strTelephone;
            int iIdlocation;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    strTelephone = CResult.getString("telephone");
                    iIdlocation = CResult.getInt("idlocation");
                    
                    CTemp = new StoreObj(iId, strName, strTelephone, iIdlocation);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(StoreLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }
}