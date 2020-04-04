package spending;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectUnusualSpending {
    public static List<Payment> detect(List<Payment> lastMonthPayments, List<Payment> currentMonthPayments) {
        Map<Category, Double> categoryLastMonthAmount = new HashMap<Category, Double>();
        Map<Category, Double> categoryCurrentMonthAmount = new HashMap<Category, Double>();

        // TODO: These loops can be broken down into pure data processing functions

        for (Payment payment : lastMonthPayments) {
            Double amountInMap = categoryLastMonthAmount.getOrDefault(payment.getCategory(), 0.0);
            categoryLastMonthAmount.put(payment.getCategory(), amountInMap + payment.getAmount());
        }

        for (Payment payment : currentMonthPayments) {
            Double amountInMap = categoryCurrentMonthAmount.getOrDefault(payment.getCategory(), 0.0);
            categoryCurrentMonthAmount.put(payment.getCategory(), amountInMap + payment.getAmount());
        }

        List<Payment> unusualPayments = new ArrayList<>();

        for (Map.Entry<Category, Double> entry : categoryCurrentMonthAmount.entrySet()) {
            Double lastMonthCategoryAmount = categoryLastMonthAmount.getOrDefault(entry.getKey(), 0.0);
            Double currentMonthCategoryAmount = entry.getValue();

            if (currentMonthCategoryAmount >= 1.5 * lastMonthCategoryAmount) {
                unusualPayments.add(new Payment(currentMonthCategoryAmount, "Total", entry.getKey()));
            }
        }

        return unusualPayments;
    }
}
