package inventory.logic;

import inventory.database.DatabaseX;

public class WarehouseLogic extends Logic
{
    public boolean insertWarehouseBool(String p_strName, int p_iIdStore)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.warehouse(id, name, idstore) VALUES(0, '" + p_strName + "', " + p_iIdStore + ");";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertWarehouseRows(String p_strName, int p_iIdStore)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.warehouse(id, name, idstore) VALUES(0, '" + p_strName + "', " + p_iIdStore + ");";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}