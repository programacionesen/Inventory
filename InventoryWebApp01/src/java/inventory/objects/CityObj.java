package inventory.objects;

public class CityObj {
    
    private int m_iId;
    private String m_strName;
    private int m_iIdCountry;
    
    public CityObj(int p_iId, String p_strName, int p_iIdCountry) {
        setId(p_iId);
        setName(p_strName);
        setIdCountry(p_iIdCountry);
    }

    public int getId() {
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
    
    public int getIdCountry() {
        return m_iIdCountry;
    }

    private void setIdCountry(int p_iIdCountry) {
        m_iIdCountry = p_iIdCountry;
    }

}