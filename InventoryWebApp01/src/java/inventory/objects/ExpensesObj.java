package inventory.objects;

public class ExpensesObj {
    
    private double m_dExpenses;

    public ExpensesObj(double p_dExpenses) {
        setExpenses(p_dExpenses);
    }

    public double getExpenses() {
        return m_dExpenses;
    }

    private void setExpenses(double p_dExpenses) {
        m_dExpenses = p_dExpenses;
    }
    
}