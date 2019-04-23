package inventory.logic;

import inventory.database.DatabaseX;
import inventory.objects.CategoryObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryLogic extends Logic {
    
    public int insertCategoryRows(String p_strName) {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.category(id, name) VALUES(0,'" + p_strName + "')";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
        
    public ArrayList<CategoryObj> getAllCategories() {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.category";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<CategoryObj> CArray = null;
        
        if(CResult!=null) {
            
            int iId;
            String strName;
            
            CategoryObj CTemp;
            CArray = new ArrayList<>();
            
            try {
                while(CResult.next()) {
                    
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    
                    CTemp = new CategoryObj(iId, strName);
                    CArray.add(CTemp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoryLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CArray;
    }

    public int deleteCategoryRows(int p_iId) {
        int iRows = deleteTableRows(p_iId, "category");
        return iRows;
    }

    public CategoryObj getCategoryById(int p_iId) {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.category where id=" + p_iId + " ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        CategoryObj CTemp = null;
        
        if(CResult!=null) {
            int iId;
            String strName;
            
            try {
                while(CResult.next()) {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    
                    CTemp = new CategoryObj(iId, strName);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoryLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CTemp;
    }

    public int updateCategoryRows(int p_iId, String p_strName) {
        DatabaseX database = getDatabase();
        String strSql = "update inventory.category set name = '" + p_strName + "' "
                + "where id = " + p_iId + " ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}
