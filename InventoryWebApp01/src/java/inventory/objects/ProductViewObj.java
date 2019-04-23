package inventory.objects;

public class ProductViewObj {
    
    private int m_iId;
    private String m_strCode;
    private String m_strDescription;
    private double m_dCost;
    private double m_dPrice;
    private String m_strCategory;
    private String m_strSupplier;

    public ProductViewObj(int p_iId, String p_strCode, String p_strDescription, double p_dCost, double p_dPrice, String p_strCategory, String p_strSupplier) {
        setId(p_iId);
        setCode(p_strCode);
        setDescription(p_strDescription);
        setCost(p_dCost);
        setPrice(p_dPrice);
        setCategory(p_strCategory);
        setSupplier(p_strSupplier);
    }

    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public String getCode() {
        return m_strCode;
    }

    private void setCode(String p_strCode) {
        m_strCode = p_strCode;
    }

    public String getDescription() {
        return m_strDescription;
    }

    private void setDescription(String p_strDescription) {
        m_strDescription = p_strDescription;
    }

    public double getCost() {
        return m_dCost;
    }

    private void setCost(double p_dCost) {
        m_dCost = p_dCost;
    }

    public double getPrice() {
        return m_dPrice;
    }

    private void setPrice(double p_dPrice) {
        m_dPrice = p_dPrice;
    }

    public String getCategory() {
        return m_strCategory;
    }

    private void setCategory(String p_strCategory) {
        m_strCategory = p_strCategory;
    }

    public String getSupplier() {
        return m_strSupplier;
    }

    private void setSupplier(String p_strSupplier) {
        m_strSupplier = p_strSupplier;
    }
    
}