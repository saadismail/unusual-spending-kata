package spending;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class PaymentServiceTest {

    @Test
    public void getPaymentsWithOverspending() {

        PaymentDataSource paymentDataSource = mock(PaymentDataSource.class);
        PaymentComparator paymentComparator = mock(PaymentComparator.class);

        PaymentService paymentService = new PaymentService(paymentDataSource, paymentComparator);

        final long userId = 1;

        PaymentsOfCurrentAndPreviousMonth paymentsOfCurrentAndPreviousMonth
                = mock(PaymentsOfCurrentAndPreviousMonth.class);
        when(paymentDataSource.fetch(userId)).thenReturn(paymentsOfCurrentAndPreviousMonth);

        ArgumentCaptor<PaymentsOfCurrentAndPreviousMonth> paymentsOfCurrentAndPreviousMonthArgumentCaptor =
                forClass(PaymentsOfCurrentAndPreviousMonth.class);

        paymentService.getPaymentsWithOverspending(userId);

        verify(paymentComparator)
                .getPaymentsWithOverspending(paymentsOfCurrentAndPreviousMonthArgumentCaptor.capture());

        PaymentsWithOverspending paymentsWithOverspending = mock(PaymentsWithOverspending.class);
        when(paymentComparator.getPaymentsWithOverspending(paymentsOfCurrentAndPreviousMonth))
                .thenReturn(paymentsWithOverspending);

        assertEquals(paymentsOfCurrentAndPreviousMonth, paymentsOfCurrentAndPreviousMonthArgumentCaptor.getValue());

    }

}