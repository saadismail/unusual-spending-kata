package spending;

public class Payment {
    double amount;
    String description;
    Category category;


    public Payment(double amount, String description, Category category) {
        this.amount = amount;
        this.description = description;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }
}
