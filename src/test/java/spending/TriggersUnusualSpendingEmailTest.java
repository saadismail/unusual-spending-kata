package spending;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class TriggersUnusualSpendingEmailTest {

    @Test
    public void triggerTest() {
        long userId = 1;

        PaymentService paymentService = mock(PaymentService.class);
        EmailGateway emailGateway = mock(EmailGateway.class);

        TriggersUnusualSpendingEmail triggersUnusualSpendingEmail =
                new TriggersUnusualSpendingEmail(paymentService, emailGateway);

        PaymentsWithOverspending paymentsWithOverspending = mock(PaymentsWithOverspending.class);
        when(paymentService.getPaymentsWithOverspending(userId)).thenReturn(paymentsWithOverspending);

        ArgumentCaptor<PaymentsWithOverspending> paymentWithOverspendingCaptor =
                forClass(PaymentsWithOverspending.class);

        triggersUnusualSpendingEmail.trigger(userId);

        verify(emailGateway).sendEmail(paymentWithOverspendingCaptor.capture());
    }

}
