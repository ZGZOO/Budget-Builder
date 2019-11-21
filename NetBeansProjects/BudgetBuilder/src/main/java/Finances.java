public class Finances {
    private String category;
    private double amount;

    public Finances(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Finances{" +
                "category='" + category + '\'' +
                ", amount=" + amount +
                '}';
    }
}