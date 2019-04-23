package inventory.objects;

public class WarehouseProductViewObj {
    
    private int m_iId;
    private int m_iStock;
    private String m_strWarehouse;
    private String m_strProduct;

    public WarehouseProductViewObj(int p_iId, int p_iStock, String p_strWarehouse, String p_strProduct) {
        setId(p_iId);
        setStock(p_iStock);
        setWarehouse(p_strWarehouse);
        setProduct(p_strProduct);
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

    public String getWarehouse() {
        return m_strWarehouse;
    }

    private void setWarehouse(String p_strWarehouse) {
        m_strWarehouse = p_strWarehouse;
    }

    public String getProduct() {
        return m_strProduct;
    }

    private void setProduct(String p_strProduct) {
        m_strProduct = p_strProduct;
    }
    
}
