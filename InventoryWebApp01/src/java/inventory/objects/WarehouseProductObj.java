package inventory.objects;

public class WarehouseProductObj {
    
    private int m_iId;
    private int m_iStock;
    private int m_iIdWarehouse;
    private int m_iIdProduct;

    public WarehouseProductObj(int p_iId, int p_iStock, int p_iIdWarehouse, int p_iIdProduct) {
        setId(p_iId);
        setStock(p_iStock);
        setIdWarehouse(p_iIdWarehouse);
        setIdProduct(p_iIdProduct);
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

    public int getIdWarehouse() {
        return m_iIdWarehouse;
    }

    private void setIdWarehouse(int p_iIdWarehouse) {
        m_iIdWarehouse = p_iIdWarehouse;
    }

    public int getIdProduct() {
        return m_iIdProduct;
    }

    private void setIdProduct(int p_iIdProduct) {
        m_iIdProduct = p_iIdProduct;
    }
    
}
