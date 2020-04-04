package spending;

import org.junit.Test;

public class TriggersUnusualSpendingEmailTest {

    @Test
    public void triggerTest() {
        long userId = 1;

        PaymentsOfCurrentAndPreviousMonth paymentsOfCurrentAndPreviousMonth = PaymentDataSource.fetch(userId);
        PaymentsWithOverspending paymentsWithOverspending = PaymentComparator.compare(paymentsOfCurrentAndPreviousMonth);
    }

}
