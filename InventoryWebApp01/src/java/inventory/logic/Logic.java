package inventory.logic;

import inventory.database.DatabaseX;

public class Logic {
    
    private DatabaseX m_CDatabase;

    public Logic() {
        setDatabase(createDatabase());
    }

    public DatabaseX getDatabase() {
        return m_CDatabase;
    }

    private void setDatabase(DatabaseX p_CDatabase) {
        m_CDatabase = p_CDatabase;
    }

    private DatabaseX createDatabase() {
        DatabaseX database = getDatabase();
        
        if(database == null) {
            database = new DatabaseX();
        } return database;
    } 
    
    public int deleteTableRows(int p_iId, String p_strTableName) {
        DatabaseX database = getDatabase();
        String strSql = "delete from inventory." + p_strTableName + " where id=" + p_iId + " ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}