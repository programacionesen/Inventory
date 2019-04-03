package inventory.logic;

import inventory.database.DatabaseX;

public class CategoryLogic extends Logic
{
    public boolean insertCategoryBool(String p_strName)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.category(id, name) VALUES(0, '" + p_strName + "');";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertCategoryRows(String p_strName)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.category(id, name) VALUES(0, '" + p_strName + "');";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}
