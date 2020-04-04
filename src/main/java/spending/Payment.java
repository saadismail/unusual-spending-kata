package spending;

public class Payment {


    public Category category;
    public double price;
    public String description;


    public Payment(String description, Category category, double amount) {
        this.description = description;
        this.category = category;
        this.price = amount;
    }



}
