package inventory.objects;




import java.util.Date;
public class TransactionObj {

    private int m_iId;
    private int m_iQuantity;
    private Date m_dDate;
    private int m_iType;
    private int m_iIdwarehouseproduct;

    public TransactionObj(int p_iId, int p_iQuantity, Date p_dDate, int p_iType, int p_iIdwarehouseproduct) {
       setId(p_iId);
       setQuantity(p_iQuantity);
       setDate(p_dDate);
       setType(p_iType);
       setIdwarehouseproduct(p_iIdwarehouseproduct);
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

    public int getType() {
        return m_iType;
    }

    private void setType(int p_iType) {
        m_iType = p_iType;
    }

    public int getIdwarehouseproduct() {
        return m_iIdwarehouseproduct;
    }

    private void setIdwarehouseproduct(int p_iIdwarehouseproduct) {
        m_iIdwarehouseproduct = p_iIdwarehouseproduct;
    }
    
    
}
