package inventory.logic;

import inventory.database.DatabaseX;
import inventory.objects.WarehouseProductObj;
import inventory.objects.WarehouseProductViewObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WarehouseProductLogic extends Logic {
    
    public int insertWarehouseProductRows(int p_iStock, int p_iIdWarehouse, int p_iIdProduct) {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.warehouse_product(id, stock, idwarehouse, idproduct) VALUES(0," 
                + p_iStock + ", " + p_iIdWarehouse + ", " + p_iIdProduct + ")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
        
    public ArrayList<WarehouseProductViewObj> getAllWarehouseProducts() {
        
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM inventory.warehouseproduct_view ORDER BY inventory.warehouseproduct_view.id;";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<WarehouseProductViewObj> CArray = null;
        
        if(CResult!=null) {
            
            int iId;
            int iStock;
            String strWarehouse;
            String strProduct;
            
            WarehouseProductViewObj CTemp;
            CArray = new ArrayList<>();
            
            try {
                while(CResult.next()) {
                    
                    iId = CResult.getInt("id");
                    iStock = CResult.getInt("stock");
                    strWarehouse = CResult.getString("warehouse");
                    strProduct = CResult.getString("product");
                    
                    CTemp = new WarehouseProductViewObj(iId, iStock, strWarehouse, strProduct);
                    CArray.add(CTemp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(WarehouseProductLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CArray;
    }

    public int deleteWarehouseProductRows(int p_iId) {
        int iRows = deleteTableRows(p_iId, "warehouse_product");
        return iRows;
    }

    public WarehouseProductObj getWarehouseProductById(int p_iId) {
        
        DatabaseX database = getDatabase();
        String strSql = "select * from inventory.warehouse_product where id=" + p_iId + " ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        WarehouseProductObj CTemp = null;
        
        if(CResult!=null) {
            int iId;
            int iStock;
            int iIdWarehouse;
            int iIdProduct;
            
            try {
                while(CResult.next()) {
                    iId = CResult.getInt("id");
                    iStock = CResult.getInt("stock");
                    iIdWarehouse = CResult.getInt("idwarehouse");
                    iIdProduct = CResult.getInt("idproduct");
                    
                    CTemp = new WarehouseProductObj(iId, iStock, iIdWarehouse, iIdProduct);
                }
            } catch (SQLException ex) {
                Logger.getLogger(WarehouseProductLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CTemp;
    }

    public int updateWarehouseProductRows(int p_iId, int p_iStock, int p_iIdWarehouse, int p_iIdProduct) {
        DatabaseX database = getDatabase();
        String strSql = "update inventory.warehouse_product set stock = " + p_iStock 
                + ", idwarehouse = " + p_iIdWarehouse + ", idproduct = " + p_iIdProduct + " "
                + "where id = " + p_iId + " ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    public WarehouseProductObj getWarehouseProduct(int p_iIdWarehouse, int p_iIdProduct) {
        
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM inventory.warehouse_product "
        + "WHERE inventory.warehouse_product.idwarehouse = " + p_iIdWarehouse + " "
        + "AND inventory.warehouse_product.idproduct = " + p_iIdProduct;
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        WarehouseProductObj CTemp = null;
        
        if(CResult!=null) {
            int iId;
            int iStock;
            int iIdWarehouse;
            int iIdProduct;
            
            try {
                while(CResult.next()) {
                    iId = CResult.getInt("id");
                    iStock = CResult.getInt("stock");
                    iIdWarehouse = CResult.getInt("idwarehouse");
                    iIdProduct = CResult.getInt("idproduct");
                    
                    CTemp = new WarehouseProductObj(iId, iStock, iIdWarehouse, iIdProduct);
                }
            } catch (SQLException ex) {
                Logger.getLogger(WarehouseProductLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return CTemp;
    }
}
