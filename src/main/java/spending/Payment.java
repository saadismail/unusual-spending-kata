package spending;

public class Payment {
    double price;
    String description;
    Category category;


    public Payment(double price, String description, Category category) {
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }
}
