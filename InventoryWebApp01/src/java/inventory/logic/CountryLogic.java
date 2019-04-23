package inventory.logic;

import inventory.database.DatabaseX;
import inventory.objects.CountryObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountryLogic extends Logic {
    
    public int insertCountryRows(String p_strName) {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.country(id, name) VALUES(0,'" + p_strName + "')";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
        
    public ArrayList<CountryObj> getAllCountries() {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.country";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<CountryObj> CArray = null;
        
        if(CResult!=null) {
            
            int iId;
            String strName;
            
            CountryObj CTemp;
            CArray = new ArrayList<>();
            
            try {
                while(CResult.next()) {
                    
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    
                    CTemp = new CountryObj(iId, strName);
                    CArray.add(CTemp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CountryLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CArray;
    }

    public int deleteCountryRows(int p_iId) {
        int iRows = deleteTableRows(p_iId, "country");
        return iRows;
    }

    public CountryObj getCountryById(int p_iId) {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.country where id=" + p_iId + " ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        CountryObj CTemp = null;
        
        if(CResult!=null) {
            int iId;
            String strName;
            
            try {
                while(CResult.next()) {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    
                    CTemp = new CountryObj(iId, strName);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CountryLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CTemp;
    }

    public int updateCountryRows(int p_iId, String p_strName) {
        DatabaseX database = getDatabase();
        String strSql = "update inventory.country set name = '" + p_strName + "' "
                + "where id = " + p_iId + " ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}
