
package fatima.inventory.objects;


public class TransactionObj {
    
    //id, quantity, date, type, idwarehouseproduct
    private int m_iId;
    private int m_iQuantity;
    private String m_strDate;
    private String m_strType;
    private int m_iIdWarehouseProduct;

    public TransactionObj(int p_iId, int p_iQuantity, String p_strDate, String p_strType, int p_iIdWarehouseProduct) {
        setId(p_iId);
        setQuantity(p_iQuantity);
        setDate(p_strDate);
        setType(p_strType);
        setIdWarehouseProduct(p_iIdWarehouseProduct);
    }
    
    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public int getQuantity() {
        return m_iQuantity;
    }

    private void setQuantity(int p_iQuantity) {
        m_iQuantity = p_iQuantity;
    }

    public String getDate() {
        return m_strDate;
    }

    private void setDate(String p_strDate) {
        m_strDate = p_strDate;
    }

    public String getType() {
        return m_strType;
    }

    private void setType(String p_strType) {
        m_strType = p_strType;
    }

    public int getIdWarehouseProduct() {
        return m_iIdWarehouseProduct;
    }

    private void setIdWarehouseProduct(int p_iIdWarehouseProduct) {
        m_iIdWarehouseProduct = p_iIdWarehouseProduct;
    }   
}
