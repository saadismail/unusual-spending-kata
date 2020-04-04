package spending;

import java.util.List;

public class EmailGenerator {
    public static String generateUnusualPaymentEmail(long userId, List<Payment> unusualPayments) {
        String content = "Hello " + userId + "\n";
        content += "We have detected unusually high spending in the following categories:\n";

        for (Payment payment : unusualPayments) {
            content += "You spent $" + payment.getAmount() + " on " + payment.getCategory() + "\n";
        }

        content += "Regards\n";
        content += "The Credit Card Company";

        return content;
    }
}
