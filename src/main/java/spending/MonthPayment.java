package spending;

import java.util.ArrayList;
import java.util.List;

public class MonthPayment {
    List<Payment> monthlyPayment = new ArrayList<Payment>();

    public MonthPayment(List<Payment> payments) {
        this.monthlyPayment =  payments;
    }

    public void addPayment(Payment payment) {
        monthlyPayment.add(payment);
    }

    public List<Payment> getUserPayment(int userId) {
        return monthlyPayment;
    }

    public double getPaymentCategory(Category category) {
        double resultSum = 0;
        for (Payment payment : monthlyPayment) {
            if (category == payment.category) {
                resultSum += payment.price;
            }
        }
        return resultSum;
    }
}
