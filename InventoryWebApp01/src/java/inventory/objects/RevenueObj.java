package inventory.objects;

public class RevenueObj {
    
    private double m_dRevenue;

    public RevenueObj(double p_dRevenue) {
        setRevenue(p_dRevenue);
    }

    public double getRevenue() {
        return m_dRevenue;
    }

    private void setRevenue(double p_dRevenue) {
        m_dRevenue = p_dRevenue;
    }
    
}