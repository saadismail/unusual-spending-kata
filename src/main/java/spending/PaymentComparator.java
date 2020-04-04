package spending;

public class PaymentComparator {
    public PaymentsWithOverspending getPaymentsWithOverspending(
            PaymentsOfCurrentAndPreviousMonth paymentsOfCurrentAndPreviousMonth) {

        int previousMonthTotalAmount = paymentsOfCurrentAndPreviousMonth.getPreviousMonthTotal();
        int currentMonthTotalAmount = paymentsOfCurrentAndPreviousMonth.getCurrentMonthTotal();

        if(currentMonthTotalAmount >= previousMonthTotalAmount * 1.5) {
            return new PaymentsWithOverspending(currentMonthTotalAmount);
        }

        return new PaymentsWithOverspending(0);
    }
}
