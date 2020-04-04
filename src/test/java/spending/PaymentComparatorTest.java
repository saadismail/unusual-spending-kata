package spending;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PaymentComparatorTest {

    @Test
    public void getPaymentsWithOverspending() {

        PaymentComparator paymentComparator = new PaymentComparator();

        PaymentsOfCurrentAndPreviousMonth paymentsOfCurrentAndPreviousMonth = new PaymentsOfCurrentAndPreviousMonth();

        List<Payment> currentMonthPayments = Arrays.asList(
          new Payment(50)
        );
        paymentsOfCurrentAndPreviousMonth.setCurrentMonth(currentMonthPayments);

        List<Payment> previousMonthPayments = Arrays.asList(
          new Payment(10)
        );
        paymentsOfCurrentAndPreviousMonth.setPreviousMonth(previousMonthPayments);

        PaymentsWithOverspending paymentsWithOverspendingActual =
                paymentComparator.getPaymentsWithOverspending(paymentsOfCurrentAndPreviousMonth);

        PaymentsWithOverspending paymentsWithOverspendingExpected = new PaymentsWithOverspending(50);
        assertEquals(paymentsWithOverspendingExpected, paymentsWithOverspendingActual);
    }

}