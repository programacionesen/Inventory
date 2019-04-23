package inventory.logic;

import inventory.database.DatabaseX;
import inventory.objects.StoreObj;
import inventory.objects.StoreViewObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StoreLogic extends Logic {
    
    public int insertStoreRows(String p_strName, String p_strTelephone, String p_strAddress, String p_strZipCode,
            String p_strCoordinates, int p_iIdCity) {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.store(id, name, telephone, address, zipcode, coordinates, idcity) VALUES(0,'" 
                + p_strName + "', '" + p_strTelephone + "', '" + p_strAddress + "', '" + p_strZipCode + "', '"
                + p_strCoordinates + "', " + p_iIdCity + ")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
        
    public ArrayList<StoreViewObj> getAllStores() {
        
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM inventory.store_view ORDER BY inventory.store_view.id;";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<StoreViewObj> CArray = null;
        
        if(CResult!=null) {
            
            int iId;
            String strName;
            String strTelephone;
            String strAddress;
            String strZipCode;
            String strCoordinates;
            String strCity;
            String strCountry;
            
            StoreViewObj CTemp;
            CArray = new ArrayList<>();
            
            try {
                while(CResult.next()) {
                    
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    strTelephone = CResult.getString("telephone");
                    strAddress = CResult.getString("address");
                    strZipCode = CResult.getString("zipcode");
                    strCoordinates = CResult.getString("coordinates");
                    strCity = CResult.getString("city");
                    strCountry = CResult.getString("country");
                    
                    CTemp = new StoreViewObj(iId, strName, strTelephone, strAddress, strZipCode, strCoordinates, 
                            strCity, strCountry);
                    CArray.add(CTemp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StoreLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CArray;
    }

    public int deleteStoreRows(int p_iId) {
        int iRows = deleteTableRows(p_iId, "store");
        return iRows;
    }

    public StoreObj getStoreById(int p_iId) {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.store where id=" + p_iId + " ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        StoreObj CTemp = null;
        
        if(CResult!=null) {
            int iId;
            String strName;
            String strTelephone;
            String strAddress;
            String strZipCode;
            String strCoordinates;
            int iIdCity;
            
            try {
                while(CResult.next()) {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    strTelephone = CResult.getString("telephone");
                    strAddress = CResult.getString("address");
                    strZipCode = CResult.getString("zipcode");
                    strCoordinates = CResult.getString("coordinates");
                    iIdCity = CResult.getInt("idcity");
                    
                    CTemp = new StoreObj(iId, strName, strTelephone, strAddress, strZipCode, strCoordinates, iIdCity);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StoreLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CTemp;
    }

    public int updateStoreRows(int p_iId, String p_strName, String p_strTelephone, String p_strAddress, String p_strZipCode,
            String p_strCoordinates, int p_iIdCity) {
        DatabaseX database = getDatabase();
        String strSql = "update inventory.store set name = '" 
                + p_strName + "', telephone = '" + p_strTelephone + "', address = '" + p_strAddress + "',"
                + " zipcode = '" + p_strZipCode + "', coordinates = '" + p_strCoordinates + "', idcity = " + p_iIdCity + " "
                + "where id = " + p_iId + " ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}
