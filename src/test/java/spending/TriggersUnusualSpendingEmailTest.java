package spending;

import org.junit.Test;

import java.util.List;

public class TriggersUnusualSpendingEmailTest {

    @Test
    public void triggerTest() {
        long userId = 1;
        int year = 2016;
        int month = 8;

        List<Payment> payments = PaymentDataSource.fetch(userId, year, month);
    }

}
