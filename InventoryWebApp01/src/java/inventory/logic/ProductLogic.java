package inventory.logic;

import inventory.database.DatabaseX;
import inventory.objects.ProductObj;
import inventory.objects.ProductViewObj;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductLogic extends Logic {
    
    public int insertProductRows(String p_strCode, String p_strDescription, double p_dCost, double p_dPrice, int p_iIdCategory, int p_iIdSupplier) {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.product(id, code, description, cost, price, idcategory, idsupplier) VALUES(0,'" 
                + p_strCode + "', '" + p_strDescription + "', " + p_dCost + ", " + p_dPrice 
                + ", " + p_iIdCategory + ", " + p_iIdSupplier + ")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
        
    public ArrayList<ProductViewObj> getAllProducts() {
        
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM inventory.product_view ORDER BY inventory.product_view.id;";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<ProductViewObj> CArray = null;
        
        if(CResult!=null) {
            int iId;
            String strCode;
            String strDescription;
            double dCost;
            double dPrice;
            String strCategory;
            String strSupplier;
            
            ProductViewObj CTemp;
            CArray = new ArrayList<>();
            
            try {
                while(CResult.next()) {
                    
                    iId = CResult.getInt("id");
                    strCode = CResult.getString("code");
                    strDescription = CResult.getString("description");
                    dCost = CResult.getDouble("cost");
                    dPrice = CResult.getDouble("price");
                    strCategory = CResult.getString("category");
                    strSupplier = CResult.getString("supplier");
                    
                    CTemp = new ProductViewObj(iId, strCode, strDescription, dCost, dPrice, strCategory, strSupplier);
                    CArray.add(CTemp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CArray;
    }
    
    
    
    

    public int deleteProductRows(int p_iId) {
        int iRows = deleteTableRows(p_iId, "product");
        return iRows;
    }
    
    
    
    
    

    public ProductObj getProductById(int p_iId) {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.product where id=" + p_iId + " ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ProductObj CTemp = null;
        
        if(CResult!=null) {
            int iId;
            String strCode;
            String strDescription;
            double dCost;
            double dPrice;
            int iIdCategory;
            int iIdSupplier;
            
            try {
                while(CResult.next()) {
                    iId = CResult.getInt("id");
                    strCode = CResult.getString("code");
                    strDescription = CResult.getString("description");
                    dCost = CResult.getDouble("cost");
                    dPrice = CResult.getDouble("price");
                    iIdCategory = CResult.getInt("idcategory");
                    iIdSupplier = CResult.getInt("idsupplier");
                    
                    CTemp = new ProductObj(iId, strCode, strDescription, dCost, dPrice, iIdCategory, iIdSupplier);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CTemp;
    }

    public int updateProductRows(int p_iId, String p_strCode, String p_strDescription, double p_dCost, double p_dPrice, int p_iIdCategory, int p_iIdSupplier) {
        DatabaseX database = getDatabase();
        String strSql = "update inventory.product set code = '" + p_strCode + "', description = '"
                + p_strDescription + "', cost = " + p_dCost + ", price = " + p_dPrice
                + ", idcategory = " + p_iIdCategory + ", idsupplier = " + p_iIdSupplier + " "
                + "where id = " + p_iId + " ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}