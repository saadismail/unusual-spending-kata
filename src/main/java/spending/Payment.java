package spending;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.amount, amount) == 0 &&
                Objects.equals(description, payment.description) &&
                category == payment.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, description, category);
    }
}
