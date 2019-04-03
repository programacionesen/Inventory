package pao.inventory.objects;

public class WarehouseProductObj 
{
    private int m_iId;
    private int m_iStock;
    private int m_iIdProduct;
    private int m_iIdWarehouse;

    public WarehouseProductObj(int p_iId, int p_iStock, int p_iIdProduct, int p_iIdWarehouse) {
        setId(p_iId);
        setStock(p_iStock);
        setIdProduct(p_iIdProduct);
        setIdWarehouse(p_iIdWarehouse);
    }

    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public int getStock() {
        return m_iStock;
    }

    private void setStock(int p_iStock) {
        m_iStock = p_iStock;
    }

    public int getIdProduct() {
        return m_iIdProduct;
    }

    private void setIdProduct(int p_iIdProduct) {
        m_iIdProduct = p_iIdProduct;
    }

    public int getIdWarehouse() {
        return m_iIdWarehouse;
    }

    private void setIdWarehouse(int p_iIdWarehouse) {
        m_iIdWarehouse = p_iIdWarehouse;
    }

    
    
}
