
package fatima.inventory.objects;

public class LocationObj {
    
    //variables de instancia: id, address, zipcode, coordinates, idcity
    private int m_iId;
    private String m_strAddress;
    private int m_iZipCode;
    private int m_iCoordinates;
    private int m_iIdCity;

    public LocationObj(int p_iId, String p_strAddress, int p_iZipCode, int p_iCoordinates, int p_iIdCity) {
        setId(p_iId);
        setAddress(p_strAddress);
        setZipCode(p_iZipCode);
        setCoordinates(p_iCoordinates);
        setIdCity(p_iIdCity);
    } 

    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public String getAddress() {
        return m_strAddress;
    }

    private void setAddress(String p_strAddress) {
        m_strAddress = p_strAddress;
    }

    public int getZipCode() {
        return m_iZipCode;
    }

    private void setZipCode(int p_iZipCode) {
        m_iZipCode = p_iZipCode;
    }

    public int getCoordinates() {
        return m_iCoordinates;
    }

    private void setCoordinates(int p_iCoordinates) {
        m_iCoordinates = p_iCoordinates;
    }

    public int getIdCity() {
        return m_iIdCity;
    }

    private void setIdCity(int p_iIdCity) {
        m_iIdCity = p_iIdCity;
    }
    
    
    
}
