package inventory.objects;

public class WarehouseObj 
{
    private int m_iId;
    private String m_strName;
    private int m_iIdStore;

    public WarehouseObj(int p_iId, String p_strName, int p_iIdStore) 
    {
        setId(p_iId);
        setName(p_strName);
        setIdStore(p_iIdStore);
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
    
     public int getIdStore() 
    {
        return m_iIdStore;
    }

    private void setIdStore(int p_iIdStore) 
    {
        m_iIdStore = p_iIdStore;
    }
}
