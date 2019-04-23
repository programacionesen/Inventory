package inventory.objects;

public class StoreObj {
    
    private int m_iId;
    private String m_strName;
    private String m_strTelephone;
    private String m_strAddress;
    private String m_strZipCode;
    private String m_strCoordinates;
    private int m_iIdCity;

    public StoreObj(int p_iId, String p_strName, String p_strTelephone, String p_strAddress, String p_strZipCode, 
            String p_strCoordinates, int p_iIdCity) {
        setId(p_iId);
        setName(p_strName);
        setTelephone(p_strTelephone);
        setAddress(p_strAddress);
        setZipCode(p_strZipCode);
        setCoordinates(p_strCoordinates);
        setIdCity(p_iIdCity);
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

    public String getTelephone() {
        return m_strTelephone;
    }

    private void setTelephone(String p_strTelephone) {
        m_strTelephone = p_strTelephone;
    }

    public String getAddress() {
        return m_strAddress;
    }

    private void setAddress(String p_strAddress) {
        m_strAddress = p_strAddress;
    }

    public String getZipCode() {
        return m_strZipCode;
    }

    private void setZipCode(String p_strZipCode) {
        m_strZipCode = p_strZipCode;
    }

    public String getCoordinates() {
        return m_strCoordinates;
    }

    private void setCoordinates(String p_strCoordinates) {
        m_strCoordinates = p_strCoordinates;
    }

    public int getIdCity() {
        return m_iIdCity;
    }

    private void setIdCity(int p_iIdCity) {
        m_iIdCity = p_iIdCity;
    }
    
}