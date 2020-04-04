package spending;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DetectUnusualSpending {

    public static final double THRESHOLD = 1.5;

    public static List<Payment> detect(List<Payment> lastMonthPayments, List<Payment> currentMonthPayments) {
        Map<Category, Double> categoryLastMonthAmount = getGroupedCategoriesAmount(lastMonthPayments);
        Map<Category, Double> categoryCurrentMonthAmount =  getGroupedCategoriesAmount(currentMonthPayments);
        return filterUnusualPayments(categoryLastMonthAmount, categoryCurrentMonthAmount);
    }

    public static List<Payment> filterUnusualPayments(Map<Category, Double> categoryLastMonthAmount, Map<Category, Double> categoryCurrentMonthAmount) {
        return categoryCurrentMonthAmount.entrySet().stream()
                .filter(entry -> {
                    Double lastMonthCategoryAmount = categoryLastMonthAmount.getOrDefault(entry.getKey(), 0.0);
                    Double currentMonthCategoryAmount = entry.getValue();
                    return currentMonthCategoryAmount >= THRESHOLD * lastMonthCategoryAmount;
                })
                .map(entry ->  new Payment(entry.getValue(), "Total", entry.getKey()))
                .collect(Collectors.toList());
    }

    public static Map<Category, Double> getGroupedCategoriesAmount(List<Payment> payments) {
        Map<Category, Double> categoryAmount = new HashMap<Category, Double>();
        for (Payment payment : payments) {
            Double amountInMap = categoryAmount.getOrDefault(payment.getCategory(), 0.0);
            categoryAmount.put(payment.getCategory(), amountInMap + payment.getAmount());
        }
        return categoryAmount;
    }
}
