package inventory.objects;

public class ProductObj {
    
    private int m_iId;
    private String m_strCode;
    private String m_strDescription;
    private double m_dCost;
    private double m_dPrice;
    private int m_iIdCategory;
    private int m_iIdSupplier;

    public ProductObj(int p_iId, String p_strCode, String p_strDescription, double p_dCost, double p_dPrice, int p_iIdCategory, int p_iIdSupplier) {
        setId(p_iId);
        setCode(p_strCode);
        setDescription(p_strDescription);
        setCost(p_dCost);
        setPrice(p_dPrice);
        setIdCategory(p_iIdCategory);
        setIdSupplier(p_iIdSupplier);
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

    public int getIdCategory() {
        return m_iIdCategory;
    }

    private void setIdCategory(int p_iIdCategory) {
        m_iIdCategory = p_iIdCategory;
    }

    public int getIdSupplier() {
        return m_iIdSupplier;
    }

    private void setIdSupplier(int p_iIdSupplier) {
        m_iIdSupplier = p_iIdSupplier;
    }
    
}
