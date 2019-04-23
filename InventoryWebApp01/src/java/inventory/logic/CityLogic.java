package inventory.logic;

import inventory.database.DatabaseX;
import inventory.objects.CityObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CityLogic extends Logic {
    
    public int insertCityRows(String p_strName, int p_iIdCountry) {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.city(id, name, idcountry) VALUES(0,'" + p_strName + "', " + p_iIdCountry + ")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
        
    public ArrayList<CityObj> getAllCities() {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.city";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<CityObj> CArray = null;
        
        if(CResult!=null) {
            
            int iId;
            String strName;
            int iIdCountry;
            
            CityObj CTemp;
            CArray = new ArrayList<>();
            
            try {
                while(CResult.next()) {
                    
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    iIdCountry = CResult.getInt("idcountry");
                    
                    CTemp = new CityObj(iId, strName, iIdCountry);
                    CArray.add(CTemp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CArray;
    }

    public int deleteCityRows(int p_iId) {
        int iRows = deleteTableRows(p_iId, "city");
        return iRows;
    }

    public CityObj getCityById(int p_iId) {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.city where id=" + p_iId + " ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        CityObj CTemp = null;
        
        if(CResult!=null) {
            int iId;
            String strName;
            int iIdCountry;
            
            try {
                while(CResult.next()) {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    iIdCountry = CResult.getInt("idcountry");
                    
                    CTemp = new CityObj(iId, strName, iIdCountry);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CTemp;
    }

    public int updateCityRows(int p_iId, String p_strName, int p_iIdCountry) {
        DatabaseX database = getDatabase();
        String strSql = "update inventory.city set name = '" + p_strName + "', idcountry = " + p_iIdCountry + " "
                + "where id = " + p_iId + " ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}
