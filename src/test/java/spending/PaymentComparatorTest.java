package spending;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentComparatorTest {

    @Test
    public void getPaymentsWithOverspending() {

        PaymentComparator paymentComparator = new PaymentComparator();
        PaymentsWithOverspending paymentsWithOverspendingActual =
                paymentComparator.getPaymentsWithOverspending(new PaymentsOfCurrentAndPreviousMonth());

        PaymentsWithOverspending paymentsWithOverspendingExpected = new PaymentsWithOverspending();
        assertEquals(paymentsWithOverspendingExpected, paymentsWithOverspendingActual);
    }

}