package pao.inventory.logic;

import pao.inventory.database.DatabaseX;

public class WarehouseProductLogic extends Logic
{
    public boolean insertWarehouseProductBool(int p_iStock, int p_iIdProduct, int p_iIdWarehouse)
    {
        //INSERT INTO inventory.warehouseproduct(id,stock,idproduct, idwarehouse) VALUES(0,100,2,3);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.warehouseproduct(id,stock,idproduct,idwarehouse) "
                + "VALUES(0,'"+p_iStock+"',"+p_iIdProduct+","+p_iIdWarehouse+")";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertWarehouseProductRows(int p_iStock, int p_iIdProduct, int p_iIdWarehouse)
    {
        //INSERT INTO inventory.warehouseproduct(id,stock,idproduct, idwarehouse) VALUES(0,100,2,3);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO inventory.warehouseproduct(id,stock,idproduct,idwarehouse) "
                + "VALUES(0,'"+p_iStock+"',"+p_iIdProduct+","+p_iIdWarehouse+")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}
