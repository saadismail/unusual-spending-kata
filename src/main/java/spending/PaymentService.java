package spending;

public class PaymentService {
    private final PaymentDataSource paymentDataSource;
    private final PaymentComparator paymentComparator;

    public PaymentService(PaymentDataSource paymentDataSource, PaymentComparator paymentComparator) {
        this.paymentDataSource = paymentDataSource;
        this.paymentComparator = paymentComparator;
    }

    public PaymentsWithOverspending getPaymentsWithOverspending(long userId) {

        PaymentsOfCurrentAndPreviousMonth paymentsOfCurrentAndPreviousMonth =
                paymentDataSource.fetch(userId);

        paymentComparator.getPaymentsWithOverspending(paymentsOfCurrentAndPreviousMonth);
        return new PaymentsWithOverspending();
    }
}
