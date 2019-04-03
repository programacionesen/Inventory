package programmer.pojos;


public class SupplierObj 
{
    private int m_iId;
    private String m_strName;
    private String m_strContactName;
    private String m_strTelephone;

    public SupplierObj(int p_iId, String p_strName, String p_strContactName, String p_strTelephone) 
    {
        setId(p_iId);
        setName(p_strName);
        setContactName(p_strContactName);
        setTelephone(p_strTelephone);
    }
    
    

    public int getId() 
    {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public String getName() {
        return m_strName;
    }

    private void setName(String p_strName) {
        m_strName = p_strName;
    }

    public String getContactName() {
        return m_strContactName;
    }

    private void setContactName(String p_strContactName) {
        m_strContactName = p_strContactName;
    }

    public String getTelephone() {
        return m_strTelephone;
    }

    private void setTelephone(String p_strTelephone) {
        m_strTelephone = p_strTelephone;
    }

    @Override
    public String toString() {
        return "SupplierObj{" + "m_iId=" + m_iId + ", m_strName=" + m_strName + ", m_strContactName=" + m_strContactName + ", m_strTelephone=" + m_strTelephone + '}';
    }
    
    
}
