package spending;

import org.junit.Test;
import org.mockito.Mockito;

public class TriggersUnusualSpendingEmailTest {

    @Test
    public void triggerTest() {
        long userId = 1;


        PaymentDataSource paymentDataSource = Mockito.mock(PaymentDataSource.class);
        PaymentComparator paymentComparator = Mockito.mock(PaymentComparator.class);
        EmailGateway emailGateway = Mockito.mock(EmailGateway.class);

        TriggersUnusualSpendingEmail triggersUnusualSpendingEmail = new TriggersUnusualSpendingEmail();

        PaymentsOfCurrentAndPreviousMonth paymentsOfCurrentAndPreviousMonth = paymentDataSource.fetch(userId);

        PaymentsWithOverspending paymentsWithOverspending = paymentComparator.compare(paymentsOfCurrentAndPreviousMonth);

        emailGateway.sendEmail(paymentsWithOverspending);
    }

}
