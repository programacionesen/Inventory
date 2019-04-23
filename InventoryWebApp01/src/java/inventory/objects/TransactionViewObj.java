package inventory.objects;



import java.util.Date;

public class TransactionViewObj {

    private int m_iId;
    private int m_iQuantity;
    private Date m_dDate;
    private String m_strType;
    private String m_strWarehouse;
    private String m_strProduct;
    
    

    public TransactionViewObj(int p_iId, int p_iQuantity, Date p_dDate, String p_strType, String p_strWarehouse, String p_strProduct) {
       setId(p_iId);
       setQuantity(p_iQuantity);
       setDate(p_dDate);
       setType(p_strType);
       setWarehouse(p_strWarehouse);
       setProduct(p_strProduct);
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

    public Date getDate() {
        return m_dDate;
    }

    private void setDate(Date p_dDate) {
        m_dDate = p_dDate;
    }

    public String getType() {
        return m_strType;
    }

    private void setType(String p_strType) {
        m_strType = p_strType;
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
