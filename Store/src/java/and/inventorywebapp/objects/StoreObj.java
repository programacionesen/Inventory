
package and.inventorywebapp.objects;

public class StoreObj 
{
    private int m_iId;
    private String m_strName;
    private String m_strTelephone;
    private int m_iIdlocation;

    public StoreObj(int p_iId, String p_strName, String p_strTelephone ,int p_iIdlocation) 
    {
        setId(p_iId);
        setName(p_strName);
        setTelephone(p_strTelephone);
        setIdlocation(p_iIdlocation);
    }

    public int getId() 
    {
        return m_iId;
    }

    private void setId(int p_iId) 
    {
        m_iId = p_iId;
    }

    public String getName() 
    {
        return m_strName;
    }

    private void setName(String p_strName) 
    {
        m_strName = p_strName;
    }
        public String getTelephone() 
    {
        return m_strTelephone;
    }

    private void setTelephone(String p_strTelephone) 
    {
        m_strTelephone = p_strTelephone;
    }

    public int getIdlocation() 
    {
        return m_iIdlocation;
    }

    private void setIdlocation(int p_iIdlocation) 
    {
        m_iIdlocation = p_iIdlocation;
    }
    
}
